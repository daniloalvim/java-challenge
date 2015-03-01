package com.avenuecode.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ordem implements Serializable{

	/**
	 * Auto-Generated
	 */
	private static final long serialVersionUID = 9180149302125348788L;
	
	private Integer idOrdem;
	private String clienteOrdem;
	private Date dataOrdem;
	private String statusOrdem;
	private Set<OrdemProduto> ordemProdutos = new HashSet<OrdemProduto>(0);
	
	//default constructor
	public Ordem(){
	}
	
	@JsonCreator
	public Ordem(@JsonProperty("idOrdem") Integer idOrdem,
					@JsonProperty("clienteOrdem") String clienteOrdem,
					@JsonProperty("dataOrdem") Date dataOrdem,
					@JsonProperty("statusOrdem") String statusOrdem){
		this.idOrdem = idOrdem;
		this.clienteOrdem = clienteOrdem;
		this.dataOrdem = dataOrdem;
		this.statusOrdem = statusOrdem;
	}
	
	public Integer getIdOrdem() {
		return idOrdem;
	}
	public void setIdOrdem(Integer idOrdem) {
		this.idOrdem = idOrdem;
	}
	
	public String getClienteOrdem() {
		return clienteOrdem;
	}
	public void setClienteOrdem(String clienteOrdem) {
		this.clienteOrdem = clienteOrdem;
	}
	
	public Date getDataOrdem() {
		return dataOrdem;
	}
	public void setDataOrdem(Date dataOrdem) {
		this.dataOrdem = dataOrdem;
	}
	
	public String getStatusOrdem() {
		return statusOrdem;
	}
	public void setStatusOrdem(String statusOrdem) {
		this.statusOrdem = statusOrdem;
	}
	
	public Set<OrdemProduto> getOrdemProdutos() {
		return ordemProdutos;
	}
	
	public void setOrdemProdutos(Set<OrdemProduto> ordemProdutos) {
		this.ordemProdutos = ordemProdutos;
	}
	
}
