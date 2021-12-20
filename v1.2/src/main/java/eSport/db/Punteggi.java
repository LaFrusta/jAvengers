package eSport.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Punteggi {
	
	public static List<Punteggio> ReadAll() {

		List<Punteggio> punteggi = new LinkedList<Punteggio>();

		ConnessioneDB connessione = new ConnessioneDB();
		try {
			connessione.connect();

			ResultSet set = connessione.executeQuery("Select * from risultati");

			while (set.next()) {
				int id = set.getInt("id");
				int risultato = set.getInt("risultato");
				Punteggio punteggio = new Punteggio(id, risultato);
				punteggi.add(punteggio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			punteggi = null;
		}

		connessione.close();

		return punteggi;
	}
	
	
	
	
/*
	public static HashMap<String, Integer> ReadAll(){
		
		HashMap<String, Integer> punteggi = new HashMap<String, Integer>();
		ConnessioneDB connessione = new ConnessioneDB();
		
		try {
			connessione.connect();
			
			 //TODO: inserire query e modificare valori tabella
			ResultSet set = connessione.executeQuery("");
			
			while(set.next()) {
				int point = set.getInt("punteggi");
				String nome_utente = set.getString("nome_utente");
				punteggi.put(nome_utente, point);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			punteggi = null;
		}
		
		return punteggi;
	}
	*/
}
