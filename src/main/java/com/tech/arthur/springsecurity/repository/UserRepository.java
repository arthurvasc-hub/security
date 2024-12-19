package com.tech.arthur.springsecurity.repository;

import com.tech.arthur.springsecurity.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repositório para a entidade {@link User}.
 *
 * Este repositório estende {@link JpaRepository}, fornecendo operações básicas de CRUD para a entidade {@link User}.
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Encontra um usuário pelo nome de usuário.
     *
     * @param username nome de usuário a ser procurado.
     * @return um {@link Optional} contendo o usuário se encontrado, ou vazio caso contrário.
     */
    Optional<User> findByUsername(String username);
}
