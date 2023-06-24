package Model;

public class Revista extends Ejemplar{

    public Revista(String idEjemplar, String titulo, String tema, String autor, String fechaPublicacion, boolean enPrestamo, boolean deBaja, tipoEjemplar categoria) {
        super(idEjemplar, titulo, tema, autor, fechaPublicacion, enPrestamo, deBaja, categoria);
    }

}
