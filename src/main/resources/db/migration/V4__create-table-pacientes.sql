-- V1__Create_pacientes_table.sql

CREATE TABLE pacientes (
                           id SERIAL PRIMARY KEY,
                           nome VARCHAR(255) NOT NULL,
                           email VARCHAR(255) NOT NULL,
                           cpf VARCHAR(11) NOT NULL,
                           logradouro VARCHAR(100) NOT NULL,
                           bairro VARCHAR(100) NOT NULL,
                           cep VARCHAR(9) NOT NULL,
                           complemento VARCHAR(100),
                           numero VARCHAR(20),
                           uf CHAR(2) NOT NULL,
                           cidade VARCHAR(100) NOT NULL,
                           ativo BOOLEAN NOT NULL DEFAULT TRUE
);
