package Controller;

import Model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


class ControllerObserverFechaTest {

    @Test
    void notificacionFechaProxima() throws Exception {
        ControllerSocio cs = ControllerSocio.getInstances();
        cs.altaSocio("44483055", "Nicolas", "Irigoyen", "nicolas.irigoyen2002@gmai.com", "1157035954", MediosContacto.SMS);

        Socio nicolas = new Socio();
        nicolas.setDni("44483055");
        nicolas.setNombre("Nicolas");
        nicolas.setApellido("Irigoyen");
        nicolas.setMail("nicolas.irigoyen2002@gmai.com");
        nicolas.setTelefono("1157035954");
        nicolas.setMedioPreferido(MediosContacto.SMS);

        Ejemplar libro1 = new Libro("1", "Physics for dummies", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro, 10);

        Prestamo prestamoNicolas = new Prestamo();
        prestamoNicolas.setFechaInicio(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        prestamoNicolas.setEjemplar(libro1);
        prestamoNicolas.setFechaDevolucion(LocalDateTime.now().plusDays(2).truncatedTo(ChronoUnit.DAYS));

        ControllerEjemplar ce = ControllerEjemplar.getInstances();
        ce.altaEjemplar("1", "Physics for dummies", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro);

        cs.listaSocios.get(0).getHistorialPrestamo().add(prestamoNicolas);

        ControllerObserverFecha co = ControllerObserverFecha.getInstances();
        co.comenzarChequeoDiario(5000);
    }

    @Test
    void notificacionFechaPasada() throws Exception {
        ControllerSocio cs = ControllerSocio.getInstances();
        cs.altaSocio("44483055", "Nicolas", "Irigoyen", "nicolas.irigoyen2002@gmai.com", "1157035954", MediosContacto.SMS);

        Socio nicolas = new Socio();
        nicolas.setDni("44483055");
        nicolas.setNombre("Nicolas");
        nicolas.setApellido("Irigoyen");
        nicolas.setMail("nicolas.irigoyen2002@gmai.com");
        nicolas.setTelefono("1157035954");
        nicolas.setMedioPreferido(MediosContacto.SMS);

        Ejemplar libro1 = new Libro("1", "Physics for dummies", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro, 10);

        Prestamo prestamoNicolas = new Prestamo();
        prestamoNicolas.setFechaInicio(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        prestamoNicolas.setEjemplar(libro1);
        prestamoNicolas.setFechaDevolucion(LocalDateTime.now().minusDays(2).truncatedTo(ChronoUnit.DAYS));

        ControllerEjemplar ce = ControllerEjemplar.getInstances();
        ce.altaEjemplar("1", "Physics for dummies", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro);

        cs.listaSocios.get(0).getHistorialPrestamo().add(prestamoNicolas);

        ControllerObserverFecha co = ControllerObserverFecha.getInstances();
        co.comenzarChequeoDiario(5000);
    }

}