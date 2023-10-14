package com.akiro.authenticator.controllers.service;

public interface AuthenticatorService {
    String generateAuthToken(String availableDigits);

    Boolean isValidAuthToken(String token, String availableDigits);
}
