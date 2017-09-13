package com.ipartek.formacion.canciones.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.canciones.modelo.ModeloCancionImpl;
import com.ipartek.formacion.canciones.pojo.Cancion;

/**
 * Servlet implementation class CrearController
 */
@WebServlet("/crear")
public class CrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloCancionImpl model= ModeloCancionImpl.getInstance();
		
		//recoger PARAMETROS del formulario	
		String nombre = request.getParameter("nombre").trim();
		String artista = request.getParameter("artista").trim();
		String duracion = request.getParameter("duracion");
		String cover = request.getParameter("cover");
		
		String mensajeusuario="";
		
		//vaildar parametros
		//nombre y artista no pueden ser vacios
				
		if ((nombre.isEmpty())||(("").equals(artista))) {
			mensajeusuario= "No se puede rellenar los campos con espacios vacios";		
			
		}else {	
			if (cover.isEmpty()) {
				cover="img/default-album.png";
			}
			//creamos la Cancion
			try {
			Cancion c = new Cancion(nombre, artista, duracion, cover);
		
			//guardar la cancion
		
			 if(model.insert(c)) {
				mensajeusuario= "Yeahhhhhh tenemos una nueva cancion";
			}else {
				mensajeusuario="Uppss ha surgido un problema";
			}
			}catch (Exception e) {
				mensajeusuario=e.getMessage();
			}
		}
		//enviamos ATRIBUTOS en la request para la JSP
		request.setAttribute("listado", model.getAll());
		request.setAttribute("mensaje", mensajeusuario);
		
		
		//vamos a la Vista
		RequestDispatcher dispatch = request.getRequestDispatcher("listado.jsp");
		dispatch.forward(request, response);
		
	}

}