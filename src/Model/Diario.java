package Model;

import java.time.LocalDateTime;

public class Diario extends Ejemplar{
    public Diario(String idEjemplar, String titulo, String tema, String autor, String fechaPublicacion, boolean enPrestamo, boolean deBaja, tipoEjemplar categoria, Integer diasDisp) {
        super(idEjemplar, titulo, tema, autor, fechaPublicacion, enPrestamo, deBaja, categoria, diasDisp);
    }
}
