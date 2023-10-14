package com.akiro.authenticator.controllers.dto;

import javax.validation.constraints.Pattern;

public class GenerateTokenResponse {

    @Pattern(regexp = "^[0-9]{6,12}$",
            message = "tokenToValidate")
    private String tokenToValidate;

    public String getTokenToValidate() {
        return tokenToValidate;
    }

    public void setTokenToValidate(String tokenToValidate) {
        this.tokenToValidate = tokenToValidate;
    }
}
