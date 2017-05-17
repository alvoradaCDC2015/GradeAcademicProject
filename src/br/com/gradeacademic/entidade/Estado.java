package br.com.gradeacademic.entidade;

public class Estado {
    private int id;
    private String descricao;
    private String sigla;
    private String pais;
    private int situacao;
    
    public int getId() {
		return id;
	}

	public void setId(int Id) {
		this.id = Id;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	public void setDescricao(String Descricao){
		this.descricao = Descricao;
		
	}
    
	
	public String getSigla(){
		return sigla;
	}
	
	public void setSigla(String Sigla){
		this.sigla = Sigla;
		
	}
	
	public String getPais(){
		return pais;
	}
	
	public void setPais(String Pais){
		this.pais = Pais;
		
	}
	
	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int Situacao) {
		this.situacao = Situacao;
	}
}
