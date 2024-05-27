-- Adicionar a coluna "ativo" com valor padrão true
ALTER TABLE medicos ADD COLUMN ativo BOOLEAN DEFAULT true NOT NULL;
