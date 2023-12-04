package config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableOAuth2Sso
public class ResourceServerConfig extends WebSecurityConfigurerAdapter   {
	
   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }
   
   @Override
   public void configure(HttpSecurity http) throws Exception {
	    http.headers().frameOptions().sameOrigin();
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/test").authenticated();
		http.authorizeRequests().antMatchers("/secure-login").authenticated();
		http.authorizeRequests().antMatchers("/**").permitAll();
		
    }
   
}
