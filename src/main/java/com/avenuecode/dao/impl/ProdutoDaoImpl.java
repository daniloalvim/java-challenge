package com.avenuecode.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.avenuecode.dao.ProdutoDao;
import com.avenuecode.model.Produto;

public class ProdutoDaoImpl extends HibernateDaoSupport implements ProdutoDao {

	/*
	 * Implementação de método para recuperar objeto Produto, passado o idProduto
	 */
	@SuppressWarnings("unchecked")	
	public Produto findById(Integer idProduto){
		List<Produto> listaProduto = (List<Produto>) getHibernateTemplate().find("from Produto where idProduto=?",idProduto);
		if(listaProduto.size() > 0)
			return listaProduto.get(0);
		return null;
	}
	
	/*
	 * Implementação de método para recuperar lista de todos os objetos Produto
	 */
	@SuppressWarnings("unchecked")	
	public List<Produto> listAll(){
		List<Produto> listaProduto = (List<Produto>) getHibernateTemplate().find("from Produto order by nomeProduto");
		return listaProduto;
	}
	
}
