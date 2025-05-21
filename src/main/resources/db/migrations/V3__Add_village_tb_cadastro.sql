-- V3: Migrations para adicionar a coluna VILLAGE na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN village VARCHAR(255);