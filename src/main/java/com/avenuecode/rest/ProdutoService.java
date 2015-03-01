package com.avenuecode.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.avenuecode.model.Produto;
import com.avenuecode.util.AppContext;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/produto")
public class ProdutoService extends AppContext {

	@GET
	@Path("/list")
	public String getProductList() throws JsonGenerationException, JsonMappingException, IOException {
		
		//método para carregar lista com todos os Produtos
		List<Produto> listaProduto = getProdutoBo().listAll();
		
		//transforma lista em String Json
		ObjectMapper mapper = new ObjectMapper();
        String produtoJson = mapper.writeValueAsString(listaProduto);
        
		return produtoJson;

	}
	
	@GET
	@Path("/detail/{id}")
	public String getProductDetail(@PathParam("id") Integer idProduto) throws JsonGenerationException, JsonMappingException, IOException {
	 
		//método para carregar objeto Produto com ID passado por parâmetro
		Produto produto = getProdutoBo().findById(idProduto);
	    
		//transforma objeto em String Json
	    ObjectMapper mapper = new ObjectMapper();
        String produtoJson = mapper.writeValueAsString(produto);
        
		return produtoJson;
	}
	
}
