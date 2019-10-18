CREATE TABLE pedido (
	id bigserial NOT NULL,
	tempo_preparo int4 NOT NULL,
	valor numeric(15,2) NOT NULL,
	CONSTRAINT pedido_pkey PRIMARY KEY (id)
);