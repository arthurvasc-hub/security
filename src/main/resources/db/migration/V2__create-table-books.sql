-- V2.0__create-table-books.sql

-- Criando a tabela 'books' para armazenar informações sobre livros
-- A tabela inclui os seguintes campos:
-- - 'id': identificador único do livro, do tipo BIGINT, não nulo e chave primária.
-- - 'title': título do livro, que deve ser único e não nulo.
-- - 'author': nome do autor do livro, não nulo.
-- - 'description': descrição do livro, não nula.

CREATE TABLE books (
                       id BIGINT PRIMARY KEY UNIQUE NOT NULL,   -- Chave primária do tipo BIGINT, única e não nula.
                       title TEXT UNIQUE NOT NULL,              -- Título do livro, único e não nulo.
                       author TEXT NOT NULL,                    -- Autor do livro, obrigatório.
                       description TEXT NOT NULL                -- Descrição do livro, obrigatória.
);
