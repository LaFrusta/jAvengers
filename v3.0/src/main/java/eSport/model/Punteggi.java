package eSport.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Punteggi {
	
	/*
	 * Restituisce una lista di Punteggio in base al ResultSet inserito
	 * 
	 * @param: ResultSet set, ConnessioneDB connessione
	 * 
	 * @return: List<Punteggio>
	 * */
	
	
	public static List<Punteggio> getPunteggi(ResultSet set, ConnessioneDB connessione) {
		
		List<Punteggio> punteggi=new LinkedList<>();
		
		try {
		
		while(set.next()) {
			
			Punteggio punteggio = new Punteggio(set.getString("nome_utente"), set.getInt("risultato")); 
			punteggi.add(punteggio);
		}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return punteggi;
	}
	
}
