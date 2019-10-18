CREATE TABLE tamanho_pizza (
	id serial NOT NULL,
	descricao varchar(20) NOT NULL,
	tempo_preparo int4 NOT NULL,
	valor numeric(15,2) NOT NULL,
	CONSTRAINT tamanho_pizza_pkey PRIMARY KEY (id)
);

INSERT INTO tamanho_pizza (descricao,valor,tempo_preparo) VALUES 
('Pequena', 20, 15),
('Média', 30, 20),
('Grande', 40, 25);