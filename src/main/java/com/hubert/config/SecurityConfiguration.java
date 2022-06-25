package com.hubert.config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.cors().configurationSource(new CorsConfigurationSource() {

			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration cors = new CorsConfiguration();
				cors.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
				cors.setAllowCredentials(true);
				cors.setAllowedHeaders(Collections.singletonList("*"));
				cors.setAllowedMethods(Collections.singletonList("*"));
				cors.setMaxAge(3600L);
				return cors;
			}
		}).and().authorizeHttpRequests((auth) -> auth.antMatchers("/courses", "/books", "/freebies", "/")
				.authenticated().antMatchers("/whyus").permitAll()).formLogin().and()
				.httpBasic(Customizer.withDefaults());

		return http.build();
	}

	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsService() {
	 * InMemoryUserDetailsManager userDetailsService = new
	 * InMemoryUserDetailsManager(); UserDetails admin =
	 * User.withUsername("hubert").password("hubert").authorities("admin").build();
	 * UserDetails user =
	 * User.withUsername("lemuel").password("lemuel").authorities("user").build();
	 * userDetailsService.createUser(admin); userDetailsService.createUser(user);
	 * return userDetailsService; }
	 * 
	 * 
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
