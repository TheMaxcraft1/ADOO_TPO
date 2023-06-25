package Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ObserverPrestamoDevuelto implements Observer{

    private Integer diasDeAviso = 2;

    public Integer getDiasDeAviso() {
        return diasDeAviso;
    }

    public void setDiasDeAviso(Integer diasDeAviso) {
        this.diasDeAviso = diasDeAviso;
    }

    @Override
    public void actualizar(Prestamo prestamo) {
        if (prestamo.isDevuelto() && (LocalDateTime.now().isBefore(prestamo.getFechaDevolucion()) || prestamo.getFechaDevolucion().equals(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS)))) {

            Socio contacto = prestamo.getSocioAsociado();
            Mensajeador mensajeador = new Mensajeador();

            //SETEAMOS EL MENSAJE A ENVIAR
            Mensaje mensaje = new Mensaje();
            mensaje.setFecha(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
            mensaje.setCuerpo("Devolvió en tiempo y forma el ejemplar prestado. Actualmente tiene " + contacto.getPrestamosCorrectos() + "prestamos devueltos correctamente. Devuelva 5 de manera correcta y obtendra un dia de prestamos extra.");
            mensaje.setMotivo("Ejemplar devuelto en tiempo y forma");

            switch (contacto.getMedioPreferido()){
                case MAIL:
                    mensajeador.setMedioMensaje(new Email(new AdaptadorAngus(new AngusMail(contacto.getMail()))));
                    break;
                case WPP:
                    mensajeador.setMedioMensaje(new Wpp(new AdaptadorTwilio(new TwilioSDK(contacto.getTelefono()))));
                    break;
                case SMS:
                    mensajeador.setMedioMensaje(new Sms(new AdaptadorTwilio(new TwilioSDK(contacto.getTelefono()))));
                    break;
            }

            mensajeador.enviarMensaje(mensaje);

        } else if (!prestamo.isDevuelto() && LocalDateTime.now().isAfter(prestamo.getFechaDevolucion())) {

        }
    }

}
