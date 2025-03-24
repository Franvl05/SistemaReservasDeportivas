/**
 * Sistema de Reservas Deportivas que permite gestionar la reserva de pistas,
 * así como la activación y desactivación de iluminación.
 * 
 * @author Francisco Velasco
 */
import java.util.ArrayList;
import java.util.List;

public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Máximo de 10 pistas

    /**
     * Constructor de la clase que inicializa la lista de reservas y la iluminación de las pistas.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Reserva una pista en una fecha específica.
     * 
     * @param idPista Identificador de la pista a reservar.
     * @param fecha Fecha de la reserva en formato "YYYY-MM-DD".
     * @param duracion Duración de la reserva en horas.
     * @return true si la reserva fue exitosa, false si la pista ya estaba reservada o el ID es inválido.
     */
    public boolean reservarPista(int idPista, String fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false;
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false;
            }
        }
        reservas.add(new Reserva(idPista, fecha, duracion));
        return true;
    }

    /**
     * Cancela una reserva basada en su identificador de pista.
     * 
     * @param idReserva Identificador de la pista reservada.
     * @return true si la cancelación fue exitosa, false si no se encontró la reserva.
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Activa la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación fue activada correctamente, false si el ID es inválido.
     */
    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false;
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Desactiva la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación fue desactivada correctamente, false si el ID es inválido.
     */
    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false;
        }
        iluminacion[idPista] = false;
        return true;
    }

    /**
     * Verifica la disponibilidad de una pista en una fecha y hora determinadas.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha Fecha de consulta en formato "YYYY-MM-DD".
     * @param hora Hora de consulta.
     * @return true si la pista está disponible, false si ya está reservada.
     */
    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false;
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false;
            }
        }
        return true;
    }
}
