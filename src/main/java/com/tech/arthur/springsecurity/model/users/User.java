package com.tech.arthur.springsecurity.model.users;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Classe que representa os usuários do sistema.
 *
 * <p>
 * Essa classe implementa a interface {@link UserDetails}, que é usada pelo
 * Spring Security para autenticação e controle de acesso.
 * </p>
 */
@Table(name = "users")
@Entity(name = "users")
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    /**
     * Identificador único do usuário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Nome de usuário do cliente.
     */
    private String username;

    /**
     * Senha do usuário.
     */
    private String password;

    /**
     * Papel associado ao usuário, definido pela enumeração {@link Role}.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    /**
     * Construtor para criar um novo usuário com username, senha e papel.
     *
     * @param username nome de usuário.
     * @param password senha do usuário.
     * @param role papel associado ao usuário.
     */
    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Construtor padrão necessário pelo JPA.
     */
    public User() {}

    /**
     * Retorna as autoridades concedidas ao usuário com base em seu papel.
     *
     * <p>
     * Se o papel for <b>ADMIN</b>, o usuário terá as seguintes autoridades:
     * <ul>
     * <li><b>ROLE_ADMIN</b></li>
     * <li><b>ROLE_USER</b></li>
     * </ul>
     * Caso contrário, o usuário terá apenas a autoridade <b>ROLE_USER</b>.
     * </p>
     *
     * @return lista de autoridades associadas ao usuário.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == Role.ADMIN)
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );

        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    /**
     * Retorna o nome de usuário do cliente.
     *
     * @return nome de usuário.
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Indica se a conta do usuário está expirada.
     *
     * @return {@code true}, pois não há controle de expiração de conta.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indica se a conta do usuário está bloqueada.
     *
     * @return {@code true}, pois não há controle de bloqueio de conta.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indica se as credenciais do usuário estão expiradas.
     *
     * @return {@code true}, pois não há controle de expiração de credenciais.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indica se a conta do usuário está habilitada.
     *
     * @return {@code true}, pois não há controle de desativação de conta.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Retorna a senha do usuário.
     *
     * @return senha.
     */
    @Override
    public String getPassword() {
        return this.password;
    }
}
