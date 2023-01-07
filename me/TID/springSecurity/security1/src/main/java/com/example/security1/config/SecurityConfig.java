package com.example.security1.config;
/**
 * // 구글 로그인이 완료된 뒤의 후처리가 필요함.
 * 1. 코드받기(인증)
 * 2. 엑세스 토큰
 * 3. 사용자 프로필 정보를 가져오고
 * 4-1. 그 정보를 토대로 회원가입을 진행시키기도 함
 * 4-2. (이메일,전화번호,이름,아이디) 쇼핑몰 ->(집주소), 백화점몰 -> (vip등급, 일반등급)
 */

import com.example.security1.auth.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 동록이 됩니다.
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

//    @Bean
//    public BCryptPasswordEncoder encodePwd() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() // 인증만 되면 들어갈 수 있은 주소!
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login") // login 주소가 호출이 되면 시쿠리티가 낚아채서 대신 로그인 합니다.
                .defaultSuccessUrl("/")
                .and()
                .oauth2Login()
                .loginPage("/loginForm")
                .userInfoEndpoint()
                .userService(principalOauth2UserService); // 구글 로그인이 완료된 뒤의 후처리가 필요함. Tip. 코드x( 엑세스토큰 + 사용자프로필정보 O)


    }
}
