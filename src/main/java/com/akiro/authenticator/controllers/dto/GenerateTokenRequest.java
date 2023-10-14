package com.akiro.authenticator.controllers.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class GenerateTokenRequest implements Serializable {

    @Pattern(regexp = "^[0-9]{0,9}$",
            message = "only number allowed")
    @NotBlank(message = "only number allowed")
    private String availableDigits;

    public String getAvailableDigits() {
        return availableDigits;
    }
    public void setAvailableDigits(String availableDigits) {
        this.availableDigits = availableDigits;
    }

}
