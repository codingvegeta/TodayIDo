package com.example.corespringsecurity.security.common;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

public class FormWebAuthenticationDetails extends WebAuthenticationDetails {

    private String secretkey;

    public FormWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        secretkey = request.getParameter("secret_key");
    }

    public String getSecretKey() {
        return secretkey;
    }


}
