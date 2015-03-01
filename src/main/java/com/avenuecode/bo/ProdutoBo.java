package com.avenuecode.bo;

import java.util.List;

import com.avenuecode.model.Produto;

public interface ProdutoBo {
	
	/*
	 * Assinatura de método para recuperar objeto Produto, passado o idProduto
	 */
	Produto findById(Integer idProduto);
	
	/*
	 * Assinatura de método para recuperar lista de todos os objetos Produto
	 */
	List<Produto> listAll();

}
