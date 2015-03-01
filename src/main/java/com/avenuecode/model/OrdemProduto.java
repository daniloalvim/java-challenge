package com.avenuecode.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdemProduto implements Serializable{

	/**
	 * Auto-Generated
	 */
	private static final long serialVersionUID = 1605670659321790155L;

	private Integer idOrdemProduto;
	
	@JsonIgnore
	private Ordem ordem;
	private Produto produto;
	private Integer quantidadeOrdemProduto;
	private String statusOrdemProduto;
	
	//default constructor
	public OrdemProduto(){
	}
	
	@JsonCreator
    public OrdemProduto(@JsonProperty("nomeProduto") String nomeProduto,
    						@JsonProperty("quantidadeOrdemProduto") Integer quantidadeOrdemProduto,
    						@JsonProperty("statusOrdemProduto") String statusOrdemProduto) {
		Produto produto = new Produto();
		produto.setNomeProduto(nomeProduto);
		this.produto = produto;
        this.quantidadeOrdemProduto = quantidadeOrdemProduto;
        this.statusOrdemProduto = statusOrdemProduto;
    }
	
	public Integer getIdOrdemProduto() {
		return idOrdemProduto;
	}
	public void setIdOrdemProduto(Integer idOrdemProduto) {
		this.idOrdemProduto = idOrdemProduto;
	}
	
	@JsonIgnore
	public Ordem getOrdem() {
		return ordem;
	}
	@JsonIgnore
	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String getStatusOrdemProduto() {
		return statusOrdemProduto;
	}
	public void setStatusOrdemProduto(String statusOrdemProduto) {
		this.statusOrdemProduto = statusOrdemProduto;
	}

	public Integer getQuantidadeOrdemProduto() {
		return quantidadeOrdemProduto;
	}
	public void setQuantidadeOrdemProduto(Integer quantidadeOrdemProduto) {
		this.quantidadeOrdemProduto = quantidadeOrdemProduto;
	}
	
}
