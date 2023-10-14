package com.akiro.authenticator.controllers.dto;

import javax.validation.constraints.Pattern;

public class ValidateTokenRequest {
    @Pattern(regexp = "^[0-9]{0,9}$",
            message = "only number allowed")
    private String availableDigits;

    private String tokenToValidate;

    public ValidateTokenRequest(String availableDigits, String tokenToValidate) {
        this.availableDigits = availableDigits;
        this.tokenToValidate = tokenToValidate;
    }

    public String getTokenToValidate() {
        return tokenToValidate;
    }

    public String getAvailableDigits() {
        return availableDigits;
    }
}