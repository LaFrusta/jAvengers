package eSport.db;

public class Utente {
	private String nome_utente;
	private String password;
	public Utente(String nome_utente, String password) {
		this.nome_utente = nome_utente;
		this.password = password;
	}
	public String getNome_utente() {
		return nome_utente;
	}
	public void setNome_utente(String nome_utente) {
		this.nome_utente = nome_utente;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
