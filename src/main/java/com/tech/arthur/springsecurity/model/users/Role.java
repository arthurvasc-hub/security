package com.tech.arthur.springsecurity.model.users;

import lombok.Getter;

/**
 * Enumeração que representa os papéis dos usuários no sistema.
 *
 * <p>
 * Cada papel está associado a uma string que define o nome do papel.
 * </p>
 *
 * <ul>
 * <li><b>ADMIN</b>: Representa um usuário com privilégios de administrador.</li>
 * <li><b>USER</b>: Representa um usuário regular.</li>
 * </ul>
 */
@Getter
public enum Role {
    ADMIN("admin"),  // Papel de administrador
    USER("user");    // Papel de usuário regular

    private final String role;

    /**
     * Construtor para inicializar o papel com sua string correspondente.
     *
     * @param role nome do papel associado.
     */
    Role(String role) {
        this.role = role;
    }
}
