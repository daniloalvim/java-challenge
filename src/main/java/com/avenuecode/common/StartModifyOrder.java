package com.avenuecode.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.avenuecode.bo.OrdemBo;
import com.avenuecode.bo.ProdutoBo;
import com.avenuecode.model.Ordem;
import com.avenuecode.model.OrdemProduto;

public class StartModifyOrder {

	public static void main(String[] args) {
		try {
			
			//Constantes de Ordem
			final String ID_ORDEM = "19";
			final String CLIENTE_ORDEM = "Denilson Costa Marques Jr.";
			final String DATA_ORDEM = "28/02/2015";
			final String STATUS_ORDEM = "Aguardando Pagamento";
			
			//Constantes de OrdemProduto
			final String ID_ORDEM_PRODUTO = "10";
			final String STATUS_ORDEM_PRODUTO = "Em estoque";

			//recuperando o contexto para usar a classe ProdutoBo
			ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			ProdutoBo produtoBo = (ProdutoBo)appContext.getBean("produtoBo");
			OrdemBo ordemBo = (OrdemBo)appContext.getBean("ordemBo");
			
			//preenchendo o objeto Ordem		
			Ordem ordem = ordemBo.findById(new Integer(ID_ORDEM));
			ordem.setClienteOrdem(CLIENTE_ORDEM);
			ordem.setDataOrdem(new SimpleDateFormat("dd/MM/yyyy").parse(DATA_ORDEM));
			ordem.setStatusOrdem(STATUS_ORDEM);
			
			//recuperando o objeto OrdemProduto
			List<OrdemProduto> lista = new ArrayList<OrdemProduto>(ordem.getOrdemProdutos());
			for (OrdemProduto ordemProduto : lista) {
				if(ordemProduto.getIdOrdemProduto().equals(new Integer(ID_ORDEM_PRODUTO))){
					ordemProduto.setStatusOrdemProduto(STATUS_ORDEM_PRODUTO);
				}
			}
			
			//setando a lista de OrdemProduto em Ordem
			ordem.setOrdemProdutos(new HashSet<OrdemProduto>(lista));
			
			//Fazendo a chamada do OrdemService, passando Ordem como parâmetro e recebendo o resultado (em Json) como String
			RestTemplate restTemplate = new RestTemplate();
			String ordemRet = restTemplate.postForObject("http://localhost:8080/java-webapp-coding-test/rest/ordem/modify", ordem, String.class);
			
			//imprime o resultado devolvido pelo Webservice em Json
			System.out.println(ordemRet);
	 
		} catch (Exception e) {
 
			e.printStackTrace();
 
		}
	}
	
}
