package com.harish.DataBase.WebConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.harish.DataBase.Filter.JwtFilter;
import com.harish.DataBase.Service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private MyUserDetailsService myUserDetailsService ;
	
	@Autowired
	private JwtFilter jwtFilter ;
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    return	http
    	      .csrf(customizer -> customizer.disable())
    	      .authorizeHttpRequests(request->request
    	    		  .requestMatchers("signup","login","jobs/**","favourites","apply/**","user/**","admin/**")
    	    		  .permitAll()
    	    		  .anyRequest().authenticated())
    	    // .formLogin(Customizer.withDefaults())
    	      .httpBasic(Customizer.withDefaults())
    	      .oauth2Login(Customizer.withDefaults())
    	      .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    		  .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
    	      .build() ;
		
	}
    
//    @Bean
//    UserDetailsService userDetailsService() {
//    	
//    	
//    	
//		return new InMemoryUserDetailsManager();
//    	
//    }
    
    @Bean
    AuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
    //	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    	provider.setUserDetailsService(myUserDetailsService);
		return provider;
    	
    }
    
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	return config.getAuthenticationManager() ;
    }
    
    
    
}