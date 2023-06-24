package Controller;

import Model.MediosContacto;
import Model.Prestamo;
import Model.Socio;

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
        ArrayList<Prestamo> historial = new ArrayList<>();
        for (Socio socio : listaSocios){
            if (socio.getDni() == dni)
                historial = (ArrayList<Prestamo>) socio.getHistorialPrestamo();
        }
        return historial;
    }

}
