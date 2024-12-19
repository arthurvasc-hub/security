package com.tech.arthur.springsecurity.config;

import com.tech.arthur.springsecurity.repository.UserRepository;
import com.tech.arthur.springsecurity.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro de segurança para interceptar requisições e validar o token JWT.
 */
@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    /**
     * Intercepta requisições, valida o token JWT e autentica o usuário.
     *
     * @param request Requisição HTTP.
     * @param response Resposta HTTP.
     * @param filterChain Cadeia de filtros HTTP.
     * @throws ServletException Exceção de filtro.
     * @throws IOException Exceção de entrada/saída.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recoverToken(request);
        if (token != null) {
            var login = tokenService.validateToken(token);
            var optionalUser = userRepository.findByUsername(login);

            if (optionalUser.isPresent()) {
                var user = optionalUser.get();
                var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * Recupera o token JWT do cabeçalho da requisição.
     *
     * @param request Requisição HTTP.
     * @return Token JWT, ou null se não estiver presente.
     */
    public String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
