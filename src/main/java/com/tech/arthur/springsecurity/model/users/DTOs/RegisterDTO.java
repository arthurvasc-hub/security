package com.tech.arthur.springsecurity.model.users.DTOs;

import com.tech.arthur.springsecurity.model.users.Role;

/**
 * DTO para registro de novos usuários.
 *
 * @param username nome de usuário escolhido.
 * @param password senha do usuário.
 * @param role função do usuário (exemplo: ADMIN ou USER).
 */
public record RegisterDTO(String username, String password, Role role) {
}
