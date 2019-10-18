package br.com.rbsj.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "personalizar_pizza")
public class PersonalizarPizza {

	@Id
	@Column(nullable = false, name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "valor_adicional", nullable = false, precision = 15, scale = 2)
	private BigDecimal valorAdicional;

	@Column(name = "tempo_adicional", nullable = false)
	private Integer tempoAdicional;
}