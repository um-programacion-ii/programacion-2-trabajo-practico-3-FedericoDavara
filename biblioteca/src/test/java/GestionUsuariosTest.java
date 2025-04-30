import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class GestionUsuariosTest {

    @Mock
    private Catalogo catalogo;

    @Mock
    private SistemaPrestamos sistemaPrestamos;

    @InjectMocks
    private GestionUsuarios gestionUsuarios;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gestionUsuarios = new GestionUsuarios(catalogo, sistemaPrestamos);
        gestionUsuarios.registrarUsuario("usuario1");
    }

    @Test
    void testRegistrarPrestamoExitoso() {
        Libro libro = new Libro("978-3-16-148410-0", "The Hunger Games", "Suzanne Collins");
        Prestamo prestamo = new Prestamo(libro);

        when(sistemaPrestamos.prestarLibro("978-3-16-148410-0")).thenReturn(prestamo);

        gestionUsuarios.registrarPrestamo("usuario1", "978-3-16-148410-0");

        Usuario usuario = gestionUsuarios.obtenerUsuario("usuario1");
        assertEquals(1, usuario.getHistorialPrestamos().size());
        verify(sistemaPrestamos).prestarLibro("978-3-16-148410-0");
    }

    @Test
    void testRegistrarUsuarioDuplicado() {
        assertThrows(IllegalArgumentException.class, () -> {
            gestionUsuarios.registrarUsuario("usuario1");
        });
    }

    @Test
    void testRegistrarPrestamoUsuarioInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            gestionUsuarios.registrarPrestamo("usuarioInvalido", "123");
        });
    }
}
