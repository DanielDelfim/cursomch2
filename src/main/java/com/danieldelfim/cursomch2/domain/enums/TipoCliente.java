package com.danieldelfim.cursomch2.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), // com esta arquitetura a pessoa física terá codigo 1 e um nome para impressão Pessoa Física
	PESSOAJURIDICA(2, "Pessoa Jurídica");// com esta arquitetura a pessoa juridica terá codigo 2 e um nome para impressão Pessoa Jurídica

	private int cod;
	private String descricao;
//	declaramos as variáveis codigo e descrição do enum para armazenar os valores

	
	private TipoCliente() { //construtor do tipo enum é private
	}

	private TipoCliente(int cod, String descricao) { //construtor do tipo enum é private
		this.cod = cod;
		this.descricao = descricao;
	}
//geramos os construtores
	
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
//geramos os metodos get, não tem o set pois não queremos alterar o enum
	
	public static TipoCliente toEnum(Integer cod) {// método que me retorna o tipo cliente conforme o código passado. 
//		Static pois preciso executar a operação mesmo sem instanciar os objetos
// TipoCliente toEnum -> converte para enum, sendo o código o parametro
		if (cod == null) {// apenas para proteção, uma vez que se não existir o código deve retornar nulo
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
//for, para todos os objetos x nos valores possíveis do tipoCliente
// é um for que percorre tdos os valores possiveis do tipo cliente
			if (cod.equals(x.getCod())) {// se o código que veio como argumento for igual ao x que retornou na procura for acima
				return x;//retorna x
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);// se rodar o for e não encontrar nenhum teremos esta excessão
	}
	
}
