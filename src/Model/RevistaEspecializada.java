package Model;

import java.time.LocalDateTime;

public class RevistaEspecializada extends Ejemplar{
    public RevistaEspecializada(String idEjemplar, String titulo, String tema, String autor, String fechaPublicacion, boolean enPrestamo, boolean deBaja, tipoEjemplar categoria, Integer diasDisp) {
        super(idEjemplar, titulo, tema, autor, fechaPublicacion, enPrestamo, deBaja, categoria, diasDisp);
    }

}
