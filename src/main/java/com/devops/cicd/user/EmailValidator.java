package com.devops.cicd.user;

public final class EmailValidator {

    public static void validate(String email) {
        // 1. Obligatoire (non null, non vide après trim)
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("email must be valid");
        }

        String trimmedEmail = email.trim();

        // 2. Doit contenir exactement un seul caractère @
        long atCount = trimmedEmail.chars().filter(ch -> ch == '@').count();
        if (atCount != 1) {
            throw new IllegalArgumentException("email must be valid");
        }

        // 3. Doit contenir au moins un . après le @
        int atIndex = trimmedEmail.indexOf('@');
        String domainPart = trimmedEmail.substring(atIndex + 1);

        if (!domainPart.contains(".")) {
            throw new IllegalArgumentException("email must be valid");
        }

        // 4. Cas limites (ex: "@test.com" ou "alice@.")
        if (atIndex == 0 || domainPart.startsWith(".")) {
            throw new IllegalArgumentException("email must be valid");
        }
    }
}
