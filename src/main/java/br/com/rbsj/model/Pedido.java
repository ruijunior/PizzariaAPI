package br.com.rbsj.model;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@Getter
	@Column(nullable = false, name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@Valid
	@JsonIgnoreProperties("pedido")
	@NotNull
	@OneToOne(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	private Pizza pizza;
	
	@Column(name = "tempo_preparo", nullable = false, precision = 2, scale = 0)
	private Integer tempoPreparo ;
	
	@Column(name = "valor", nullable = false, precision = 15, scale = 2)
	private BigDecimal valor;

	public void concluir(){
		pizza.setPedido(this);
		this.tempoPreparo = this.pizza.getTempoPreparo();
		this.valor = this.pizza.getValor();
	}

}
