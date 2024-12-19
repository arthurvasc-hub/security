package com.tech.arthur.springsecurity.controller;

import com.tech.arthur.springsecurity.services.TokenService;
import com.tech.arthur.springsecurity.model.users.DTOs.AuthenticationDTO;
import com.tech.arthur.springsecurity.model.users.DTOs.LoginResponseDTO;
import com.tech.arthur.springsecurity.model.users.DTOs.RegisterDTO;
import com.tech.arthur.springsecurity.model.users.User;
import com.tech.arthur.springsecurity.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável pelas operações de autenticação e registro de usuários.
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    /**
     * Endpoint para autenticação de usuários.
     * Realiza a validação das credenciais e gera um token JWT para acesso.
     *
     * @param data Dados de autenticação fornecidos pelo usuário.
     * @return Resposta contendo o token JWT ou erro em caso de falha na autenticação.
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var tokenUsernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = authenticationManager.authenticate(tokenUsernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    /**
     * Endpoint para registro de novos usuários.
     * Verifica se o nome de usuário já está em uso e cria uma nova conta com senha codificada.
     *
     * @param data Dados para registro do usuário.
     * @return Resposta contendo os dados do usuário criado ou erro em caso de conflito.
     */
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (userRepository.findByUsername(data.username()).isPresent())
            return ResponseEntity.badRequest().build();

        String passwordEncoded = passwordEncoder.encode(data.password());
        User newUser = new User(data.username(), passwordEncoded, data.role());
        userRepository.save(newUser);
        return ResponseEntity.ok(newUser);
    }
}
