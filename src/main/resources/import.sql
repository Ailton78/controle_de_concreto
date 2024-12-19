INSERT INTO tb_user (name, email, password) VALUES ('Alex', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua das Flores', '123', 'Centro', 'São Paulo', 'SP', '01234-567');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua das Palmeiras', '45', 'Centro', 'São Paulo', 'SP', '01001-000');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Avenida Brasil', '1000', 'Jardim América', 'Rio de Janeiro', 'RJ', '22030-001');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua São Bento', '200', 'Centro', 'Belo Horizonte', 'MG', '30110-070');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua dos Três Corações', '123', 'Vila Santa Clara', 'Campinas', 'SP', '13040-100');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua das Flores', '800', 'Bairro das Acácias', 'São Paulo', 'SP', '04056-200');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Avenida Ipiranga', '10', 'República', 'São Paulo', 'SP', '01000-000');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua dos Girassóis', '200', 'Vila Progresso', 'São Paulo', 'SP', '01234-678');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua dos Jacarandás', '100', 'Jardim das Flores', 'São Paulo', 'SP', '01456-789');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Avenida Atlântica', '1200', 'Copacabana', 'Rio de Janeiro', 'RJ', '22070-002');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua da Paz', '150', 'São Francisco', 'Belo Horizonte', 'MG', '30200-010');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua das Acácias', '303', 'Vila Alvorada', 'Curitiba', 'PR', '80230-200');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua do Sol', '40', 'Vila Maria', 'São Paulo', 'SP', '02120-400');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Avenida Paulista', '1500', 'Bela Vista', 'São Paulo', 'SP', '01310-100');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua do Porto', '100', 'Centro', 'Florianópolis', 'SC', '88015-100');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua São João', '2000', 'Jardim São Paulo', 'São Paulo', 'SP', '02135-300');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Avenida dos Bandeirantes', '200', 'Vila Progredior', 'São Paulo', 'SP', '04344-200');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua das Orquídeas', '400', 'Vila Sofia', 'São Paulo', 'SP', '04683-800');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua 25 de Março', '900', 'Centro', 'São Paulo', 'SP', '01021-010');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua da Alegria', '555', 'Bairro Alto', 'Curitiba', 'PR', '80210-500');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Rua dos Pardais', '22', 'Vila Verde', 'Campinas', 'SP', '13045-200');
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES ('Avenida Rio Branco', '1550', 'Centro', 'Rio de Janeiro', 'RJ', '20040-100');


