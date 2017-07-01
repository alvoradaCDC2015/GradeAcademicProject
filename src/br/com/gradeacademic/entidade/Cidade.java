package br.com.gradeacademic.entidade;

public class Cidade {
    int id;
    static String nome;
	
	boolean status;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean getStatus() {
		return true;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
