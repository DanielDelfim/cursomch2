package com.danieldelfim.cursomch2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danieldelfim.cursomch2.domain.Category;
import com.danieldelfim.cursomch2.domain.Product;
import com.danieldelfim.cursomch2.repositories.CategoryRepository;
import com.danieldelfim.cursomch2.repositories.ProductRepository;

@SpringBootApplication
public class Cursomch2Application implements CommandLineRunner {
//	 este CommandLineRunner permit implementar um método auxiliar para executar alguma ação quando a aplicação iniciar 
// fica vermelho e aí voce manda implementar o metódo não implementado

	@Autowired // Instancia automaticamente o objeto categoryRepository e executamos o método necessário 
	CategoryRepository categoryRepository;
	@Autowired // Instancia automaticamente o objeto productRepository e executamos o método necessário 
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cursomch2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
// este método permite instanciar objetos assim que a aplicação iniciar.
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product (null, "Computador", 2000.00);
		Product p2 = new Product (null, "Impressora", 800.00);
		Product p3 = new Product (null, "Mouse", 80.00);
// após definido os objetos que deverão ser instanciados, deve-se criar uma dependencia com o repository
// isto porque apenas o repository pode executar ações no banco de dados. Dependencia criada Autowired

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
//até então tinhamos apenas criado os objetos, porém não tinhamos feito as associações de qual produto pertence a qual categoria.
//com os comandos acima as categorias conhecem os produtos que estão associados com ela, porém os produtos ainda não conhecem as categorias
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
//Agora os produtos conhecem todos as categorias de que fazem parte.
//finalizada a tabela de associação PRODUCT_CATEGORY
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
// com o categoryRepository. temos acesso a todas os métodos disponíveis no objeto. Como são várias caegorias, salvamos como lista.
		
	}

}

//método para instanciar os objetos e aí sim, os objetos serão salvos no banco de dados.