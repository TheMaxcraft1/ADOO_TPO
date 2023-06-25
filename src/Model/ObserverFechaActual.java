package Model;

import Controller.ControllerSocio;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ObserverFechaActual{

    private ControllerSocio cs = ControllerSocio.getInstances();
    private LocalDateTime ultimaFecha;

    public ObserverFechaActual(LocalDateTime ultimaFecha) throws Exception {
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
                this.noticarFechaProxima(socio);
            }
            else if (cs.verificarFechasPasada(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS), socio)){
                this.notificarFechaPasada(socio);
                socio.setdiasBloqueo(socio.getdiasBloqueo()-1);
            }
        }
    }

    public void noticarFechaProxima(Socio socio){
        Mensajeador mensajeador = new Mensajeador();

        //SETEAMOS EL MENSAJE A ENVIAR
        Mensaje mensaje = new Mensaje();
        mensaje.setFecha(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        mensaje.setCuerpo("Dentro de 2 dias deberas devolver el ejemplar que tomaste prestado de la Biblioteca. No te olvides!");
        mensaje.setMotivo("Proxima devolucion de ejemplar");

        switch (socio.getMedioPreferido()){
            case MAIL:
                mensajeador.setMedioMensaje(new Email(new AdaptadorAngus(new AngusMail(socio.getMail()))));
                break;
            case WPP:
                mensajeador.setMedioMensaje(new Wpp(new AdaptadorTwilio(new TwilioSDK(socio.getTelefono()))));
                break;
            case SMS:
                mensajeador.setMedioMensaje(new Sms(new AdaptadorTwilio(new TwilioSDK(socio.getTelefono()))));
                break;
        }

        mensajeador.enviarMensaje(mensaje);
    }

    public void notificarFechaPasada(Socio socio){
        Mensajeador mensajeador = new Mensajeador();

        //SETEAMOS EL MENSAJE A ENVIAR
        Mensaje mensaje = new Mensaje();
        mensaje.setFecha(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        mensaje.setCuerpo("La fecha de devolucion del ejemplar que tomaste prestado ya se ha vencido y no lo haz devuelto. Debido a esto, recibiras una penalizacion para todos tus futuros prestamos, reduciendo la cantidad de dias en 1. Esto seguira ocurriendo todos los dias. Si llegas a 10 dias sin haberlo devuelto, se te ");
        mensaje.setMotivo("Devolucion tardia - Penalizacion");

        switch (socio.getMedioPreferido()){
            case MAIL:
                mensajeador.setMedioMensaje(new Email(new AdaptadorAngus(new AngusMail(socio.getMail()))));
                break;
            case WPP:
                mensajeador.setMedioMensaje(new Wpp(new AdaptadorTwilio(new TwilioSDK(socio.getTelefono()))));
                break;
            case SMS:
                mensajeador.setMedioMensaje(new Sms(new AdaptadorTwilio(new TwilioSDK(socio.getTelefono()))));
                break;
        }

        mensajeador.enviarMensaje(mensaje);
    }
}

