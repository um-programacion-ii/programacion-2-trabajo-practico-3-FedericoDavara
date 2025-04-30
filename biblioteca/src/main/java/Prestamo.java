import java.time.LocalDate;

/**
 * Esta clase representa un préstamo de un libro en la biblioteca.
 * Contiene información sobre el libro prestado y la fecha de préstamo.
 */
public class Prestamo {
    private Libro libro;
    private LocalDate fechaPrestamo;

    /**
     * Constructor: inicializa el préstamo con un libro y la fecha actual.
     * @param libro El libro que se está prestando
     */
    public Prestamo(Libro libro) {
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
}
