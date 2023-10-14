package com.akiro.authenticator.controllers;

import com.akiro.authenticator.controllers.dto.GenerateTokenRequest;
import com.akiro.authenticator.controllers.dto.ValidateTokenRequest;
import com.akiro.authenticator.controllers.service.AuthenticatorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/authenticator")
public class AuthenticatorController {

    private final AuthenticatorService authenticatorService;

    AuthenticatorController(AuthenticatorService authenticatorService){
        this.authenticatorService=authenticatorService;
    }

    @PostMapping(value = "/generateToken")
    String generateAuthToken( @Valid @RequestBody GenerateTokenRequest request) {
        String token = authenticatorService.generateAuthToken(request.getAvailableDigits());
        System.out.println("Generated Token: " + token);
        return token;
    }

    // 4242-5454-5215-2352 - true
    @PutMapping(value = "/validateToken")
    Boolean verifyToken(@Valid @RequestBody ValidateTokenRequest validateTokenRequest) {
        boolean isValid = authenticatorService.isValidAuthToken(validateTokenRequest.getTokenToValidate(), validateTokenRequest.getAvailableDigits());
        System.out.println("Is Valid: " + isValid);
        return isValid;
    }

}
