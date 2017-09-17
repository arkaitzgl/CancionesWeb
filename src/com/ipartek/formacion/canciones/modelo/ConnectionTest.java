package com.ipartek.formacion.canciones.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.ipartek.formacion.canciones.pojo.Cancion;

public class ConnectionTest {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		try {
			
			// comprobar que el driver o libreria existe
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Mysql cargado");

			// establecido conexion
			String url = "jdbc:mysql://192.168.0.42:3306/spoty";
			String user = "alumno";
			String password = "alumno";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conexion establecida");

			// consultar todas las canciones de la tabla cancion
			String sqlGetAll = "SELECT id,nombre,artista,duracion,cover FROM cancion ORDER BY id DESC";
			pst = con.prepareStatement(sqlGetAll);

			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String artista = rs.getString("artista");
				String duracion = rs.getString("duracion");
				String cover = rs.getString("cover");
				
				Cancion c = new Cancion(nombre, artista, duracion, cover);
				c.setId(id);
				
				System.out.println(c);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}