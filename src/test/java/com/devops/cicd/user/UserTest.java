package com.devops.cicd.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests Unitaires - Classe User")
class UserTest {

    private final String VALID_PWD = "Valid123!"; // Respecte la PasswordPolicy

    @Nested
    @DisplayName("Validation de l'Email")
    class EmailValidation {

        @ParameterizedTest
        @ValueSource(strings = {"alice@test.com", "bob.smith@company.io", " user@space.fr "})
        @DisplayName("Devrait accepter les emails valides (et trim)")
        void shouldAcceptValidEmails(String validEmail) {
            User user = new User(validEmail, VALID_PWD, Role.USER);
            assertEquals(validEmail.trim(), user.getEmail());
        }

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "alice", "alice@", "@test.com", "alice@test", "alice@@test.com"})
        @DisplayName("Devrait lever une exception pour les emails invalides")
        void shouldThrowExceptionForInvalidEmails(String invalidEmail) {
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
                () -> new User(invalidEmail, VALID_PWD, Role.USER));
            assertEquals("email must be valid", ex.getMessage());
        }
    }

    @Nested
    @DisplayName("Validation du Password")
    class PasswordValidation {

        @Test
        @DisplayName("Devrait lever une exception si le mot de passe est faible")
        void shouldThrowExceptionForWeakPassword() {
            // Ici on simule un échec de PasswordPolicy.isStrong
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
                () -> new User("test@test.com", "123", Role.USER));
            assertEquals("password must be strong", ex.getMessage());
        }
    }

    @Nested
    @DisplayName("Autorisations (canAccessAdminArea)")
    class Authorization {

        @Test
        @DisplayName("ADMIN devrait avoir accès à la zone admin")
        void adminShouldHaveAccess() {
            User admin = new User("admin@test.com", VALID_PWD, Role.ADMIN);
            assertTrue(admin.canAccessAdminArea());
        }

        @Test
        @DisplayName("USER ne devrait PAS avoir accès à la zone admin")
        void userShouldNotHaveAccess() {
            User user = new User("user@test.com", VALID_PWD, Role.USER);
            assertFalse(user.canAccessAdminArea());
        }
    }
}