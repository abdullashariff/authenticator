package com.akiro.authenticator.controllers.service.impl;

import com.akiro.authenticator.controllers.service.AuthenticatorService;
import com.akiro.authenticator.controllers.service.GeneratorService;
import com.akiro.authenticator.controllers.service.ValidatorService;
import org.springframework.stereotype.Service;


@Service
public class AuthenticatorServiceImpl implements AuthenticatorService {

    private final ValidatorService validatorService;

    private final GeneratorService generatorService;

    public AuthenticatorServiceImpl(ValidatorService validatorService, GeneratorService generatorService) {
        this.validatorService = validatorService;
        this.generatorService = generatorService;
    }

    @Override
    public String generateAuthToken(String availableDigits) {
        return generatorService.generateToken(availableDigits);
    }

    @Override
    public Boolean isValidAuthToken(String token, String availableDigits) {
        return validatorService.isValidToken(token, availableDigits);
    }
}
