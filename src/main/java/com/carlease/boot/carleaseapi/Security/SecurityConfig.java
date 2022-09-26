package com.carlease.boot.carleaseapi.Security;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.carlease.boot.carleaseapi.Repository.UserRepository;

@Configuration

public class SecurityConfig{

	@Autowired private UserRepository userRepo;
    @Autowired private JwtTokenFilter jwtTokenFilter;
     

    
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
             
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            	
                return userRepo.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found"));
            }
        };
    }
     
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCryptVersion.$2Y);
    }
     
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
     
    
    
    
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
        .headers(headers -> headers
            .frameOptions(frameOptions -> frameOptions
                .sameOrigin()
            )
        );
        http.authorizeRequests()
                .antMatchers("/h2-console/**","/auth/login", "/docs/**", "/users").permitAll()
                .anyRequest().authenticated();
         
            http.exceptionHandling()
                    .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                HttpServletResponse.SC_UNAUTHORIZED,
                                ex.getMessage()
                            );
                        }
                );
         
        http.addFilterAt((Filter) jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
         
        return http.build();
	
    }
	
	
}
