package com.avenuecode.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Produto implements Serializable{

	/**
	 * Auto-Generated
	 */
	private static final long serialVersionUID = 7635384348295523723L;

	private Integer idProduto;
	private String nomeProduto;
	private BigDecimal valorProduto;
	private String descricaoProduto;
	
	//default constructor
	public Produto(){
	}
	
	@JsonCreator
	public Produto(@JsonProperty("idProduto") Integer idProduto,
					@JsonProperty("nomeProduto") String nomeProduto,
					@JsonProperty("valorProduto") BigDecimal valorProduto,
					@JsonProperty("descricaoProduto") String descricaoProduto){
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.descricaoProduto = descricaoProduto;
	}
	
	
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public BigDecimal getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
}
