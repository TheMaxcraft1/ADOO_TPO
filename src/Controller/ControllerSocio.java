package Controller;

import Model.Ejemplar;
import Model.MediosContacto;
import Model.Prestamo;
import Model.Socio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControllerSocio {

    List<Socio> listaSocios = new ArrayList<>();
    private static ControllerSocio CONTROLLERSOCIO = null;

    public static synchronized ControllerSocio getInstances() throws Exception {
        if (CONTROLLERSOCIO == null) CONTROLLERSOCIO = new ControllerSocio();
        return CONTROLLERSOCIO;
    }

    public void altaSocio(String dni, String nombre, String apellido, String mail, String telefono, MediosContacto medioPreferido) {
        Socio nuevoSocio = new Socio();

        nuevoSocio.setDni(dni);
        nuevoSocio.setNombre(nombre);
        nuevoSocio.setApellido(apellido);
        nuevoSocio.setMail(mail);
        nuevoSocio.setTelefono(telefono);
        nuevoSocio.setMedioPreferido(medioPreferido);

        listaSocios.add(nuevoSocio);
    }

    public void setDevuelto(String dni) throws Exception {
        for (Socio socio:listaSocios){
            if (socio.getDni().equals(dni)) {
                socio.devolverPrestamo();
                socio.getHistorialPrestamo().get(socio.getHistorialPrestamo().size() - 1).getEjemplar().setEnPrestamo(false);
            }
        }
    }

    public void generarPrestamo(String dni, Ejemplar ejemplar) {
        if(!ejemplar.isDeBaja() && !ejemplar.isEnPrestamo()){ //Si el ejemplar no esta en prestamo ni de baja
            for (Socio socio : listaSocios) {
                if (socio.getDni().equals(dni)){
                    if (socio.isHabilitado()){
                        socio.generarPrestamo(ejemplar);
                        ejemplar.setEnPrestamo(true);
                    }
                }
            }
        }
    }

    public List<Socio> getListaSocios() {
        return listaSocios;
    }

    public void habilitarSocio(String dni){
        for (Socio socio:listaSocios){
            if (socio.getDni().equals(dni))
                socio.setHabilitado(true);
        }
    }

    public void mostrarHistorialPrestamos(String dni) {
        for( Socio socio : listaSocios) {
            if (socio.getDni().equals(dni)) {
                System.out.println();
                System.out.println("Historial de prestamos del socio: " + socio.getNombre() + " " + socio.getApellido());
                System.out.println("-----------------------------------------------");
                System.out.println();
                List<Prestamo> historialPrestamos = new ArrayList<>();
                historialPrestamos.addAll(socio.getHistorialPrestamo());
                for( Prestamo prestamo: historialPrestamos)
                    prestamo.mostrarPrestamo();
            }
        }
    }

    public boolean verificarFechasProxima(LocalDateTime fechaActual, Socio socio){
            Prestamo ultimoPrestamo = socio.getHistorialPrestamo().get(socio.getHistorialPrestamo().size()-1);
            if(!ultimoPrestamo.isDevuelto()) {
                if (ultimoPrestamo.getFechaDevolucion().isEqual(fechaActual.minusDays(2))) {
                    return true;
                }
            }
        return false;
    }

    public boolean verificarFechasPasada(LocalDateTime fechaActual, Socio socio){
        Prestamo ultimoPrestamo = socio.getHistorialPrestamo().get(socio.getHistorialPrestamo().size()-1);
        if(!ultimoPrestamo.isDevuelto()) {
            if (ultimoPrestamo.getFechaDevolucion().isBefore(fechaActual)) {
                return true;
            }
        }
        return false;
    }
}
