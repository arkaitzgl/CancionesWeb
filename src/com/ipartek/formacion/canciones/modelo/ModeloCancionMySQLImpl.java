package com.ipartek.formacion.canciones.modelo;

import java.sql.Connection;
import java.util.ArrayList;

import com.ipartek.formacion.canciones.pojo.Cancion;

public class ModeloCancionMySQLImpl implements ModeloCancion{

	@Override
	public ArrayList<Cancion> getAll() {
		
		Connection con = ConnectionManager.getConnection();
		
		
		ConnectionManager.closeConnection();
		return null;
	}

	@Override
	public Cancion getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Cancion c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cancion c, long id) {
		// TODO Auto-generated method stub
		return false;
	}

}