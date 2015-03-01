package com.avenuecode.bo.impl;

import java.util.List;

import com.avenuecode.bo.OrdemBo;
import com.avenuecode.dao.OrdemDao;
import com.avenuecode.model.Ordem;

public class OrdemBoImpl implements OrdemBo {

	OrdemDao ordemDao;
	
	public void setOrdemDao(OrdemDao ordemDao){
		this.ordemDao = ordemDao;
	}
	
	/*
	 * Implementação de método para salvar objeto Ordem
	 */
	public boolean save(Ordem ordem){
		return ordemDao.save(ordem);
	}
	
	/*
	 * Implementação de método para alterar objeto Ordem
	 */
	public boolean update(Ordem ordem){
		return ordemDao.update(ordem);
	}
	
	/*
	 * Implementação de método para recuperar objeto Ordem, passado o idOrdem
	 */
	public Ordem findById(Integer idOrdem){
		return ordemDao.findById(idOrdem);
	}
		
	/*
	 * Implementação de método para recuperar lista de todos os objetos Ordem
	 */
	public List<Ordem> listAll(){
		return ordemDao.listAll();
	}
	
}
