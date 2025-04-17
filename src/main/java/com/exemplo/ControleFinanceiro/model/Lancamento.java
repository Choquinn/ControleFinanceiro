package com.exemplo.ControleFinanceiro.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	private BigDecimal valor;
	private LocalDate data;
	
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipo;
	
	private String categoria;
	
	public Lancamento() {}
	
	public Lancamento(String descricao, LocalDate data, String categoria, BigDecimal valor, TipoLancamento tipo) {
		this.descricao = descricao;
		this.categoria = categoria;
		this.data = data;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public TipoLancamento getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Controle Financeiro{" +
				"id=" + id +
				", valor='" + valor + '\'' +
				", descricao='" + descricao + '\'' +
				", data=" + data +
				", categoria=" + categoria + '\'' +
				", tipo=" + tipo +
				'}';
	}
}
