import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * En esta clase Test se realizan las pruebas para la clase Catalogo.
 */
public class CatalogoTest {

    private Catalogo catalogo;
    private Libro libro1;
    private Libro libro2;

    /**
     * Se ejecuta antes de cada prueba. Inicializa el catálogo con dos libros.
     */
    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        libro1 = new Libro("978-3-16-148410-0", "The Hunger Games", "Suzanne Collins");
        libro2 = new Libro("978-0-13-235088-4", "The Hunger Games Catching Fire", "Suzanne Collins");
        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
    }

    /**
     * Verifica que se puede encontrar un libro por su ISBN correctamente.
     */
    @Test
    void testBuscarPorIsbnExistente() {
        Libro libro = catalogo.buscarPorIsbn("978-3-16-148410-0");
        assertNotNull(libro);
        assertEquals("The Hunger Games", libro.getTitulo());
    }

    /**
     * En este test se verifica que se devuelva null al buscar un ISBN inexistente.
     */
    @Test
    void testBuscarPorIsbnInexistente() {
        Libro libro = catalogo.buscarPorIsbn("000-0-00-000000-0");
        assertNull(libro);
    }

    /**
     * En este test se verifica que se listen correctamente los libros disponibles.
     */
    @Test
    void testObtenerLibrosDisponibles() {
        libro2.setEstado(Libro.Estado.PRESTADO); // Uno de los libros no está disponible
        List<Libro> disponibles = catalogo.obtenerLibrosDisponibles();

        assertEquals(1, disponibles.size());
        assertEquals("The Hunger Games", disponibles.get(0).getTitulo());
    }

    /**
     * Verifica que se puedan agregar múltiples libros y recuperarlos.
     */
    @Test
    void testAgregarMultiplesLibros() {
        assertEquals(2, catalogo.getTodosLosLibros().size());
    }
}