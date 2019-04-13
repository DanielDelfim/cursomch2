package com.danieldelfim.cursomch2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.danieldelfim.cursomch2.domain.enums.TipoCliente;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // define que o id é a chave primaria para busca no banco
	@GeneratedValue(strategy = GenerationType.IDENTITY) // define a geração automática dos id's para category
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;
//	normalmente em tipo deveria ser colocado o nome da classe q é neste caso TipoCliente, no entanto
//mudamos para Integer uma vez que na hora do cadastro a pessoa irá digitar apenas o código e não o nome
//feito entao um macete, trocamos o tipoCliente para Integer e no construtor inserimos this.tipo = tipo.getCod(). o cod é integer,
// esta alteração deverá ser feita também nos get e set
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	// como o objeto enderecos é uma coleção (uma lista), ela deve ser iniciada com
	// new ArrayList ou outro.

	@ElementCollection // vai mapear os telefones na tabela do banco como entidade fraca
	@CollectionTable(name = "Telefone")
	private Set<String> telefones = new HashSet<>();
// set é um conjunto que não aceita valores repetidos. No caso conjunto de String (telefones)
//	no caso do set uma classe que pode ser instanciada é a HashSet
//criamos o telefone neste formato pois no UML ele era uma classe weak e além disto tinha apenas um parametro

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getCod();
		// não incluir coleções no construtor com parametros. Isto porque ela foi
		// iniciada com o new ArrayList
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}
/*	e aqui, como faço para retornar um tipo de cliente String, sendo que tipo. (tipo da classe) é um número inteiro?
Neste caso, vou ter que usar o método criado na classe enum TipoCliente onde dado um número inteiro ela me retorna um
tipo cliente String equivalente.
ao escrever o nome da classe, seguido de ponto  e apertar crtl espaço(TipoCliente.) eu chamo todos os métodos disponíveis na classe,
No caso será a operação toEnum baseada no código fornecido pelo cliente, nesta classe Cliente, o código está armazenado pelo código.
*/
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
