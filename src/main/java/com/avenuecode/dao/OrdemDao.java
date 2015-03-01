package com.avenuecode.dao;

import java.util.List;

import com.avenuecode.model.Ordem;

public interface OrdemDao {

	/*
	 * Assinatura de método para salvar objeto Ordem
	 */
	boolean save(Ordem ordem);
	
	/*
	 * Assinatura de método para alterar objeto Ordem
	 */
	boolean update(Ordem ordem);
	
	/*
	 * Assinatura de método para recuperar objeto Ordem, passado o idOrdem
	 */
	Ordem findById(Integer idOrdem);
	
	/*
	 * Assinatura de método para recuperar lista de todos os objetos Ordem
	 */
	List<Ordem> listAll();
	
}
