package com.example.security1.auth;

import com.example.security1.auth.oauth.PrincipalOauth2UserService;
import com.example.security1.model.User;
import com.example.security1.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessingUrl ("/login")
// login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어있는 loadUserByUsername 함수가 실행
@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    // 시큐리티 session(내부 Authentication(내부 UserDetails))
    // 함수 종료시 @AuthenticationPrincipal 애노테이션이 만들어진다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        log.info("userEntity {}",userEntity.toString());
        if (userEntity != null) {
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
