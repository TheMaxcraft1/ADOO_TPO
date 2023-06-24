package Controller;

import Model.Ejemplar;
import Model.MediosContacto;
import Model.tipoEjemplar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerSocioTest {
/*
package Test;
import static org.junit.jupiter.api.Assertions.*;

class VentasControllerTest {

    @org.junit.jupiter.api.Test
    void agregarRemito() {
        VentasController VC = VentasController.getInstance();
        RemitosEmitidosDTO r = new RemitosEmitidosDTO();
        VC.agregarRemito("1234", r);

        assertEquals(2, VC.agregarRemito("1234", r));

    }
}
* */
    @Test
    void generarPrestamo() throws Exception {
        ControllerSocio cs = ControllerSocio.getInstances();
        cs.altaSocio("1", "Nico", "Lomfain", "mail1", "tel1", MediosContacto.SMS);
        Ejemplar libro1 = new Ejemplar("1", "titulo1", "cac", "Max Fain", "14/06/2002",
                tipoEjemplar.Libro, 4) {
        };
        cs.generarPrestamo("1", libro1);

        // System.out.println(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getDiasRetraso());


        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0), cs.listaSocios.get(0).getHistorialPrestamo().get(0));

    }
    }
