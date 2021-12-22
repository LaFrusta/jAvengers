package eSport.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSport.model.ConnessioneDB;
import eSport.model.Punteggi;
import eSport.model.Punteggio;
import eSport.view.Layout;
import eSport.view.PunteggiView;

/**
 * Servlet implementation class ProfiloServlet
 */
@WebServlet("/Profilo")
public class ProfiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		ConnessioneDB connessione = new ConnessioneDB();
		List<Punteggio> punteggi=new LinkedList<>();
		String nomeutente=request.getParameter("nome_utente");
		try {
			connessione.connect();
			if(punteggi.addAll
					(Punteggi.getPunteggi(connessione.executeQuery
							("SELECT `nome_utente`,`risultato` FROM `risultati` WHERE nome_utente = '"+nomeutente+"'"), connessione))) {
			boolean logged=false;
			
			boolean admin = false;
			
			if(nomeutente!=null) {
				
				logged = true;
			
				ResultSet view = connessione.executeQuery("SELECT admin FROM utenti WHERE nome_utente = '"+nomeutente+"'");
				
				view.next();
				
				if(view.getInt("admin")==1) {
					admin = true;
					
				}
		}
			PunteggiView points = new PunteggiView();
			points.writePunteggi(punteggi);
			Layout.doLayout(getServletContext(), writer, points.getString(), nomeutente, logged, admin);
			} else {
				boolean logged=false;
				
				boolean admin = false;
				
				if(nomeutente!=null) {
					
					logged = true;
				
					ResultSet view = connessione.executeQuery("SELECT admin FROM utenti WHERE nome_utente = '"+nomeutente+"'");
					
					view.next();
					
					if(view.getInt("admin")==1) {
						admin = true;
						
					}
				Layout.doLayout(getServletContext(), writer, "<h4>Non hai punteggi da visualizzare!</h4>", nomeutente, logged, admin);
			}
			}
			}catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
