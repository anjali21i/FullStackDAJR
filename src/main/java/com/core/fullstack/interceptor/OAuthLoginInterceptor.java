package com.core.fullstack.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.core.fullstack.security.ApplicationSecurityServiceImpl;
import com.core.fullstack.security.AuthenticatedUserRecord;
import com.core.fullstack.utils.Constant;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OAuthLoginInterceptor {
	
	@Autowired
    private ApplicationSecurityServiceImpl securityService;
	
	// @Autowired
	// Constant constant;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		AuthenticatedUserRecord userRecord = securityService.getAuthenticatedUserRecord();
    	if(userRecord == null && isLoginCookieExist(request)){
    		String requestUrl = request.getRequestURL().toString();
    		String queryString = request.getQueryString();
    		if(queryString != null && !"".equals(queryString))
    			requestUrl = requestUrl+"?"+queryString;
    		
    		// requestUrl = requestUrl.replace("http://localhost:" + constant.getSERVERPORT(), constant.getDOMAINURL());
    		// if(StringUtils.isEmpty(constant.getAPPENV()) || !constant.getAPPENV().equalsIgnoreCase("dev"))
    		// 	requestUrl = requestUrl.replace("http:", "https:");
    		// String encryptedUrl = EncDec.encrypt(requestUrl);
    		// response.addCookie(makeSecureLoginUrlCookie(request, encryptedUrl));
			// response.sendRedirect(constant.getDOMAINURL() + constant.getCONTEXTROOTURL() + "/secure-login?page="+encryptedUrl);
			return false;
    	}
		return true;
	}
	
	private boolean isLoginCookieExist(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; ++i) {
			//    if (Constant.ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE.equals(cookies[i].getName())) {
			// 	   return true;
			//    }
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
