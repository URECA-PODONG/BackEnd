package com.ureca.sole_paradise.user.service;

import com.ureca.sole_paradise.user.db.dto.CustomOAuth2User;
import com.ureca.sole_paradise.user.db.dto.KakaoResponse;
import com.ureca.sole_paradise.user.db.dto.OAuth2Response;
import com.ureca.sole_paradise.user.db.entity.UserEntity;
import com.ureca.sole_paradise.user.db.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;

        if (registrationId.equals("kakao")) {
            oAuth2Response = new KakaoResponse(oAuth2User.getAttributes());
            Optional<UserEntity> user = userRepository.findByAccountEmail(oAuth2Response.getEmail());

            if(user.isPresent()) {
                return new CustomOAuth2User(oAuth2Response, "ROLE_USER", user.get().getUserId());
            } else {
                return new CustomOAuth2User(oAuth2Response, "ROLE_VALIDATE", 1); //
            }
//            user = loginAndJoin(oAuth2Response);
        } else {
            return null;
        }

    }
}