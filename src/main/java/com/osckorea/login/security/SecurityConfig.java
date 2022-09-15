package com.osckorea.login.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/","/registry","/login", "/css/**").permitAll()
                .antMatchers("/member/**").authenticated() // 일반사용자 접근 가능
                .antMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN") // 매니저, 관리자 접근 가능
                .antMatchers("/admin/**").hasRole("ADMIN"); // 관리자만 접근 가능
        http.formLogin().loginPage("/login").defaultSuccessUrl("/", true);
        http.formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/", true);
        http.exceptionHandling().accessDeniedPage("/forbidden");
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
        http.userDetailsService(userDetailsService);
    }
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
