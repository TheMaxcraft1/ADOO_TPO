package Controller;

import Model.Ejemplar;
import Model.MediosContacto;
import Model.Prestamo;
import Model.Socio;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ControllerSocio {

    List<Socio> listaSocios;
    public void altaSocio(String dni, String nombre, String apellido, String mail, String telefono, MediosContacto medioPreferido){
        Socio nuevoSocio = new Socio();

        nuevoSocio.setDni(dni);
        nuevoSocio.setNombre(nombre);
        nuevoSocio.setApellido(apellido);
        nuevoSocio.setMail(mail);
        nuevoSocio.setTelefono(telefono);
        nuevoSocio.setMedioPreferido(medioPreferido);

    }

    public ArrayList<Prestamo> obtenerHistorialPrestamos(String dni){
        ArrayList<Prestamo> historial = new ArrayList<>(); //CREAMOS UNA LISTA VACIA
        for (Socio socio : listaSocios){ //BUSCAMOS EL SOCIO POR DNI
            if (socio.getDni().equals(dni))
                historial.addAll(socio.getHistorialPrestamo()); //AGREGAMOS TODOS LOS PRESTAMOS DE LA LISTA DEL SOCIO A LA LISTA QUE SE DEVOLVERA
        }
        return historial; //DEVOLVEMOS LISTA CON TODOS LOS PRESTAMOS
    }

    public void generarPrestamo(String dni, Ejemplar ejemplar){
        for (Socio socio: listaSocios) {
            if (socio.getDni().equals(dni))
                socio.generarPrestamo(ejemplar);
        }
    }
}
