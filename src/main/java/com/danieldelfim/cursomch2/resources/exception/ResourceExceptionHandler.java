package com.danieldelfim.cursomch2.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.danieldelfim.cursomch2.services.exception.ObjectNotFoundException;

@ControllerAdvice // classe auxiliar que intercepta as excessões. No framework ela tem que ter o tratamento a seguir.
public class ResourceExceptionHandler {
	
	//o ResponseEntity já encapsula diversas informações de uma resposta http.
	@ExceptionHandler(ObjectNotFoundException.class) // para indicar que é um tratador de exceção deste tipo, ObjectNotFoundException
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		//instanciando um objeto StandardError com seus dados de erro conforme construtor criado. 
		//Status NOT_FOUND, o value é para ele ir na forma de número inteiro, mensagem da excessão e horário local do sistema que occorreu
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	

}
