
public class GestorIluminacion {
	public boolean[] iluminacion;

	public GestorIluminacion() {
	}

	/**
	 * Desactiva la iluminación de una pista específica.
	 * 
	 * @param sistemaReservasDeportivas TODO
	 * @param idPista Identificador de la pista.
	 * @return true si la iluminación fue desactivada correctamente, false si el ID es inválido.
	 */
	public boolean apagarLuces(SistemaReservasDeportivas sistemaReservasDeportivas, int idPista) {
	    if (idPista < 0 || idPista >= SistemaReservasDeportivas.MAX_PISTAS) {
	        return false;
	    }
	    iluminacion[idPista] = false;
	    return true;
	}

	/**
	 * Activa la iluminación de una pista específica.
	 * 
	 * @param sistemaReservasDeportivas TODO
	 * @param idPista Identificador de la pista.
	 * @return true si la iluminación fue activada correctamente, false si el ID es inválido.
	 */
	public boolean encenderLuces(SistemaReservasDeportivas sistemaReservasDeportivas, int idPista) {
	    if (idPista < 0 || idPista >= SistemaReservasDeportivas.MAX_PISTAS) {
	        return false;
	    }
	    iluminacion[idPista] = true;
	    return true;
	}
}