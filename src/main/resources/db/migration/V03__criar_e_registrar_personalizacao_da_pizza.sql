CREATE TABLE personalizar_pizza (
	id serial NOT NULL,
	descricao varchar(255) NOT NULL,
	tempo_adicional int4 NOT NULL,
	valor_adicional numeric(15,2) NOT NULL,
	CONSTRAINT personalizar_pizza_pkey PRIMARY KEY (id)
);

INSERT INTO personalizar_pizza (descricao,valor_adicional,tempo_adicional) VALUES 
('Extra bacon', 3, 0),
('Sem cebola', 0, 0),
('Borda recheada', 5, 5);