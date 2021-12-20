package eSport.model;

public class Punteggio {
	
	private String nomeUtente;
	private int risultato;
	
	public Punteggio(String nomeUtente, int risultato) {
		this.nomeUtente = nomeUtente;
		this.risultato = risultato;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public int getRisultato() {
		return risultato;
	}

	public void setRisultato(int risultato) {
		this.risultato = risultato;
	}
	
}
