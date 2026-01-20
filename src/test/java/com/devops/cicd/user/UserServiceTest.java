package com.devops.cicd.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Tests Fonctionnels - UserService")
class UserServiceTest {

    private final UserService userService = new UserService();
    private final String VALID_PWD = "Valid123!";

    @Test
    @DisplayName("Scénario : Enregistrement réussi d'un administrateur")
    void shouldRegisterValidAdmin() {
        // Given
        String email = " super-admin@dev.com ";
        
        // When
        User registeredUser = userService.register(email, VALID_PWD, Role.ADMIN);

        // Then
        assertNotNull(registeredUser);
        assertEquals("super-admin@dev.com", registeredUser.getEmail(), "L'email doit être trimé");
        assertEquals(Role.ADMIN, registeredUser.getRole());
        assertTrue(registeredUser.canAccessAdminArea());
    }

    @Test
    @DisplayName("Scénario : Échec d'enregistrement si données invalides")
    void shouldPropagateExceptionWhenDataIsInvalid() {
        // On vérifie que le service propage bien l'erreur de domaine
        assertThrows(IllegalArgumentException.class, () -> {
            userService.register("invalid-email", VALID_PWD, Role.USER);
        });
    }
    
    @Test
    @DisplayName("Scénario : Le rôle ne doit pas être null")
    void shouldThrowExceptionIfRoleIsNull() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            userService.register("test@test.com", VALID_PWD, null);
        });
        assertEquals("role must not be null", ex.getMessage());
    }
}
