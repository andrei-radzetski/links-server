package com.andreiradzetski.links.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Andrei Radzetski
 * @since 11.12.2017
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth
        .inMemoryAuthentication()
          .withUser("admin").password("admin").roles("ADMIN", "USER", "ACTUATOR")
        .and()
          .withUser("user").password("user").roles("USER");
  }
}
