package com.example.security1.auth.oauth;

import com.example.security1.auth.PrincipalDetails;
import com.example.security1.auth.oauth.provider.FacebookUserInfo;
import com.example.security1.auth.oauth.provider.GoogleUserInfo;
import com.example.security1.auth.oauth.provider.NaverUserInfo;
import com.example.security1.auth.oauth.provider.OAuth2UserInfo;
import com.example.security1.model.User;
import com.example.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    // 구글로 부터 받은 userRequest 데이터에 대한 후처리되는 함수
    // 함수 종료시 @AuthenticationPrincipal 애노테이션이 만들어진다.
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest.toString : " + userRequest.toString());
        System.out.println("getClientRegistration : " + userRequest.getClientRegistration());
        System.out.println("getAccessToken : " + userRequest.getAccessToken().getTokenValue());


        OAuth2User oauth2User = super.loadUser(userRequest);
        // 구글로그인 버튼 클릭-> 구글로그인창 -> 로그인을 완료 -> code를 리턴(Oauth-Client라이브러리)-> Access Token dycjd
        // userRequest 정보 -> 회원 프로필 받아야 함 (loadUser 함수) -> 구글로부터 회원프로필 받아준다.
        System.out.println("oauth2User.getAttributes : " + oauth2User.getAttributes());

        OAuth2UserInfo oAuth2UserInfo = null;
        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            System.out.println("구글 로그인 요청");
            oAuth2UserInfo = new GoogleUserInfo(oauth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")) {
            System.out.println("페이스북 로그인 요청");
            oAuth2UserInfo = new FacebookUserInfo(oauth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
            System.out.println("네이버 로그인 요청");
            oAuth2UserInfo = new NaverUserInfo((Map) oauth2User.getAttributes().get("response"));
        } else {
            System.out.println("우리는 구글과 페이스북과 네이버만 지원해요");
        }


        String provider = oAuth2UserInfo.getProvider(); // goolgle
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider + "_" + providerId;
        String password = bCryptPasswordEncoder.encode("겟인데어");
        String email = oAuth2UserInfo.getEmail();
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            System.out.println("OAuth 로그인이 최초입니다.");
            userEntity = User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);
        } else {
            System.out.println("로그인을 이미 한 적이 있습니다.");
        }

        //회원가입을 강제로 진행 예정
        return new PrincipalDetails(userEntity,oauth2User.getAttributes());
    }
}
