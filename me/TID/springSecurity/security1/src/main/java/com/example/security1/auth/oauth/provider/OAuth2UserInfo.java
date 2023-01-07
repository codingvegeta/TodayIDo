package com.example.security1.auth.oauth.provider;

public interface OAuth2UserInfo {
    String getProviderId();

    String getProvider();

    String getEmail();

    String getName();
}
