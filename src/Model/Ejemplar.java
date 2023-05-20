package Model;

import java.time.LocalDateTime;

public abstract class Ejemplar {
    private String idEjemplar;
    private String titulo;
    private String tema;
    private String autor;
    private LocalDateTime fechaPublicacion;
    private EstadoEjemplar estado;
}
