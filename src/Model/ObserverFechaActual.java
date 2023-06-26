package Model;

import Controller.ControllerSocio;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ObserverFechaActual implements Observer{

    private ControllerSocio cs = ControllerSocio.getInstances();
    private LocalDateTime ultimaFecha;

    public ObserverFechaActual(LocalDateTime ultimaFecha) throws Exception {
        this.ultimaFecha = LocalDateTime.MIN.truncatedTo(ChronoUnit.DAYS);
    }

    public void actualizar() throws Exception {
        LocalDateTime fechaActual = LocalDateTime.now();//.truncatedTo(ChronoUnit.DAYS);
        if (!ultimaFecha.isEqual(fechaActual)) {
            chequear(cs.getInstances());
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
                socio.decrementarDiasBloqueo();
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

        switch (socio.getMedioPreferido()) {
            case MAIL -> mensajeador.setMedioMensaje(new Email(new AdaptadorAngus(new AngusMail(socio.getMail()))));
            case WPP -> mensajeador.setMedioMensaje(new Wpp(new AdaptadorTwilio(new TwilioSDK(socio.getTelefono()))));
            case SMS -> mensajeador.setMedioMensaje(new Sms(new AdaptadorTwilio(new TwilioSDK(socio.getTelefono()))));
        }
        mensajeador.enviarMensaje(mensaje);
    }

    public void notificarFechaPasada(Socio socio){
        Mensajeador mensajeador = new Mensajeador();

        //SETEAMOS EL MENSAJE A ENVIAR
        Mensaje mensaje = new Mensaje();
        mensaje.setFecha(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        mensaje.setCuerpo("La fecha de devolucion del ejemplar que tomaste prestado ya se ha vencido y no lo haz devuelto. Debido a esto, recibiras una penalizacion para todos tus futuros prestamos, reduciendo la cantidad de dias en 1. Esto seguira ocurriendo todos los dias. Quedan " + socio.getdiasBloqueo() + "dias hasta que seas bloqueado.");
        mensaje.setMotivo("Devolucion tardia - Penalizacion");

        switch (socio.getMedioPreferido()) {
            case MAIL -> mensajeador.setMedioMensaje(new Email(new AdaptadorAngus(new AngusMail(socio.getMail()))));
            case WPP -> mensajeador.setMedioMensaje(new Wpp(new AdaptadorTwilio(new TwilioSDK(socio.getTelefono()))));
            case SMS -> mensajeador.setMedioMensaje(new Sms(new AdaptadorTwilio(new TwilioSDK(socio.getTelefono()))));
        }
        mensajeador.enviarMensaje(mensaje);
    }
}

