package com.strannikov.javariga13ex.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor

public class SecurityConf extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailService userDetailService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/login", "/webjars/**").permitAll()
                .antMatchers("/pc-game").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/pet", true)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", HttpMethod.GET.toString()))
                .and()
                .headers().frameOptions().disable();

        http.csrf().disable();
    }
    @Bean
     public BCryptPasswordEncoder encoder(){
            return new BCryptPasswordEncoder();

    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(BCryptPasswordEncoder encoder,CustomUserDetailService customUserDetailService){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(encoder());
        daoAuthenticationProvider.setUserDetailsService(customUserDetailService);
    return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("AndrewAdmin")
//                .password(encoder().encode("123qwe"))
//                .roles("ADMIN")
//                .and()
//                .withUser("Andrew")
//                .password(encoder().encode("123qwe"))
//                .roles("USER", "ADMIN");

        auth.authenticationProvider(authenticationProvider(encoder(),userDetailService));
    }
}
