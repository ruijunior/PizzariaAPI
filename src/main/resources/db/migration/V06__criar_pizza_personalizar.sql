CREATE TABLE public.pizza_com_personalizacoes (
	pizza_id int8 NOT NULL,
	personalizar_id int4 NOT NULL,
	CONSTRAINT FK_PCP_PPZ FOREIGN KEY (personalizar_id) REFERENCES personalizar_pizza(id),
	CONSTRAINT FK_PCP_PZ FOREIGN KEY (pizza_id) REFERENCES pizza(pedido_id)
);