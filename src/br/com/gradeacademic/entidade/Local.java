package br.com.gradeacademic.entidade;

public class Local {
	int id_cidade;
	static Cidade nome_cidade;
	static Estado nome_estado;
	static Pais nome_pais;

	public int getId_cidade() {
		return id_cidade;
	}

	public static Cidade getNome_cidade() {
		return nome_cidade;
	}

	public void setNome_cidade(Cidade nome_cidade) {
		this.nome_cidade = nome_cidade;
	}

	public static Estado getNome_estado() {
		return nome_estado;
	}

	public void setNome_estado(Estado nome_estado) {
		this.nome_estado = nome_estado;
	}

	public static Pais getNome_pais() {
		return nome_pais;
	}

	public void setNome_pais(Pais nome_pais) {
		this.nome_pais = nome_pais;
	}

	public void setId_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
	}

}
