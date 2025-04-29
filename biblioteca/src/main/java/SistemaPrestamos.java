public class SistemaPrestamos {
    private Catalogo catalogo;

    /**
     * Constructor del sistema de préstamos.*/

    public SistemaPrestamos(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    // Método principal para prestar un libro por su ISBN
    public Prestamo prestarLibro(String isbn) {
        Libro libro = catalogo.buscarPorIsbn(isbn);

        if (libro == null) {
            throw new IllegalArgumentException("Libro no encontrado con ISBN: " + isbn);
        }

        if (libro.getEstado() == Libro.Estado.PRESTADO) {
            throw new IllegalStateException("El libro ya está prestado.");
        }

        libro.setEstado(Libro.Estado.PRESTADO);  // Marcar como prestado
        return new Prestamo(libro);              // Retornar el préstamo
    }
}
