package br.com.gradeacademic.entidade;

public class Estado {
    private int id;
    private int pais;
    private String nome;
    private String descricao;
    private String sigla;
    private boolean status;
    
    public int getId() {
		return id;
	}

	public void setId(int Id) {
		this.id = Id;
	}
	
	public int getPais(){
		return pais;
	}
	
	public void setPais(int Pais){
		this.pais = Pais;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String Nome) {
		this.nome = Nome;
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

	public boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean Status) {
		this.status = Status;
		
	}

}
