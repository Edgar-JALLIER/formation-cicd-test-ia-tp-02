package com.devops.cicd.user;

import com.devops.cicd.PasswordPolicy;

public class User {
    private final String email;
    private final String password;
    private final Role role;

    public User(String email, String password, Role role) {
        EmailValidator.validate(email);
        validatePassword(password);    
        validateRole(role);

        this.email = email.trim();
        this.password = password;
        this.role = role;
    }


    private void validatePassword(String password) {
        if (password == null || password.trim().isEmpty() || !PasswordPolicy.isStrong(password)) {
            throw new IllegalArgumentException("password must be strong");
        }
    }

    private void validateRole(Role role) {
        if (role == null) throw new IllegalArgumentException("role must not be null");
    }

    public boolean canAccessAdminArea() {
        return this.role == Role.ADMIN;
    }

    // Getters
    public String getEmail() { return email; }
    public Role getRole() { return role; }
}
