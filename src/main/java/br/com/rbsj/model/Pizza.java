package br.com.rbsj.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name="pizza")
public class Pizza {
	
	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Pedido pedido;
	
	@Valid
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tamanho_id", nullable = false, referencedColumnName="id")
	private TamanhoPizza tamanho;
	
	@Valid
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sabor_id", nullable = false, referencedColumnName="id")
	private SaborPizza sabor;
	
	@Valid
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="pizza_com_personalizacoes", joinColumns= {@JoinColumn(name="pizza_id")},
    inverseJoinColumns={@JoinColumn(name="personalizar_id")})
	private List<PersonalizarPizza> personalizacoes;

	@Transient
	private Integer tempoPreparo = 0;

	@Transient
	private BigDecimal valor = BigDecimal.ZERO;

	public BigDecimal getValor(){
		BigDecimal valorPersonalizacao = this.personalizacoes.stream().map(PersonalizarPizza::getValorAdicional).reduce(BigDecimal.ZERO, BigDecimal::add);
		BigDecimal valorTamanho = this.tamanho.getValor();

		this.valor = this.valor.add(valorPersonalizacao).add(valorTamanho);

		return this.valor;
	}

	public Integer getTempoPreparo(){
		this.tempoPreparo += this.tamanho.getTempoPreparo();
		this.tempoPreparo += this.sabor.getTempoPreparo();
		this.tempoPreparo += this.personalizacoes.stream().mapToInt(PersonalizarPizza::getTempoAdicional).sum();

		return this.tempoPreparo;
	}

}
