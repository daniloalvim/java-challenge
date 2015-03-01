package com.avenuecode.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avenuecode.model.Ordem;
import com.avenuecode.model.OrdemProduto;
import com.avenuecode.util.AppContext;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/ordem")
public class OrdemService extends AppContext {

	@POST
	@Path("/place")
	public @ResponseBody String placeOrder(@RequestBody Ordem ordem) throws JsonProcessingException {
		
		//carrega a lista de OrdemProduto e seta novamente a Ordem pois não está sendo carregada por causa da annotation JsonIgnore 
		List<OrdemProduto> lista = new ArrayList<OrdemProduto>(ordem.getOrdemProdutos());
		for (OrdemProduto ordemProduto : lista) {
			ordemProduto.setOrdem(ordem);
		}
		//faz a chamada para salvar o objeto Ordem
		if(getOrdemBo().save(ordem)){

			//transforma objeto em String Json
			ObjectMapper mapper = new ObjectMapper();
			String ordemJson = mapper.writeValueAsString(ordem);
			
			return ordemJson;
			
		}else
			return "Erro ao salvar!!!";
	}
	
	
	@POST
	@Path("/modify")
	public @ResponseBody String modifyOrder(@RequestBody Ordem ordem) throws JsonProcessingException {
		
		//carrega a lista de OrdemProduto e seta novamente a Ordem pois não está sendo carregada por causa da annotation JsonIgnore 
		List<OrdemProduto> lista = new ArrayList<OrdemProduto>(ordem.getOrdemProdutos());
		for (OrdemProduto ordemProduto : lista) {
			ordemProduto.setOrdem(ordem);
		}
		//faz a chamada para atualizar o objeto Ordem
		if(getOrdemBo().update(ordem)){

			//transforma objeto em String Json
			ObjectMapper mapper = new ObjectMapper();
			String ordemJson = mapper.writeValueAsString(ordem);
			
			return ordemJson;
			
		}else
			return "Erro ao salvar!!!";
	}
	

	@GET
	@Path("/list")
	public String getOrderList() throws JsonGenerationException, JsonMappingException, IOException {
		
		//método para carregar lista com todas as Ordens
		List<Ordem> listaOrdem = getOrdemBo().listAll();
		
		//transforma lista em String Json
		ObjectMapper mapper = new ObjectMapper();
        String produtoJson = mapper.writeValueAsString(listaOrdem);
        
		return produtoJson;
	}
	
	
	@GET
	@Path("/detail/{id}")
	public String getOrderDetail(@PathParam("id") Integer idOrdem) throws JsonGenerationException, JsonMappingException, IOException {
		
		//método para carregar objeto Ordem com ID passado por parâmetro
	    Ordem ordem = getOrdemBo().findById(idOrdem);
	    
	    //transforma objeto em String Json
	    ObjectMapper mapper = new ObjectMapper();
        String ordemJson = mapper.writeValueAsString(ordem);
        
		return ordemJson;
	}
	
}