INSERT INTO tb_cliente (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('João Silva', '123.456.789-00', '(11) 98765-4321', 'joao.silva@email.com', 1);
INSERT INTO tb_cliente (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Carlos Oliveira', '123.456.789-10', '(11) 99876-5432', 'carlos.oliveira@email.com', 6);
INSERT INTO tb_cliente (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Ana Paula Silva', '987.654.321-00', '(21) 99988-7766', 'ana.silva@email.com', 2);
INSERT INTO tb_cliente (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Mariana Santos', '111.222.333-44', '(31) 91234-5678', 'mariana.santos@email.com', 3);
INSERT INTO tb_cliente (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Ricardo Almeida', '444.555.666-77', '(19) 99123-4567', 'ricardo.almeida@email.com', 4);
INSERT INTO tb_cliente (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Joana Souza', '555.666.777-88', '(11) 93456-7890', 'joana.souza@email.com', 5);

INSERT INTO tb_fornecedor (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Fornecedor XYZ', '12.345.678/0001-99', '(11) 23456-7890', 'contato@xyz.com', 7);
INSERT INTO tb_fornecedor (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Fornecedor Alpha', '12.345.678/0001-00', '(11) 33333-4444', 'alpha@fornecedor.com', 8);
INSERT INTO tb_fornecedor (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Fornecedor Beta', '23.456.789/0001-11', '(21) 55555-6666', 'beta@fornecedor.com', 9);
INSERT INTO tb_fornecedor (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Fornecedor Gama', '34.567.890/0001-22', '(31) 77777-8888', 'gama@fornecedor.com', 10);
INSERT INTO tb_fornecedor (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Fornecedor Delta', '45.678.901/0001-33', '(19) 22222-3333', 'delta@fornecedor.com', 11);
INSERT INTO tb_fornecedor (nome, cpf_cnpj, phone, email, endereco_id) VALUES ('Fornecedor Omega', '56.789.012/0001-44', '(11) 44444-5555', 'omega@fornecedor.com', 12);

INSERT INTO tb_tecnico (nome, cargo) VALUES ('Carlos Souza', 'Engenheiro de Ensaio');
INSERT INTO tb_tecnico (nome, cargo) VALUES ('Mariana Costa', 'Técnica de Laboratório');
INSERT INTO tb_tecnico (nome, cargo) VALUES ('Felipe Lima', 'Coordenador Técnico');

INSERT INTO tb_maquina_ensaio (descricao, indentificacao, serie, classe, certificacao, data_calibacao, proxima_calibracao) VALUES ('Máquina de Ensaio 1', 'ME001', '1234A', 'Classe A', 'Certificado X', '2023-05-01', '2024-05-01');
INSERT INTO tb_maquina_ensaio (descricao, indentificacao, serie, classe, certificacao, data_calibacao, proxima_calibracao) VALUES ('Máquina de Ensaio 2', 'ME002', '5678B', 'Classe B', 'Certificado Y', '2023-07-01', '2024-07-01');
INSERT INTO tb_maquina_ensaio (descricao, indentificacao, serie, classe, certificacao, data_calibacao, proxima_calibracao) VALUES ('Máquina de Ensaio 3', 'ME003', '91011C', 'Classe C', 'Certificado Z', '2023-09-01', '2024-09-01');

INSERT INTO tb_obra (nome, endereco_id, cliente_id, fornecedor_id) VALUES ('Construção do Edifício Alpha', 13, 1, 1);
INSERT INTO tb_obra (nome, endereco_id, cliente_id, fornecedor_id) VALUES ('Construção do Edifício São Paulo', 14, 2, 6);
INSERT INTO tb_obra (nome, endereco_id, cliente_id, fornecedor_id) VALUES ('Reforma da Praça da Liberdade', 15, 1, 5);
INSERT INTO tb_obra (nome, endereco_id, cliente_id, fornecedor_id) VALUES ('Edificação do Centro Cultural BH', 16, 3, 2);
INSERT INTO tb_obra (nome, endereco_id, cliente_id, fornecedor_id) VALUES ('Avenida Norte - Pavimentação', 17, 4, 4);
INSERT INTO tb_obra (nome, endereco_id, cliente_id, fornecedor_id) VALUES ('Construção do Parque das Flores', 18, 3, 3);

INSERT INTO tb_servico (data_inicio, data_final, tecnico_id, obra_id) VALUES ('2023-01-01', '2023-01-15', 1, 1);
INSERT INTO tb_servico (data_inicio, data_final, tecnico_id, obra_id) VALUES ('2023-02-01', '2023-02-15', 2, 2);
INSERT INTO tb_servico (data_inicio, data_final, tecnico_id, obra_id) VALUES ('2023-03-01', '2023-03-15', 3, 3);


INSERT INTO tb_corpo_de_prova (identificacao, data_moldagem, idade, diametro, altura, capeamento, tecnico_id) VALUES ('CP001', '2023-01-10', '10 dias', 15.5, 30.0, 'Sim', 1);
INSERT INTO tb_corpo_de_prova (identificacao, data_moldagem, idade, diametro, altura, capeamento, tecnico_id) VALUES ('CP002', '2023-03-15', '20 dias', 16.0, 28.0, 'Não', 2);
INSERT INTO tb_corpo_de_prova (identificacao, data_moldagem, idade, diametro, altura, capeamento, tecnico_id) VALUES ('CP003', '2023-04-20', '15 dias', 14.5, 29.5, 'Sim', 3);

INSERT INTO tb_ensaio (carga, tempo, corpo_de_prova_id, servico_id, maquina_id) VALUES (500.0, 60.0, 1, 1, 1);
INSERT INTO tb_ensaio (carga, tempo, corpo_de_prova_id, servico_id, maquina_id) VALUES (400.0, 45.0, 2, 2, 2);
INSERT INTO tb_ensaio (carga, tempo, corpo_de_prova_id, servico_id, maquina_id) VALUES (600.0, 70.0, 3, 3, 3);

