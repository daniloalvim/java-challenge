package com.avenuecode.junit;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avenuecode.bo.ProdutoBo;
import com.avenuecode.model.Produto;

public class TestProdutoService {

	ApplicationContext appContext;
	ProdutoBo produtoBo;
	final Integer ID_PRODUTO = 1;
	
	public TestProdutoService() {
		appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		produtoBo = (ProdutoBo)appContext.getBean("produtoBo");
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
	 * Método de teste para verificar se possui Produto cadastrado no banco de dados
	 */
    @Test
    public void testListProduto() {
    	List<Produto> listaProduto = getProdutoBo().listAll();
    	Assert.assertNotEquals(0, listaProduto.size());
    }
    
	/*
	 * Método de teste para verificar se existe Produto cadastrado com o id (Constante)
	 */
    @Test
    public void testDetailProduto() {
    	Produto produto = getProdutoBo().findById(ID_PRODUTO);
    	Assert.assertNotNull(produto);
    }

	public ProdutoBo getProdutoBo() {
		return produtoBo;
	}

	public void setProdutoBo(ProdutoBo produtoBo) {
		this.produtoBo = produtoBo;
	}
	
}
