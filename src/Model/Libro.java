package Model;

public class Libro extends Ejemplar{

    public Libro(String idEjemplar, String titulo, String tema, String autor, String fechaPublicacion, tipoEjemplar categoria, Integer diasDisp) {
        super(idEjemplar, titulo, tema, autor, fechaPublicacion, categoria, diasDisp);
    }

}
