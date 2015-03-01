package com.avenuecode.bo.impl;

import java.util.List;

import com.avenuecode.bo.ProdutoBo;
import com.avenuecode.dao.ProdutoDao;
import com.avenuecode.model.Produto;

public class ProdutoBoImpl implements ProdutoBo {
	
	ProdutoDao produtoDao;
	
	public void setProdutoDao(ProdutoDao produtoDao){
		this.produtoDao = produtoDao;
	}
	
	/*
	 * Implementação de método para recuperar objeto Produto, passado o idProduto
	 */
	public Produto findById(Integer idProduto){
		return produtoDao.findById(idProduto);
	}
	
	/*
	 * Implementação de método para recuperar lista de todos os objetos Produto
	 */
	public List<Produto> listAll(){
		return produtoDao.listAll();
	}


}
