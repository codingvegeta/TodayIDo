package com.cos.jwt.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.jwt.config.auth.PrincipalDetails;
import com.cos.jwt.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

//스프링 시큐리티에서 UsernamePasswordAuthenticationFilter 가 있음
//login 요청에서 username,password 전송하면 (post)
//UsernamePasswordAuthenticationFilter 작동 함
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    // /login 요청을 하면 로그인 시도를 위해서 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter : 로그인 시도함");

        // 1. username, password 받아서
        try {

            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(request.getInputStream(), User.class);
            System.out.println(user);

            System.out.println("이것이 로그인 검사인가?1");
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            System.out.println("이것이 로그인 검사인가?2");
            // principalDetailsService의 loadUserByUsername() 함수가 실행된 후 정상이면 authentication 리턴됨
            // DB에 있는 username과 password가 일치한다.
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);


            // authentication 갹채가 session 영역에 저장됨. => 로그인이 되었다는 뜻.
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            System.out.println(principalDetails.getUser().getUsername());
            System.out.println("1======================================");

            //authentication 객체가 session 영역에 저장을 해야 하고 그 방법이 return 해주면 됨.
            //return의 이유는 권한 관리를 security가 대신 해주기 때문에 편하려고 하는거임.
            //굳이 JWT 토큰을 사용하면서 세션을 만들 이유가 없음. 근데 단지 권한 처리때문에 session 넣어줍니다.


            return authentication;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //attemptAuthentication실행 후 인증이 정상적으로 되었으면 successfulAuthentication 함수가 실행
    // JWT 토큰을 만들어서 request요청한 사용자에세 JWT 토큰을 response 해주면 됨.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("successfulAuthentication 실행됨 : 인증이 완료되었다는 뜻임 ");
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

        // RSA방식은 아니고 HASH암호 방식
        String jwtToken = JWT.create()
                .withSubject(principalDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000 * 10)))
                .withClaim("id", principalDetails.getUser().getId())
                .withClaim("username", principalDetails.getUser().getUsername())
                .sign(Algorithm.HMAC512("cos"));

        response.addHeader("Authorization", "Bearer " + jwtToken);
    }
}
