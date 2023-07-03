//package io.security.basicsecurity;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@Order(0)
//public class SecurityConfig1 {
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/admin/**")
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//
//        return http.build();
//    }
////
////    @Configuration
////    @Order(1)
////    class SecurityConfig2 {
////        @Bean
////        public SecurityFilterChain configure(HttpSecurity http) throws Exception {
////            http
////                    .authorizeRequests()
////                    .anyRequest().permitAll()
////                    .and()
////                    .formLogin();
////
////            return http.build();
////        }
////
////    }
//
//}
