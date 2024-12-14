package com.tech.arthur.springsecurity.model.users;

public record RegisterDTO(String username, String password, Role role) {
}
