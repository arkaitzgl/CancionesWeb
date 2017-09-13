package com.ipartek.formacion.canciones.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.canciones.modelo.ModeloCancionImpl;

/**
 * Servlet implementation class EliminarController
 */
@WebServlet("/eliminar")
public class EliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloCancionImpl model= ModeloCancionImpl.getInstance();
		
		String mensaje="";
		
		//recoger parametros
		
		String idString=request.getParameter("id");
		long id = Long.parseLong(idString);
		
		//llamar modelo para eliminar cancion
		
		if (model.delete(id)) {
			mensaje ="Cancion eliminada con exito";
		}else {
			mensaje="upsss no se puede eliminar cancion";
		}
		
		// conseguir listado canciones y pasar como atributo
		request.setAttribute("listado", model.getAll());
		request.setAttribute("mensaje", mensaje);
		
		//ir listado.jsp
		RequestDispatcher dispatch = request.getRequestDispatcher("listado.jsp");
		dispatch.forward(request, response);
		
	}

}