package com.ipartek.formacion.canciones.pojo;

import com.ipartek.formacion.canciones.exception.CancionException;
import com.ipartek.formacion.canciones.utilidades.Utilidades;

public class Cancion {

	private long id;
	private String nombre;
	private String artista;
	private String duracion;
	private String cover;

	public Cancion(String nombre, String artista, String duracion, String cover) throws CancionException {
		super();
		this.nombre = nombre;
		this.artista = artista;
		setDuracion(duracion);
		this.cover=cover;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getDuracion() {
		return duracion;
	}

	/**
	 * La duracion de una Cancion debe tener el siguiente formato: [0]0:00
	 * 
	 * @param duracion
	 * @throws CancionException
	 *             Formato de duracion no correcto
	 */
	public void setDuracion(String duracion) throws CancionException {
		if (!Utilidades.validarDuracion(duracion)) {
			throw new CancionException(CancionException.MENSAJE_DURACION_FORTMAT);
		}

		this.duracion = duracion;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "Cancion [id=" + id + ", nombre=" + nombre + ", artista=" + artista + ", duracion=" + duracion
				+ ", cover=" + cover + "]";
	}

}
