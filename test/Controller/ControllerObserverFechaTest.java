package Controller;

import Model.MediosContacto;
import Model.tipoEjemplar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerObserverFechaTest {

    @Test
    void notificacio() throws Exception {
        ControllerSocio cs = ControllerSocio.getInstances();
        cs.altaSocio("44483055", "Nicolas", "Irigoyen", "nicolas.irigoyen2002@gmai.com", "1157035954", MediosContacto.SMS);

        ControllerEjemplar ce = ControllerEjemplar.getInstances();
        ce.altaEjemplar("1", "Physics for dummies", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro);

        cs.generarPrestamo("44483055", ce.buscarEjemplarParaPrestamo("1"));

        ControllerObserverFecha co = ControllerObserverFecha.getInstances();
        co.comenzarChequeoDiario(5000);

    }

}