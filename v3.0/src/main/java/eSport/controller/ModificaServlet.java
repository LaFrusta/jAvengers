package eSport.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSport.model.Utente;
import eSport.model.Utenti;
import eSport.view.Layout;
import eSport.view.ModificaView;

/**
 * Servlet implementation class ModificaServlet
 */
@WebServlet("/Modifica")
public class ModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		ModificaView.modificaWriter(getServletContext(), writer, request.getParameter("nome_utente"), request.getParameter("target"), true, true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		Utente utente = new Utente(request.getParameter("target"), request.getParameter("password"));
		if(Utenti.Update(utente, request.getParameter("vecchio_nome_utente"))) {
			ModificaView view = new ModificaView();
			view.writeModificaTrue(request.getParameter("nome_utente"), request.getParameter("target"));
			Layout.doLayout(getServletContext(), writer, view.getString(), request.getParameter("nome_utente"), true, true);
			
		}
	}

}
