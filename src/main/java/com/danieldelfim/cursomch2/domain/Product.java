package com.danieldelfim.cursomch2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity // define a classe como uma entidade do projeto
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //define a geração automática dos id's para produtos
	private Integer id;
	private String nome;
	private Double preco;

	@JsonBackReference // este fará: do outro lado da associação já buscaram os objetos, então eu não busco mais.
	@ManyToMany //define o tipo de relacionmento existente na associação entre produto e categoria.
	@JoinTable ( // devido ao relacionamento manytomany deve-se criar no banco de dados uma table de associação entre as duas classes
		name = "PRODUCT_CATEGORY", //nome da tabela
		joinColumns = @JoinColumn(name = "product_id"), //nome do campo da tabela que corresponde ao código do produto (chave estrangeira)
		inverseJoinColumns = @JoinColumn(name = "category_id") //nome da outra chave estrangeira que vai referenciar a categoria
		) //como o relacionamento é entre Product e Category, deve-se colocar também referencia a este relacionamento na classe Category.
	private List<Category> categories = new ArrayList<>();
	// não incluir coleções no construtor com parametros. Isto porque ela foi
	// iniciada com o new ArrayList

	public Product() {
	}

	public Product(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
