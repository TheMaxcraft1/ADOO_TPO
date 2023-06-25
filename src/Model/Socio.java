package Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Socio {
    //getter y setters
    private String dni;
    private String nombre;
    private String apellido;
    private String mail;

    private String telefono;
    private MediosContacto medioPreferido;
    private int diasExtra;
    private int prestamosCorrectos;
    private EstadoSocio estado;
    private List<Prestamo> historialPrestamo = new ArrayList<>();


    //METODOS
    public void aumentarDiasPrestamo(Integer diasPrestamo, Integer prestamosCorrectos){

    }

    public void decrementarDiasPrestamo(Integer diasPrestamo, Integer prestamosCorrectos){

    }

    //ASUMIMOS QUE NO SE PUEDEN TENER MAS DE UN PRE
    public void generarPrestamo(Ejemplar ejemplar){
        if (historialPrestamo.isEmpty() || historialPrestamo.get(historialPrestamo.size()).isDevuelto()){
        Prestamo nuevoPrestamo = new Prestamo();
        nuevoPrestamo.setEjemplar(ejemplar);
        nuevoPrestamo.setFechaDevolucion(nuevoPrestamo.getFechaInicio().plusDays(diasExtra + ejemplar.getDiasDisp()));
        historialPrestamo.add(nuevoPrestamo);
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public MediosContacto getMedioPreferido() {
        return medioPreferido;
    }

    public void setMedioPreferido(MediosContacto medioPreferido) {
        this.medioPreferido = medioPreferido;
    }

    public int getDiasPrestamo() {
        return diasExtra;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasExtra = diasPrestamo;
    }

    public int getPrestamosCorrectos() {
        return prestamosCorrectos;
    }

    public void setPrestamosCorrectos(int prestamosCorrectos) {
        this.prestamosCorrectos = prestamosCorrectos;
    }

    public EstadoSocio getEstado() {
        return estado;
    }

    public void setEstado(EstadoSocio estado) {
        this.estado = estado;
    }

    public List<Prestamo> getHistorialPrestamo() {
        return historialPrestamo;
    }

    public void setHistorialPrestamo(List<Prestamo> historialPrestamo) {
        this.historialPrestamo = historialPrestamo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return diasExtra == socio.diasExtra && prestamosCorrectos == socio.prestamosCorrectos && Objects.equals(dni, socio.dni) && Objects.equals(nombre, socio.nombre) && Objects.equals(apellido, socio.apellido) && Objects.equals(mail, socio.mail) && Objects.equals(telefono, socio.telefono) && medioPreferido == socio.medioPreferido && Objects.equals(estado, socio.estado) && Objects.equals(historialPrestamo, socio.historialPrestamo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellido, mail, telefono, medioPreferido, diasExtra, prestamosCorrectos, estado, historialPrestamo);
    }
}
