package com.danieldelfim.cursomch2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieldelfim.cursomch2.domain.Category;
import com.danieldelfim.cursomch2.repositories.CategoryRepository;
import com.danieldelfim.cursomch2.services.exception.ObjectNotFoundException;

@Service // define que esta classe pertence a camada de serviço (aqui são criadas as operações)
public class CategoryService {
	
	@Autowired//instancia automaticamente a dependência ao CategoryRepository para acesso ao banco de dados
	private CategoryRepository categoryRepository; //criação do objeto com nome de variável categoryRepository
	
	public Category find(Integer id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName()));
	}
	
	/*public Optional<Category> buscar(Integer id) { //para buscar fazer a busca, o método buscar tem que receber um id como parâmetro
		Optional<Category> obj = categoryRepository.findById(id); 
	//declara a Category obj com o categoryRepository e escolher a operação necessária
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName());
		}//se o obj for nulo, (não existir) o programa irá retornar a msg que eu estou passando. ObjectNotFoundException é a classe que eu criei.
		return obj;//quem irá receber esta exceção será a camada de recurso REST no pacote Resource.
		//Vamos criar no pacote Resource uma classe para tratamento de exceção ResourceExceptionHandler
	}
	*/
	/*cria uma operação capaz de buscar uma categoria por código, logo ele terá que acessar a interface
	CategoryRepository que por sua vez irá fazer a busca no banco de dados. Para isto precisamos criar
	um objeto CategoryRepository. Este objeto foi criado acima com nome da variável de categoryRepository

	public Category find(Integer id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElse(null);
//		com o optional se o obj for encontrado obj será apresentado, se não retorna null.
		}*/
	
}
