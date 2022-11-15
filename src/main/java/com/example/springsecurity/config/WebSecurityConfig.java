package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "hello").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .httpBasic();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        /**
         * 해당 방법으로의 패스워드 인코딩을 하지 않고 회피하는 방법은 절대로 하지 않아야한다.
         * 현재에는 테스트를 위해 옵션을 준 것 뿐이다.
         *  return NoOpPasswordEncoder.getInstance();
         */
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
