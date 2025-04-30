import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class LibroTest {
/**
 *  Estas son las pruebas unitarias para la clase Libro.
 */

    /**
     * Este test erifica que al crear un libro con datos válidos, sus atributos estén correctamente asignados.
     */
    @Test
    void testCrearLibroValido() {
        Libro libro = new Libro("978-3-16-148410-0", "The Hunger Games", "Suzanne Collins");

        assertEquals("978-3-16-148410-0", libro.getIsbn());
        assertEquals("The Hunger Games", libro.getTitulo());
        assertEquals("Suzanne Collins", libro.getAutor());
        assertEquals(Libro.Estado.DISPONIBLE, libro.getEstado());
    }

    /**
     * Este test verifica que se pueda cambiar correctamente el estado del libro.
     */
    @Test
    void testCambioEstadoLibro() {
        Libro libro = new Libro("978-3-16-148410-0", "The Hunger Games", "Suzanne Collins");

        libro.setEstado(Libro.Estado.PRESTADO);

        assertEquals(Libro.Estado.PRESTADO, libro.getEstado());
    }
}

