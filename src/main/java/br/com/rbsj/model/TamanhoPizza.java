package br.com.rbsj.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="tamanho_pizza")
public class TamanhoPizza {
	
	@Id
	@Column(nullable = false, name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 3, max = 20)
	@Column(name="descricao", nullable = false, length = 20)
	private String descricao;
	
	@NotNull
	@Column(name="valor", nullable = false, precision = 15, scale = 2)
	private BigDecimal valor;
	
	@NotNull
	@Column(name="tempo_preparo", nullable = false)
	private Integer tempoPreparo;

}
