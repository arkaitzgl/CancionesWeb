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
 * Servlet implementation class ModificarController
 */
@WebServlet("/modificar")
public class ModificarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametros
		String idString = request.getParameter("id");

		// llamar modelo para modificar cancion
		long id = Long.parseLong(idString);

		ModeloCancionImpl model = ModeloCancionImpl.getInstance();
		Cancion c = model.getById(id);

		request.setAttribute("cancion", c);

		// ir modificar.jsp
		RequestDispatcher dispatch = request.getRequestDispatcher("modificar.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mensajeusuario = "";
		ModeloCancionImpl model = null;

		try {
			
			// PARAMETROS del formulario modificar
			
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String artista = request.getParameter("artista");
			String duracion = request.getParameter("duracion");
			String cover = request.getParameter("cover");

			long identi = Long.parseLong(id);

			model = ModeloCancionImpl.getInstance();

			Cancion c = model.getById(identi);
			c.setNombre(nombre);
			c.setArtista(artista);
			c.setDuracion(duracion);
			c.setCover(cover);

			// modificar la cancion

			if (model.update(c, identi)) {
				mensajeusuario = "Cancion modificada";
			} else {
				mensajeusuario = "Error Cancion NO Modificada";
			}
		} catch (Exception e) {
			mensajeusuario = "ERROR inesperado " + e.getMessage();
			e.printStackTrace();
		} finally {

			// enviamos ATRIBUTOS en la request para la JSP
			request.setAttribute("listado", model.getAll());
			request.setAttribute("mensaje", mensajeusuario);

			// vamos a la Vista
			RequestDispatcher dispatch = request.getRequestDispatcher("listado.jsp");
			dispatch.forward(request, response);
		}
	}

}