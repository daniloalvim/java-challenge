package com.avenuecode.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avenuecode.bo.OrdemBo;
import com.avenuecode.bo.ProdutoBo;

public class AppContext {

	private ApplicationContext getAppContext(){
		return new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/*
	 * Método para pegar o contexto do Business Object ProdutoBo através das classes filhas
	 */
	protected ProdutoBo getProdutoBo(){
		return (ProdutoBo)getAppContext().getBean("produtoBo");
	}
	
	/*
	 * Método para pegar o contexto do Business Object OrdemBo através das classes filhas
	 */
	protected OrdemBo getOrdemBo(){
		return (OrdemBo)getAppContext().getBean("ordemBo");
	}
	
}
