package com.danieldelfim.cursomch2.services.exception;

//esta classe irá tratar uma exceção criada no endPoint categories/{id} onde ele busca uma categoria que não existe e retorna ok. Não deveria.
public class ObjectNotFoundException extends RuntimeException { //implementação padrão que extend da classe RuntimeException
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
//construtor que recebe uma mensagem de exceção e chama a classe RuntimeException (super) e repassa essa mensagem msg para a super classe.
//Esta é leitura de exceção da linguagem Java	
	public ObjectNotFoundException (String msg, Throwable cause) {
		super (msg, cause);
	}
// outro construtor que recebe a mensagem e a causa da excessão e a repassa para a super classe
}
