package com.mabao.config;

import com.mabao.repository.UserRepository;
import com.mabao.util.security.MaBaoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserRepository userRepository;
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .formLogin().loginPage("/login").defaultSuccessUrl("/");
    http.logout().logoutSuccessUrl("/");
    http.authorizeRequests().regexMatchers("/user/.*").authenticated()
            .regexMatchers("/cart/showCart").authenticated()
            .regexMatchers("/person/passwordChange").authenticated();
  }
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setMessageSource(messageSource());
    auth.userDetailsService(new MaBaoUserService(userRepository)).passwordEncoder(new Md5PasswordEncoder());
    auth.authenticationProvider(provider);
  }

  @Bean
  public ReloadableResourceBundleMessageSource messageSource(){
    ReloadableResourceBundleMessageSource messageSource  = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("WEB-INF/loginMessages");
    return messageSource;
  }
}
