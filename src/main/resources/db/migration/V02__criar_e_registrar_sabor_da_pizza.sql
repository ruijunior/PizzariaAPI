CREATE TABLE sabor_pizza (
	id serial NOT NULL,
	descricao varchar(255) NOT NULL,
	tempo_preparo int4 NOT NULL,
	CONSTRAINT sabor_pizza_pkey PRIMARY KEY (id)
);

INSERT INTO sabor_pizza (descricao,tempo_preparo) VALUES 
('Calabresa', 0),
('Marguerita', 0),
('Portuguesa', 5);