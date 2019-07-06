package com.yfcld.ZoneSchoolAPI.config;

import com.yfcld.ZoneSchoolAPI.security.JwtAuthenticationFilter;
import com.yfcld.ZoneSchoolAPI.security.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/api/public").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().disable()
/*                .and()
                .formLogin()
                .successForwardUrl("/api/public/successful")
                .defaultSuccessUrl("/api/public/successful")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()*/
                .csrf().disable();
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder.encode("password"))
                .authorities("ROLE_USER");

        auth.inMemoryAuthentication()
                .withUser("test1")
                .password(passwordEncoder.encode("password1"))
                .authorities("ROLE_USER");

        auth.inMemoryAuthentication()
                .withUser("test2")
                .password(passwordEncoder.encode("password2"))
                .authorities("ROLE_USER");
    }




}
