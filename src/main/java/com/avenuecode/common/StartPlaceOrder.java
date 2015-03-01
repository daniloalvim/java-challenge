package com.avenuecode.common;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.avenuecode.bo.ProdutoBo;
import com.avenuecode.model.Ordem;
import com.avenuecode.model.OrdemProduto;


public class StartPlaceOrder{

	public static void main(String[] args) {
		try {
			
			//Constantes de Ordem
			final String CLIENTE_ORDEM = "Denilson Costa Marques";
			final String DATA_ORDEM = "28/02/2015";
			final String STATUS_ORDEM = "Aguardando pagamento";
			
			//Constantes de OrdemProduto
			final String QUANTIDADE_ORDEM_PRODUTO = "1";
			final String STATUS_ORDEM_PRODUTO = "Em estoque";
			
			//Constantes de Produto
			final String ID_PRODUTO = "5";

			//recuperando o contexto para usar a classe ProdutoBo
			ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			ProdutoBo produtoBo = (ProdutoBo)appContext.getBean("produtoBo");
			
			//preenchendo o objeto Ordem		
			Ordem ordem = new Ordem();
			ordem.setClienteOrdem(CLIENTE_ORDEM);
			ordem.setDataOrdem(new SimpleDateFormat("dd/MM/yyyy").parse(DATA_ORDEM));
			ordem.setStatusOrdem(STATUS_ORDEM);
			
			//preenchendo o objeto OrdemProduto
			OrdemProduto ordemProduto = new OrdemProduto();
			ordemProduto.setOrdem(ordem);
			ordemProduto.setQuantidadeOrdemProduto(new Integer(QUANTIDADE_ORDEM_PRODUTO));
			ordemProduto.setStatusOrdemProduto(STATUS_ORDEM_PRODUTO);
			ordemProduto.setProduto(produtoBo.findById(new Integer(ID_PRODUTO)));
			
			//adicionando o item OrdemProduto
			Set<OrdemProduto> ordemProdutos = new HashSet<OrdemProduto>();
			ordemProdutos.add(ordemProduto);
			
			//setando a lista de OrdemProduto em Ordem
			ordem.setOrdemProdutos(ordemProdutos);
			
			//Fazendo a chamada do OrdemService, passando Ordem como parâmetro e recebendo o resultado (em Json) como String
			RestTemplate restTemplate = new RestTemplate();
			String ordemRet = restTemplate.postForObject("http://localhost:8080/java-webapp-coding-test/rest/ordem/place", ordem, String.class);
			
			//imprime o resultado devolvido pelo Webservice em Json
			System.out.println(ordemRet);

	 
		} catch (Exception e) {
 
			e.printStackTrace();
 
		}
	 
	}

}
