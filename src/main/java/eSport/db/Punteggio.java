package eSport.db;

public class Punteggio {
	
	private int id;
	private int risultato;
	
	public Punteggio(int id, int risultato) {
		this.id = id;
		this.risultato = risultato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRisultato() {
		return risultato;
	}

	public void setRisultato(int risultato) {
		this.risultato = risultato;
	}
	
	
}
