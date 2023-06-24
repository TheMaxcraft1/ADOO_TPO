package Model;

import java.time.LocalDateTime;
import java.util.List;

public class Socio {
    //getter y setters
    private String dni;
    private String nombre;
    private String apellido;
    private String mail;

    private String telefono;
    private MediosContacto medioPreferido;
    private int diasPrestamo;
    private int prestamosCorrectos;
    private EstadoSocio estado;
    private List<Prestamo> historialPrestamo;


    //METODOS
    public void aumentarDiasPrestamo(Integer diasPrestamo, Integer prestamosCorrectos){

    }

    public void decrementarDiasPrestamo(Integer diasPrestamo, Integer prestamosCorrectos){

    }

    public void generarPrestamo(LocalDateTime fechaInicio, boolean devuelto, Integer diasRetraso, LocalDateTime fechaDevolucion){

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
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
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
}
