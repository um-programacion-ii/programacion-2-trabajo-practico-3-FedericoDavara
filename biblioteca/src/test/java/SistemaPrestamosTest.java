import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * En esta clase Test se realizan las pruebas para la clase SistemaPrestamos.
 */
public class SistemaPrestamosTest {

    @Mock
    private Catalogo catalogo; // Mock del catálogo

    @InjectMocks
    private SistemaPrestamos sistemaPrestamos; // Clase bajo prueba

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
        sistemaPrestamos = new SistemaPrestamos(catalogo);
    }

    @Test
    void testPrestarLibroExitoso() {
        // Crear un libro DISPONIBLE
        Libro libro = new Libro("978-3-16-148410-0", "The Hunger Games", "Suzanne Collins");

        // Configurar el mock para devolver el libro al buscarlo por ISBN
        when(catalogo.buscarPorIsbn("978-3-16-148410-0")).thenReturn(libro);

        // Ejecutar el método que se quiere testear
        Prestamo prestamo = sistemaPrestamos.prestarLibro("978-3-16-148410-0");

        // Verificaciones
        assertNotNull(prestamo);
        assertEquals(libro, prestamo.getLibro());
        assertEquals(Libro.Estado.PRESTADO, libro.getEstado());
        verify(catalogo).buscarPorIsbn("978-3-16-148410-0"); // Se llamó al mock correctamente
    }

    @Test
    void testPrestarLibroInexistente() {
        when(catalogo.buscarPorIsbn("0000")).thenReturn(null);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            sistemaPrestamos.prestarLibro("0000");
        });

        assertEquals("Libro no encontrado con ISBN: 0000", ex.getMessage());
    }

    @Test
    void testPrestarLibroYaPrestado() {
        Libro libro = new Libro("978-3-16-148410-0", "The Hunger Games", "Suzanne Collins");
        libro.setEstado(Libro.Estado.PRESTADO);

        when(catalogo.buscarPorIsbn("978-3-16-148410-0")).thenReturn(libro);

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            sistemaPrestamos.prestarLibro("978-3-16-148410-0");
        });

        assertEquals("El libro ya está prestado.", ex.getMessage());
    }
}
