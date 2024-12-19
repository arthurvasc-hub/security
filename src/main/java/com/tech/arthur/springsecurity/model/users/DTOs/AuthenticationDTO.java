package com.tech.arthur.springsecurity.model.users.DTOs;

/**
 * DTO para autenticação de usuários.
 *
 * @param username nome de usuário do cliente.
 * @param password senha do cliente.
 */
public record AuthenticationDTO(String username, String password) {
}
