package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Socio {
    private String dni;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private MediosContacto medioPreferido;
    private Integer diasExtra;
    private Integer prestamosCorrectos;
    private List<Prestamo> historialPrestamo = new ArrayList<>();
    private Boolean habilitado = true;

    private Integer diasBloqueo;



    //METODOS

    public void decrementarDiasPrestamo(){
        diasExtra--;
        if (diasExtra == 0)
            setHabilitado(false);
    }

    //ASUMIMOS QUE NO SE PUEDEN TENER MAS DE UN PRE
    public void generarPrestamo(Ejemplar ejemplar){
        if (historialPrestamo.isEmpty() || historialPrestamo.get(historialPrestamo.size()-1).isDevuelto()){
            Prestamo nuevoPrestamo = new Prestamo();
            nuevoPrestamo.setEjemplar(ejemplar);
            nuevoPrestamo.setFechaDevolucion(nuevoPrestamo.getFechaInicio().plusDays(diasExtra + ejemplar.getDiasDisp()));
            nuevoPrestamo.setSocioAsociado(this);
            historialPrestamo.add(nuevoPrestamo);
        }
    }

    public void devolverPrestamo(){
        historialPrestamo.get(historialPrestamo.size()-1).setDevuelto(true);
    }

    public void sumarPrestamoCorrecto(){
        prestamosCorrectos++;
        if (prestamosCorrectos == 5){
            prestamosCorrectos = 0;
            diasExtra++;
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

    public int getdiasBloqueo() {
        return diasBloqueo;
    }

    public void setdiasBloqueo(int diasPrestamo) {
        this.diasBloqueo = diasPrestamo;
    }

    public int getPrestamosCorrectos() {
        return prestamosCorrectos;
    }

    public void setPrestamosCorrectos(int prestamosCorrectos) {
        this.prestamosCorrectos = prestamosCorrectos;
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
        return diasExtra == socio.diasExtra && prestamosCorrectos == socio.prestamosCorrectos && Objects.equals(dni, socio.dni) && Objects.equals(nombre, socio.nombre) && Objects.equals(apellido, socio.apellido) && Objects.equals(mail, socio.mail) && Objects.equals(telefono, socio.telefono) && medioPreferido == socio.medioPreferido && Objects.equals(historialPrestamo, socio.historialPrestamo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellido, mail, telefono, medioPreferido, diasExtra, prestamosCorrectos, historialPrestamo);
    }

    public int getDiasExtra() {
        return diasExtra;
    }

    public void setDiasExtra(int diasExtra) {
        this.diasExtra = diasExtra;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
}
