package com.strannikov.javariga13ex.ex12;
//Create a project based on Spring Boot using:
//
//        spring-boot-starter-web
//        spring-boot-starter-security
//        spring-boot-starter-data-jpa
//        h2
//        lombok
//
//        Create the application's security configuration, where:
//
//        the GET/api/cars path requires you to have theADMIN or CARS role
//        the POST/api/cars path requires you to login
//        paths starting with /api/users/ require authority ROLE_USER_ADMIN
//        all other paths do not require authentication
//        possible ways to log in are Basic Authentication and an automatically generated login form
//        it is possible to log out
//        the h2 console is available and working properly
//        CSRF is not generated on paths starting with /api/
//
//        In addition, there are 3 users whose data is stored in memory:
//
//        user admin with the rolesADMIN and CARS
//        user admin2 with authorityROLE_USER_ADMIN
//        user admin3 with roleCARS
//
//        Each user has the password Secret_123. Bean passwordEncoder is not directly defined, yet users should be able to log into secured paths.


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Profile("ex12")
@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/cars").hasAnyRole("ADMIN", "CARS")
                .antMatchers(HttpMethod.POST, "/api/cars").authenticated()
                .antMatchers("api/users/**").hasAuthority("ROLE_USER_ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout()
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().ignoringAntMatchers("/api/**");;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN","CARS")
                .and()
                .withUser("admin2")
                .password("{noop}123")
                .authorities("ROLE_USER_ADMIN")
                .and()
                .withUser("admin3")
                .password("{noop}123")
                .roles("CARS");
    }
}
