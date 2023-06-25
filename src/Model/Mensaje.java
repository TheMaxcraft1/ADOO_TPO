package Model;

import java.time.LocalDateTime;

public class Mensaje {
    //getter y setters, constructor
    private LocalDateTime fecha;
    private String cuerpo;
    private String motivo;

    public LocalDateTime getFecha() {
        return this.fecha;
    }
    public String getCuerpo()
    {
        return this.cuerpo;
    }

    public String getMotivo(){return this.motivo;}
}
