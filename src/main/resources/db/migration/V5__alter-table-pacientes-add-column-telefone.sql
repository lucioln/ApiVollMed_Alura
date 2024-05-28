-- Adicionar a coluna com um valor padrão temporário
ALTER TABLE pacientes ADD COLUMN telefone VARCHAR(20) DEFAULT 'default_value';

-- Atualizar os registros existentes (opcional, se necessário, remova esta linha se todos os registros receberem o valor padrão)
-- UPDATE medicos SET telefone = 'default_value' WHERE telefone IS NULL;

-- Alterar a coluna para NOT NULL e remover o valor padrão se desejado
ALTER TABLE pacientes ALTER COLUMN telefone SET NOT NULL;
ALTER TABLE pacientes ALTER COLUMN telefone DROP DEFAULT;
