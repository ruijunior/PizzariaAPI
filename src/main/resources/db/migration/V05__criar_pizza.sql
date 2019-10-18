CREATE TABLE pizza (
	pedido_id int8 NOT NULL,
	sabor_id int4 NOT NULL,
	tamanho_id int4 NOT NULL,
	CONSTRAINT pizza_pkey PRIMARY KEY (pedido_id),
	CONSTRAINT FK_PIZZA_TAMANHO FOREIGN KEY (tamanho_id) REFERENCES tamanho_pizza(id),
	CONSTRAINT FK_PIZZA_SABOR FOREIGN KEY (sabor_id) REFERENCES sabor_pizza(id),
	CONSTRAINT FK_PIZZA_PEDIDO FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);