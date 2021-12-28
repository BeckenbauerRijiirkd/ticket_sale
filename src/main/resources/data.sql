INSERT INTO RESPONSAVEL(nome, nascimento, cpf, cidade, uf, endereco) VALUES('Responsavel teste', '2000-10-01', '123445678', 'aracaju', 'SE', 'rua 0');

INSERT INTO EVENTO(nome, data, responsavel_id, valor, valor_meia, status) VALUES('Evento Teste', '2020-10-20', '1', '20', '10', 'VENDAS_ABERTAS');

INSERT INTO EVENTO(nome, data, responsavel_id, valor, valor_meia, status) VALUES('Evento Teste 2', '2020-10-22', '1', '20', '10', 'REALIZADO');

INSERT INTO CLIENTE(nome, data_nasc, cpf, cidade, uf) VALUES('Cliente teste', '1990-11-21', '7070707070', 'aracaju', 'SE');

INSERT INTO VENDA(evento_id, cliente_id, tipo_ingresso, qtd_ingresso, valor_total) VALUES('1', '1', 'INTEIRA', '2','40');