import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase gestiona los usuarios de la biblioteca.
 * Permite registrar nuevos usuarios y gestionar sus préstamos.
 */

public class GestionUsuarios {
    private Map<String, Usuario> usuarios = new HashMap<>();
    private Catalogo catalogo;
    private SistemaPrestamos sistemaPrestamos;

    public GestionUsuarios(Catalogo catalogo, SistemaPrestamos sistemaPrestamos) {
        this.catalogo = catalogo;
        this.sistemaPrestamos = sistemaPrestamos;
    }

    public void registrarUsuario(String nombre) {
        if (usuarios.containsKey(nombre)) {
            throw new IllegalArgumentException("El usuario ya existe.");
        }
        usuarios.put(nombre, new Usuario(nombre));
    }

    public Usuario obtenerUsuario(String nombre) {
        Usuario usuario = usuarios.get(nombre);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
        return usuario;
    }

    public void registrarPrestamo(String nombreUsuario, String isbn) {
        Usuario usuario = obtenerUsuario(nombreUsuario);
        Prestamo prestamo = sistemaPrestamos.prestarLibro(isbn);
        usuario.agregarPrestamo(prestamo);
    }
}
