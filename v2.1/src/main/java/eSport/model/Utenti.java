package eSport.model;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class Utenti {
	public static boolean Create(Utente utente) {

		ConnessioneDB connessione = new ConnessioneDB();
		boolean done = false;
		try {
			connessione.connect();

			connessione.executeQuery("INSERT INTO utenti (nome_utente, password) " + "VALUES ('"
					+ utente.getNome_utente() + "', " + "'" + utente.getPassword() + "', " + "'" + "');");
			connessione.close();
			done = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return done;
	}

	public static List<Utente> ReadAll() {
		List<Utente> utenti = new LinkedList<Utente>();

		ConnessioneDB connessione = new ConnessioneDB();

		try {
			connessione.connect();

			ResultSet set = connessione.executeQuery("Select * from utenti");

			while (set.next()) {
				int id = set.getInt("id");
				String nome_utente = set.getString("nome_utente");
				String password = set.getString("password");

				Utente utente = new Utente(nome_utente, password);
				utenti.add(utente);

			}
		} catch (Exception e) {
			e.printStackTrace();
			utenti = null;
		}

		connessione.close();
		return utenti;
	}
	
	
	public static Utente ReadOne(int id) {
		Utente utente = null;
		
		ConnessioneDB connessione = new ConnessioneDB();
		
		try {
			connessione.connect();
			ResultSet set = connessione.executeQuery("Select * from utenti where id=" + id);
			
			if (set.next()) {
				String nome_utente = set.getString("nome_utente");
				String password = set.getString("password");
				
				utente = new Utente(nome_utente, password);
				
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connessione.close();
		
		return utente;
	}
	
	
	public static boolean Update(Utente utente) {
		
		ConnessioneDB connessione = new ConnessioneDB();
		boolean done=false;
		
		try {
			connessione.connect();
			connessione.executeUpdate("UPDATE utente SET " + "nome_utente= '" + utente.getNome_utente() + "', " + "password = '" + utente.getPassword() + "' " + "WHERE nome_utente = " + utente.getNome_utente() + "; ");
			connessione.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}
	
	public static boolean Delete(Utente utente) {
		
		ConnessioneDB connessione = new ConnessioneDB();
		boolean done=false;
		
		try {
			connessione.connect();
			
			done = connessione.executeUpdate("DELETE FROM utenti WHERE nome_utente = " + utente.getNome_utente());
			
			connessione.close();
			done = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}
	
}
