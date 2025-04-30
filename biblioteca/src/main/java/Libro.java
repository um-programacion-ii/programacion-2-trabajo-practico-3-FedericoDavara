public class Libro {
    /**
     * Clase Libro que representa un libro en una biblioteca.
     * Cada libro tiene un ISBN, un título, un autor y un estado (DISPONIBLE o PRESTADO).
     */

    // Enum interno que representa el estado del libro
    public enum Estado {
        DISPONIBLE,
        PRESTADO
    }

    // Atributos privados del libro
    private String ISBN;
    private String titulo;
    private String autor;
    private Estado estado;

    public Libro(String isbn, String titulo, String autor) {
        this.ISBN = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = Estado.DISPONIBLE;
    }

    // Métodos getter para acceder a los atributos

    public String getIsbn() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Estado getEstado() {
        return estado;
    }

    /**
     * Cambia el estado del libro (por ejemplo, de DISPONIBLE a PRESTADO).
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
