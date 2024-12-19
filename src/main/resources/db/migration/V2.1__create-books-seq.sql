-- V2.1__create-books-seq.sql

-- Criando a sequência 'books_seq' para ser usada em futuras migrações ou inserções de dados.
-- Esta sequência começa em 1 e incrementa por 1 a cada novo valor.

CREATE SEQUENCE books_seq START 1 INCREMENT 1;

