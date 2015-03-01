package com.avenuecode.junit;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avenuecode.bo.OrdemBo;
import com.avenuecode.model.Ordem;


public class TestOrdemService{
	
	ApplicationContext appContext;
	OrdemBo ordemBo;
	final Integer ID_ORDEM = 1;
	
	public TestOrdemService() {
		appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ordemBo = (OrdemBo)appContext.getBean("ordemBo");
	}
 
    @Before
    public void beforeEachTest() {
        System.out.println("This is executed before each Test");
    }
 
    @After
    public void afterEachTest() {
        System.out.println("This is executed after each Test");
    }
 
	/*
	 * Método de teste para verificar se possui Ordem cadastrada no banco de dados
	 */
    @Test
    public void testListOrdem() {
    	List<Ordem> listaOrdem = getOrdemBo().listAll();
    	Assert.assertNotEquals(0, listaOrdem.size());
    }
    
	/*
	 * Método de teste para verificar se existe Ordem cadastrada com o id (Constante)
	 */
    @Test
    public void testDetailOrdem() {
    	Ordem ordem = getOrdemBo().findById(ID_ORDEM);
    	Assert.assertNotNull(ordem);
    }
    
	/*
	 * Método de teste para verificar se a descrição do status de Ordem tem mais de 20 caracteres
	 */
    @Test
    public void testTamanhoStatusOrdem() {
    	Ordem ordem = getOrdemBo().findById(ID_ORDEM);
    	if(ordem != null && ordem.getStatusOrdem() != null){
    		Assert.assertTrue(ordem.getStatusOrdem().length() <= 20);
    	}else{
    		Assert.assertTrue(false);
    	}
    }
    
	/*
	 * Método de teste para verificar se o nome do cliente tem mais de 50 caracteres
	 */
    @Test
    public void testTamanhoClienteOrdem() {
    	Ordem ordem = getOrdemBo().findById(ID_ORDEM);
    	if(ordem != null && ordem.getClienteOrdem() != null){
    		Assert.assertTrue(ordem.getClienteOrdem().length() <= 20);
    	}else{
    		Assert.assertTrue(false);
    	}
    }
    

	public OrdemBo getOrdemBo() {
		return ordemBo;
	}

	public void setOrdemBo(OrdemBo ordemBo) {
		this.ordemBo = ordemBo;
	}
    

}
