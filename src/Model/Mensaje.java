package Model;

import java.time.LocalDateTime;

public class Mensaje {
    //getter y setters, constructor
    private LocalDateTime fecha;
    private String cuerpo = "Mensaje por defecto de la biblioteca";
    private String motivo;

    public LocalDateTime getFecha() {
        return this.fecha;
    }
    public String getCuerpo()
    {
        return this.cuerpo;
    }

    public String getMotivo(){return this.motivo;}

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}

