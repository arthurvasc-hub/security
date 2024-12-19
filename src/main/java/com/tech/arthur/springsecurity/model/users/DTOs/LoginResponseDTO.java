package com.tech.arthur.springsecurity.model.users.DTOs;

/**
 * DTO de resposta para login.
 *
 * @param token token JWT gerado após autenticação bem-sucedida.
 */
public record LoginResponseDTO(String token) {
}
