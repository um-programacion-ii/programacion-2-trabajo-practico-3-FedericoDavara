import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa un usuario de la biblioteca.
 * Contiene información sobre el nombre del usuario y su historial de préstamos.
 */

public class Usuario {
    private String nombre;
    private List<Prestamo> historialPrestamos;


    /**
     * Constructor: inicializa el usuario con un nombre y un historial de préstamos vacío.
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.historialPrestamos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Prestamo> getHistorialPrestamos() {
        return historialPrestamos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        historialPrestamos.add(prestamo);
    }
}
