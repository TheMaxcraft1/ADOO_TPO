package Controller;

import Model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerSocioTest {
    @Test
    void cargarSociosTest() throws Exception {
        ControllerSocio cs = ControllerSocio.getInstances();
        cs.altaSocio("44483055", "Nicolas", "Irigoyen", "nicolas.irigoyen2002@gmai.com", "1157035954", MediosContacto.SMS);
        cs.altaSocio("235655747", "Maximo", "Fain", "maximo.fain@gmai.com", "55777144741", MediosContacto.MAIL);
        cs.altaSocio("55977742", "Timoteo", "Lombardo", "timoteo.lombardo@gmai.com", "548477751", MediosContacto.WPP);

        ControllerEjemplar ce = ControllerEjemplar.getInstances();
        ce.altaEjemplar("1", "Physics for dummies", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro);
        ce.altaEjemplar("2", "Chemistry for dummies", "Chemistry", "Alfred", "20/09/2020", tipoEjemplar.Libro);

        cs.generarPrestamo("44483055", ce.buscarEjemplarParaPrestamo("1"));
        cs.generarPrestamo("235655747", ce.buscarEjemplarParaPrestamo("2"));


        //ESPECTED RESULTS

        //Creado de usuarios
        Socio nicolas = new Socio();
        nicolas.setDni("44483055");
        nicolas.setNombre("Nicolas");
        nicolas.setApellido("Irigoyen");
        nicolas.setMail("nicolas.irigoyen2002@gmai.com");
        nicolas.setTelefono("1157035954");
        nicolas.setMedioPreferido(MediosContacto.SMS);

        Socio maximo = new Socio();
        maximo.setDni("235655747");
        maximo.setNombre("Maximo");
        maximo.setApellido("Fain");
        maximo.setMail("maximo.fain@gmai.com");
        maximo.setTelefono("55777144741");
        maximo.setMedioPreferido(MediosContacto.MAIL);

        //Creado de ejemplares

        Ejemplar libro1 = new Libro("1", "Physics for dummies", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro, 10);
        Ejemplar libro2 = new Libro("2", "Chemistry for dummies", "Chemistry", "Alfred", "20/09/2020", tipoEjemplar.Libro, 10);

        //Creado de prestamos

        Prestamo prestamoNicolas = new Prestamo();
        prestamoNicolas.setFechaInicio(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        prestamoNicolas.setEjemplar(libro1);
        prestamoNicolas.setFechaDevolucion(prestamoNicolas.getFechaInicio().plusDays(0 + libro1.getDiasDisp()));

        Prestamo prestamoMaximo = new Prestamo();
        prestamoMaximo.setFechaInicio(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        prestamoMaximo.setEjemplar(libro2);
        prestamoMaximo.setFechaDevolucion(prestamoNicolas.getFechaInicio().plusDays(0 + libro2.getDiasDisp()));

        nicolas.getHistorialPrestamo().add(prestamoNicolas);
        maximo.getHistorialPrestamo().add(prestamoMaximo);

        // System.out.println(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getDiasRetraso());

        //TESTEO SOCIOS
        //Nicolas
        assertEquals(cs.listaSocios.get(0).getDni(), nicolas.getDni());
        assertEquals(cs.listaSocios.get(0).getNombre(), nicolas.getNombre());
        assertEquals(cs.listaSocios.get(0).getApellido(), nicolas.getApellido());
        assertEquals(cs.listaSocios.get(0).getMail(), nicolas.getMail());
        assertEquals(cs.listaSocios.get(0).getTelefono(), nicolas.getTelefono());
        assertEquals(cs.listaSocios.get(0).getMedioPreferido(), nicolas.getMedioPreferido());
        //Maximo
        assertEquals(cs.listaSocios.get(1).getDni(), maximo.getDni());
        assertEquals(cs.listaSocios.get(1).getNombre(), maximo.getNombre());
        assertEquals(cs.listaSocios.get(1).getApellido(), maximo.getApellido());
        assertEquals(cs.listaSocios.get(1).getMail(), maximo.getMail());
        assertEquals(cs.listaSocios.get(1).getTelefono(), maximo.getTelefono());
        assertEquals(cs.listaSocios.get(1).getMedioPreferido(), maximo.getMedioPreferido());

        //TESTEO PRESTAMOS CARGADOS EN HISTORIAL
        //Nicolas
        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getFechaInicio(), nicolas.getHistorialPrestamo().get(0).getFechaInicio());
        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getFechaDevolucion(), nicolas.getHistorialPrestamo().get(0).getFechaDevolucion());
        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getDiasRetraso(), nicolas.getHistorialPrestamo().get(0).getDiasRetraso());

        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getEjemplar().getIdEjemplar(), nicolas.getHistorialPrestamo().get(0).getEjemplar().getIdEjemplar());
        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getEjemplar().getCategoria(), nicolas.getHistorialPrestamo().get(0).getEjemplar().getCategoria());
        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getEjemplar().getAutor(), nicolas.getHistorialPrestamo().get(0).getEjemplar().getAutor());
        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getEjemplar().getTema(), nicolas.getHistorialPrestamo().get(0).getEjemplar().getTema());
        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getEjemplar().getTitulo(), nicolas.getHistorialPrestamo().get(0).getEjemplar().getTitulo());
        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getEjemplar().getFechaPublicacion(), nicolas.getHistorialPrestamo().get(0).getEjemplar().getFechaPublicacion());
        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0).getEjemplar().getDiasDisp(), nicolas.getHistorialPrestamo().get(0).getEjemplar().getDiasDisp());
        //Maximo
        assertEquals(cs.listaSocios.get(1).getHistorialPrestamo().get(0).getFechaInicio(), maximo.getHistorialPrestamo().get(0).getFechaInicio());
        assertEquals(cs.listaSocios.get(1).getHistorialPrestamo().get(0).getFechaDevolucion(), maximo.getHistorialPrestamo().get(0).getFechaDevolucion());
        assertEquals(cs.listaSocios.get(1).getHistorialPrestamo().get(0).getDiasRetraso(), maximo.getHistorialPrestamo().get(0).getDiasRetraso());

        assertEquals(cs.listaSocios.get(1).getHistorialPrestamo().get(0).getEjemplar().getIdEjemplar(), maximo.getHistorialPrestamo().get(0).getEjemplar().getIdEjemplar());
        assertEquals(cs.listaSocios.get(1).getHistorialPrestamo().get(0).getEjemplar().getCategoria(), maximo.getHistorialPrestamo().get(0).getEjemplar().getCategoria());
        assertEquals(cs.listaSocios.get(1).getHistorialPrestamo().get(0).getEjemplar().getAutor(), maximo.getHistorialPrestamo().get(0).getEjemplar().getAutor());
        assertEquals(cs.listaSocios.get(1).getHistorialPrestamo().get(0).getEjemplar().getTema(), maximo.getHistorialPrestamo().get(0).getEjemplar().getTema());
        assertEquals(cs.listaSocios.get(1).getHistorialPrestamo().get(0).getEjemplar().getTitulo(), maximo.getHistorialPrestamo().get(0).getEjemplar().getTitulo());
        assertEquals(cs.listaSocios.get(1).getHistorialPrestamo().get(0).getEjemplar().getFechaPublicacion(), maximo.getHistorialPrestamo().get(0).getEjemplar().getFechaPublicacion());
        assertEquals(cs.listaSocios.get(1).getHistorialPrestamo().get(0).getEjemplar().getDiasDisp(), maximo.getHistorialPrestamo().get(0).getEjemplar().getDiasDisp());

        //TESTEO EJEMPLARES CARGADOS
        //Libro 1
        assertEquals(ce.buscarEjemplarParaPrestamo("1").getIdEjemplar(), libro1.getIdEjemplar());
        assertEquals(ce.buscarEjemplarParaPrestamo("1").getCategoria(), libro1.getCategoria());
        //assertEquals(ce.buscarEjemplarParaPrestamo("1").getUbicacion(), libro1.getUbicacion());
        assertEquals(ce.buscarEjemplarParaPrestamo("1").getAutor(), libro1.getAutor());
        assertEquals(ce.buscarEjemplarParaPrestamo("1").getTema(), libro1.getTema());
        assertEquals(ce.buscarEjemplarParaPrestamo("1").getTitulo(), libro1.getTitulo());
        assertEquals(ce.buscarEjemplarParaPrestamo("1").getFechaPublicacion(), libro1.getFechaPublicacion());
        assertEquals(ce.buscarEjemplarParaPrestamo("1").getDiasDisp(), libro1.getDiasDisp());
        //Libro 2
        assertEquals(ce.buscarEjemplarParaPrestamo("2").getIdEjemplar(), libro2.getIdEjemplar());
        assertEquals(ce.buscarEjemplarParaPrestamo("2").getCategoria(), libro2.getCategoria());
        //assertEquals(ce.buscarEjemplarParaPrestamo("2").getUbicacion(), libro2.getUbicacion());
        assertEquals(ce.buscarEjemplarParaPrestamo("2").getAutor(), libro2.getAutor());
        assertEquals(ce.buscarEjemplarParaPrestamo("2").getTema(), libro2.getTema());
        assertEquals(ce.buscarEjemplarParaPrestamo("2").getTitulo(), libro2.getTitulo());
        assertEquals(ce.buscarEjemplarParaPrestamo("2").getFechaPublicacion(), libro2.getFechaPublicacion());
        assertEquals(ce.buscarEjemplarParaPrestamo("2").getDiasDisp(), libro2.getDiasDisp());

    }

    @Test
    void generarPrestamo() throws Exception {
        ControllerSocio cs = ControllerSocio.getInstances();
        cs.altaSocio("1", "Nico", "Lomfain", "mail1", "tel1", MediosContacto.SMS);
        Ejemplar libro1 = new Ejemplar("1", "titulo1", "cac", "Max Fain", "14/06/2002",
                tipoEjemplar.Libro, 4) {
        };
        cs.generarPrestamo("1", libro1);
        assertEquals(cs.listaSocios.get(0).getHistorialPrestamo().get(0), cs.listaSocios.get(0).getHistorialPrestamo().get(0));
    }

    @Test
    void mostrarHistorialPrestamos() throws Exception {
        ControllerSocio cs = ControllerSocio.getInstances();
        cs.altaSocio("44483055", "Nicolas", "Irigoyen", "nicolas.irigoyen2002@gmai.com", "1157035954", MediosContacto.SMS);
        cs.altaSocio("235655747", "Maximo", "Fain", "maximo.fain@gmai.com", "55777144741", MediosContacto.MAIL);
        cs.altaSocio("55977742", "Timoteo", "Lombardo", "timoteo.lombardo@gmai.com", "548477751", MediosContacto.WPP);

        ControllerEjemplar ce = ControllerEjemplar.getInstances();
        ce.altaEjemplar("1", "Physics for dummies", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro);
        ce.altaEjemplar("2", "Chemistry for dummies", "Chemistry", "Alfred", "20/09/2020", tipoEjemplar.Libro);

        cs.generarPrestamo("44483055", ce.buscarEjemplarParaPrestamo("1"));
        cs.setDevuelto("44483055");

        cs.generarPrestamo("44483055", ce.buscarEjemplarParaPrestamo("2"));

        //ESPECTED RESULTS
        cs.mostrarHistorialPrestamos("44483055");

    }

    @Test
    void prueba() throws Exception {
        ControllerSocio cs = ControllerSocio.getInstances();
        cs.altaSocio("44483055", "Nicolas", "Irigoyen", "nicolas.irigoyen2002@gmai.com", "1157035954", MediosContacto.SMS);
        cs.altaSocio("235655747", "Maximo", "Fain", "maximo.fain@gmai.com", "55777144741", MediosContacto.MAIL);
        cs.altaSocio("55977742", "Timoteo", "Lombardo", "timoteo.lombardo@gmai.com", "548477751", MediosContacto.WPP);



        for (Socio socio: cs.getListaSocios()){
            socio.setTelefono("22222");
        }

        for (Socio socio: cs.getListaSocios()){
            System.out.println(socio.getTelefono());
        }
    }
}


