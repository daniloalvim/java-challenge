package com.avenuecode.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.avenuecode.dao.OrdemDao;
import com.avenuecode.model.Ordem;

public class OrdemDaoImpl extends HibernateDaoSupport implements OrdemDao{
	
	/*
	 * Implementação de método para salvar objeto Ordem
	 */
	@Transactional
	public boolean save(Ordem ordem){
		try{
			getHibernateTemplate().save(ordem);	
			return true;
		}catch(Exception exc){
			exc.printStackTrace();
			return false;
		}
	}
 
	/*
	 * Implementação de método para alterar objeto Ordem
	 */
	@Transactional
	public boolean update(Ordem ordem){
		try{
			getHibernateTemplate().update(ordem);	
			return true;
		}catch(Exception exc){
			exc.printStackTrace();
			return false;
		}
	}
 
	/*
	 * Implementação de método para recuperar objeto Ordem, passado o idOrdem
	 */
	@SuppressWarnings("unchecked")	
	public Ordem findById(Integer idOrdem){
		List<Ordem> listaOrdem = (List<Ordem>) getHibernateTemplate().find("from Ordem o left join fetch o.ordemProdutos as op join fetch op.produto as p where o.idOrdem=?",idOrdem);
		if(listaOrdem.size() > 0)
			return listaOrdem.get(0);
		return null;

	}
	
	/*
	 * Implementação de método para recuperar lista de todos os objetos Ordem
	 */
	@SuppressWarnings("unchecked")
	public List<Ordem> listAll(){
		List<Ordem> listaOrdem = (List<Ordem>) getHibernateTemplate().find("select distinct o from Ordem o inner join fetch o.ordemProdutos as op join fetch op.produto as p order by o.dataOrdem");
		return listaOrdem;
	}

}
