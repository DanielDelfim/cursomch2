package com.danieldelfim.cursomch2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danieldelfim.cursomch2.domain.Category;
import com.danieldelfim.cursomch2.services.CategoryService;

@RestController
@RequestMapping(value = "/categories") // "/categories" é o caminho para o endPoint category
public class CategoryResources {

	@Autowired 
	private CategoryService categoryService;
	// Para o endPoint fazer a pesquisa ele irá depender da classe Service. 
	// Com o Autowired o objeto categoryService é instanciado automaticamente.
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // O endpoint do método implementado a seguir será "/categories/id"
	public ResponseEntity<?> find(@PathVariable Integer id) { // @PathVariable é inserido para identificar que este id é o mesmo do endPoint
		//o ResponseEntity já encapsula diversas informações de uma resposta http. A interrogação é porque o método pode não encontrar o id
		Category obj = categoryService.buscar(id);
		// estou no Rest, solicita service para ir no Repository que foi autorizado a acessar o banco de dados e buscar a category com este id
		return ResponseEntity.ok().body(obj);
		// este método retorna um objeto ResponseEntity que é um objeto complexo, com códigos http de resposta, varias informações do http
		// o ok irá indicar que a operação com sucesso e como corpo esta resposta terá o objeto obj encontrado.
		
	}	

}
