package com.devops.cicd;

public class PasswordPolicy {
    public static boolean isStrong(String password) {
        if (password == null || password.trim().length() < 8) return false;
        return password.matches(".*[A-Z].*") && 
               password.matches(".*[a-z].*") && 
               password.matches(".*[0-9].*") && 
               password.matches(".*[^a-zA-Z0-9].*");
    }
}
