package br.com.intechsistemas.autenticador.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {
  
  @Autowired
  private SecurityFilter securityFilter;

  private static final String[] PERMIT_ALL_LIST = {
    "/swagger-ui/**",
    "/v3/api-docs/**",
    "/swagger-resources/**",
    "/actuator/**",
    "/auth/**",
    "/user/**",
  }; 


  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(auth -> {
        //auth.requestMatchers("/auth/login").permitAll()
        //    .requestMatchers("/unidade/").permitAll()
        auth.requestMatchers(PERMIT_ALL_LIST).permitAll();
        auth.anyRequest().authenticated();       
      })  
      .addFilterBefore(this.securityFilter, BasicAuthenticationFilter.class);
    ;
    
    return http.build();
  } 

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
