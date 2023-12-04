package interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import security.AuthenticatedUserRecord;
import service.ApplicationSecurityService;

public class OAuthLoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
    private ApplicationSecurityService securityService;
	
	@Autowired
	Constant constant;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		AuthenticatedUserRecord userRecord = securityService.getAuthenticatedUserRecord();
    	if(userRecord == null && isLoginCookieExist(request)){
    		String requestUrl = request.getRequestURL().toString();
    		String queryString = request.getQueryString();
    		if(queryString != null && !"".equals(queryString))
    			requestUrl = requestUrl+"?"+queryString;
    		
    		requestUrl = requestUrl.replace("http://localhost:" + constant.getSERVERPORT(), constant.getDOMAINURL());
    		if(org.apache.commons.lang.StringUtils.isEmpty(constant.getAPPENV()) || !constant.getAPPENV().equalsIgnoreCase("dev"))
    			requestUrl = requestUrl.replace("http:", "https:");
    		String encryptedUrl = EncDec.encrypt(requestUrl);
    		response.addCookie(makeSecureLoginUrlCookie(request, encryptedUrl));
			response.sendRedirect(constant.getDOMAINURL() + constant.getCONTEXTROOTURL() + "/secure-login?page="+encryptedUrl);
			return false;
    	}
		return true;
	}
	
	private boolean isLoginCookieExist(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; ++i) {
			   if (Constant.ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE.equals(cookies[i].getName())) {
				   return true;
			   }
			}
		}
		return false;
	}
	
	private Cookie makeSecureLoginUrlCookie(HttpServletRequest request, String encUrl) {
		   Cookie cookie = new Cookie("encUrl", encUrl);
		   cookie.setMaxAge(10);
		   cookie.setPath("/");
		   if(!StringUtils.isEmpty(request.getServerName()) && !request.getServerName().equals("localhost")) {
				cookie.setDomain("my21iweb.com");
				cookie.setHttpOnly(true);
				cookie.setSecure(true);
		   }
		   return cookie;
	 }
}
