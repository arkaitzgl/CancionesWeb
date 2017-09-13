package com.ipartek.formacion.canciones.utilidades;

public class Utilidades {

	/**
	 * Valida la duracion de una cancion que debe tener el siguiente formato 0:00
	 * 
	 * Antes de los dos puntos ":" debe contener al menos 1 digito <br>
	 * Despues de los dos puntos ":" debe contenersolo 2 digitos y ser < 60 <br>
	 * 
	 * @param duracion
	 *            String
	 * @return true si formato correcto, false en caso contrario
	 */

	static public boolean validarDuracion(String duracion) {

		boolean resul = false;
		if (duracion != null) {
			try {

				// buscar valores negativos
				if (duracion.indexOf("-") == -1) {

					String[] tiempo = duracion.split(":");
					if (tiempo.length == 2) {

						int minutos = Integer.parseInt(tiempo[0]);
						int segundos = Integer.parseInt(tiempo[1]);

						// minutos y segundos
						if (minutos >= 0 && (segundos >= 0 && segundos < 60)) {
							resul = true;
						}

					} // if split
				} // duracion.indexOf("-")

			} catch (Exception e) {
				// e.printStackTrace();
			}
		} // duracion null
		return resul;
	}

}