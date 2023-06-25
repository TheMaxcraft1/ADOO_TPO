package Model;

import Controller.ControllerSocio;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ObserverFechaActual {

    class Respuesta{
        boolean falta = false;
        boolean pasado = false;
    }

    private Respuesta respuesta = new Respuesta();
    private ControllerSocio cs;
    private LocalDateTime ultimaFecha;

    public ObserverFechaActual(LocalDateTime ultimaFecha) {
        this.ultimaFecha = LocalDateTime.MIN.truncatedTo(ChronoUnit.DAYS);
    }

    public void actualizar() throws Exception {
        LocalDateTime fechaActual = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        if (ultimaFecha.isEqual(fechaActual)) {
            chequear(this.cs.getInstances());
            ultimaFecha = fechaActual;
        }
    }

    public void chequear(ControllerSocio cs){
        for (Socio socio: cs.getListaSocios()){
            if (cs.verificarFechasProxima(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS),socio)){
                this.noticarFechaProxima();
            }
            else if (cs.verificarFechasPasada(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS), socio)){
                this.notificarFechaPasada();
                cs.getListaSocios();
            }
        }
    }

    public void noticarFechaProxima(){

    }

    public void notificarFechaPasada(){

    }
}

