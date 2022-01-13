INSERT INTO USUARIO(email, senha, ativo) VALUES('teste@teste.com', '$2a$10$hdyFo/z9JKdxGafKM2uxNuijgmQXQiu2eC1MFZAQ.lrXPbcy8D10.', '1');

INSERT INTO RESPONSAVEL(nome, nascimento, cpf, cidade, uf, endereco, active) VALUES('Responsavel teste', '2000-10-01', '123445678', 'aracaju', 'SE', 'rua 0', '1');

INSERT INTO EVENTO(nome, data, responsavel_id, valor, valor_meia, status, active) VALUES('Evento Teste', '2020-10-20', '1', '20', '10', 'VENDAS_ABERTAS', '1');

INSERT INTO EVENTO(nome, data, responsavel_id, valor, valor_meia, status, active) VALUES('Evento Teste 2', '2020-10-22', '1', '20', '10', 'REALIZADO', '1');

INSERT INTO CLIENTE(nome, data_nasc, cpf, cidade, uf, usuario_id, ativo) VALUES('Cliente teste', '1990-11-21', '7070707070', 'aracaju', 'SE', '1', '1');

INSERT INTO VENDA(evento_id, cliente_id, tipo_ingresso, qtd_ingresso, valor_total) VALUES('1', '1', 'INTEIRA', '2','40');

INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_CLIENTE');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1, 1);