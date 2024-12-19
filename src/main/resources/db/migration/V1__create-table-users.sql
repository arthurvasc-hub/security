-- V1__create-table-users.sql

-- Criando a tabela 'users' para armazenar informações sobre usuários
-- A tabela inclui os seguintes campos:
-- - 'id': um identificador único do tipo UUID, não nulo e chave primária.
-- - 'username': nome de usuário único, não nulo.
-- - 'password': senha do usuário, não nula.
-- - 'role': cargo ou papel do usuário, que pode ser utilizado para controle de permissões.

CREATE TABLE users (
                       id UUID PRIMARY KEY UNIQUE NOT NULL,  -- Chave primária do tipo UUID, única e não nula.
                       username TEXT NOT NULL UNIQUE,        -- Nome de usuário único e não nulo.
                       password TEXT NOT NULL,               -- Senha do usuário, obrigatória.
                       role TEXT NOT NULL                    -- Papel do usuário (ex: 'admin', 'user'), obrigatório.
);
