package com.walmart.api.eureka;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	@Bean
	public SecurityFilterChain defaultConfiguration(HttpSecurity http) throws Exception {
		http.csrf(c->c.disable()) //Disable csrf
		.authorizeHttpRequests(request->request.requestMatchers("/**").authenticated())// any request to any user must be authenticated
		.httpBasic(Customizer.withDefaults()); // use http basic for authentication
		return http.build();
		
	}
}
