package com.core.fullstack.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import com.core.fullstack.security.AuthenticatedUserRecord;
import com.core.fullstack.utils.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.core.fullstack.security.ApplicationSecurityService;

@Service
public class ApplicationSecurityServiceImpl implements ApplicationSecurityService {

	@Autowired
	Constant constant;

	@Bean
	OAuth2AuthorizedClientManager authorizedClientManager(ClientRegistrationRepository clientRegistrationRepository,
			OAuth2AuthorizedClientRepository authorizedClientRepository) {

		OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
				.clientCredentials().build();

		DefaultOAuth2AuthorizedClientManager authorizedClientManager = new DefaultOAuth2AuthorizedClientManager(
				clientRegistrationRepository, authorizedClientRepository);
		authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

		return authorizedClientManager;
	}

//	@Bean
//	WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
//		ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client = new ServletOAuth2AuthorizedClientExchangeFilterFunction(
//				authorizedClientManager);
//		oauth2Client.setDefaultClientRegistrationId("custom");
//		return WebClient.builder().apply(oauth2Client.oauth2Configuration()).build();
//	}

	public AuthenticatedUserRecord getAuthenticatedUserRecord() {
		if (SecurityContextHolder.getContext().getAuthentication() instanceof OAuth2Authentication) {
			OAuth2Authentication auth = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
			Map userPrincipalsDetails = (Map) ((Map) auth.getUserAuthentication().getDetails()).get("principal");
			Map userDetails = (Map) ((Map) auth.getUserAuthentication().getDetails()).get("details");
			userPrincipalsDetails.remove("enabled");
			userPrincipalsDetails.remove("credentialsNonExpired");
			userPrincipalsDetails.remove("accountNonLocked");
			userPrincipalsDetails.remove("accountNonExpired");
			userPrincipalsDetails.remove("authorities");
			if (userDetails != null && userDetails.get("tokenValue") != null) {
				userPrincipalsDetails.put("accessToken", userDetails.get("tokenValue"));
			}
			ObjectMapper oMapper = new ObjectMapper();
			return oMapper.convertValue(userPrincipalsDetails, AuthenticatedUserRecord.class);
		}
		return null;
	}

	public AuthenticatedUserRecord updateUserRecordInSessionContext(AuthenticatedUserRecord updatedUserRec) {
		OAuth2Authentication auth = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
		ObjectMapper oMapper = new ObjectMapper();
		((Map) auth.getUserAuthentication().getDetails()).put("principal",
				oMapper.convertValue(updatedUserRec, Map.class));

		return updatedUserRec;
	}
}
