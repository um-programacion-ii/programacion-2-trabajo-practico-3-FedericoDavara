import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa el catálogo de la biblioteca, donde se almacenan los libros.
 */
public class Catalogo {

    // Lista interna que almacena todos los libros
    private List<Libro> libros;

    /**
     * Constructor: inicializa la lista de libros vacía.
     */
    public Catalogo() {
        this.libros = new ArrayList<>();
    }

    /**
     * Agrega un libro al catálogo.
     * @param libro El libro que se desea agregar
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Busca un libro por su ISBN.
     * @param isbn El ISBN a buscar
     * @return El libro encontrado o null si no se encuentra
     */
    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null; // Si no se encuentra
    }

    /**
     * Devuelve todos los libros disponibles en el catálogo.
     * @return Lista de libros en estado DISPONIBLE
     */
    public List<Libro> obtenerLibrosDisponibles() {
        List<Libro> disponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getEstado() == Libro.Estado.DISPONIBLE) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

    /**
     * Aqui se devuelve la lista completa de libros (puede usarse para pruebas).
     */
    public List<Libro> getTodosLosLibros() {
        return libros;
    }
}
