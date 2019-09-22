package org.randall.teagan.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class CapstoneProjectSecurity extends WebSecurityConfigurerAdapter {

    private static final String CUSTOMER_ROLE = "CUSTOMER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("customer")
                .password(encoder().encode("123456"))
                .roles(CUSTOMER_ROLE)
                .and()
                .withUser("admin")
                .password(encoder().encode("admin"))
                .roles(ADMIN_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/capstone/**/create/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "capstone/**/getall/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "capstone/**/read/**").hasRole(ADMIN_ROLE)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}

