package com.danieldelfim.cursomch2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity // define que esta classe category é uma entidade JPA
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id //define que o id é a chave primaria para busca no banco
	@GeneratedValue(strategy=GenerationType.IDENTITY) //define a geração automática dos id's para category
	private Integer id;
	private String nome;
	
	@JsonManagedReference // referencia gerenciada pelo Json que irá finalizar a referencia ciclica existente entre categoria e produto
	//Este código é colocado no lado em que voê quer que venha os objetos refenciados. No outro lado será diferente
	@ManyToMany(mappedBy="categories") // faz referencia ao mapeamento construido na classe Product
	private List<Product> products = new ArrayList<>();
	/* como o objeto produto é uma coleção (uma lista), ela deve ser iniciada com new ArrayList ou outro.
	 Conforme a UML gerada, temos que uma category pode ter vários produtos, neste caso tem que ser gerada uma lista.
	 A associação é entre produto e categoria, na classe produto também deverá ser declarada uma lista.
	*/
	public Category() {
	}

	public Category(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
