package com.authentication.auth_projet.dto;

public record RegisterRequest(String username, String pass_hash, String role) {
}
