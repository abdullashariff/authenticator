package com.akiro.authenticator.controllers.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GeneratorService {


    public String generateToken(String availableDigits) {
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            token.append(generateRandomPart(availableDigits));
            if (i < 3) {
                token.append("-");
            }
        }

        return token.toString();
    }

    private  String generateRandomPart(String availableDigits) {
        Random random = new Random();
        StringBuilder part = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(availableDigits.length());
            char randomDigit = availableDigits.charAt(randomIndex);
            part.append(randomDigit);
        }

        return part.toString();
    }
}
