

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import com.core.fullstack.security.AuthenticatedUserRecord;
import com.core.fullstack.security.ApplicationSecurityService;

@Service
public class ApplicationSecurityServiceImpl implements ApplicationSecurityService {
	
	@Autowired
	Constant constant;
	
	public AuthenticatedUserRecord getAuthenticatedUserRecord(){
		if(SecurityContextHolder.getContext().getAuthentication() instanceof OAuth2Authentication){ 
			OAuth2Authentication auth = (OAuth2Authentication)SecurityContextHolder.getContext().getAuthentication(); 
			Map userPrincipalsDetails = (Map)((Map)auth.getUserAuthentication().getDetails()).get("principal");
			Map userDetails=(Map)((Map)auth.getUserAuthentication().getDetails()).get("details");
			userPrincipalsDetails.remove("enabled");
			userPrincipalsDetails.remove("credentialsNonExpired");
			userPrincipalsDetails.remove("accountNonLocked");
			userPrincipalsDetails.remove("accountNonExpired");
			userPrincipalsDetails.remove("authorities");
			if(userDetails!=null && userDetails.get("tokenValue")!=null) {
				userPrincipalsDetails.put("accessToken",userDetails.get("tokenValue"));
			}
			ObjectMapper oMapper = new ObjectMapper();
			return oMapper.convertValue(userPrincipalsDetails, AuthenticatedUserRecord.class);
		}
		return null;
	}
	
	public AuthenticatedUserRecord updateUserRecordInSessionContext(AuthenticatedUserRecord updatedUserRec){
		OAuth2Authentication auth = (OAuth2Authentication)SecurityContextHolder.getContext().getAuthentication();
		ObjectMapper oMapper = new ObjectMapper();
		((Map)auth.getUserAuthentication().getDetails()).put("principal",oMapper.convertValue(updatedUserRec, Map.class));
		
		return updatedUserRec;
	}
}
