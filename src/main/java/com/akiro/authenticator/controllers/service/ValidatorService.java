package com.akiro.authenticator.controllers.service;

import org.springframework.stereotype.Component;

@Component
public class ValidatorService {

    public boolean isValidToken(String token, String availableDigits) {
        // Remove hyphens and spaces, if any
        token = token.replaceAll("-", "").replaceAll(" ", "");

        if (token.length() != 16) {
            return false; // Token should be exactly 16 digits
        }

        for (char digit : token.toCharArray()) {
            if (!Character.isDigit(digit) || !isDigitAvailable(digit, availableDigits)) {
                return false; // Token contains an invalid or unavailable digit
            }
        }

        // Validate using the Luhn algorithm (credit card validation)
        return isLuhnValid(token);
    }

    private boolean isDigitAvailable(char digit, String availableDigits) {
        return availableDigits.indexOf(digit) != -1;
    }

    private boolean isLuhnValid(String token) {
        int sum = 0;
        boolean alternate = false;

        for (int i = token.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(token.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        return (sum % 10) == 0;
    }
}
