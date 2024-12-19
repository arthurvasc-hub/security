package com.tech.arthur.springsecurity.services;

import com.tech.arthur.springsecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Serviço para carregar usuários do repositório {@link UserRepository}.
 *
 * Esta classe implementa a interface {@link UserDetailsService} e é responsável por carregar um {@link UserDetails} baseado no nome de usuário.
 */
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Construtor da classe {@link UserService}.
     *
     * @param userRepository repositório utilizado para buscar os usuários no banco de dados.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Carrega o usuário pelo nome de usuário.
     *
     * @param username nome de usuário a ser procurado.
     * @return um objeto {@link UserDetails} do usuário encontrado.
     * @throws UsernameNotFoundException se o usuário não for encontrado.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Usando Optional para evitar NullPointerException
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado com o username: " + username));
    }
}
