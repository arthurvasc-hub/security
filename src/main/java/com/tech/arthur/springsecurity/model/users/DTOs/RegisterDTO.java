package com.tech.arthur.springsecurity.model.users.DTOs;

import com.tech.arthur.springsecurity.model.users.Role;

public record RegisterDTO(String username, String password, Role role) {
}
