package br.com.gradeacademic.entidade;

public class Semestre {
	
	private int id;
	private String descricao;
	private String observacao;
	private int status;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status){
		this.status = status;
	}

	
}