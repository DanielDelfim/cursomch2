package com.danieldelfim.cursomch2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danieldelfim.cursomch2.domain.Endereco;

@Repository // dá autorização à classe fazer comunicação com o banco de dados
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	/*extend - define que a inteface irá herdar dados do JpaRepository que é tipo especial capaz de acessar dados do banco de dados 
	o comando JPa acessa banco de dados relacional ou não relacional
	o T é objeto (classe no pacote domain) que a interface irá acessar e o id é o tipo do atributo identificador do objeto
	este código irá fornecer autorização à interface acessar o banco de dados e adicionar, deletar, modificar e outras operações
	referentes ao banco de dados.
	*/

}
