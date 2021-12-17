package eSport.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Punteggi {

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
}
