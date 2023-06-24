package Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Prestamo {

    //getter y setter, constructor
    private LocalDateTime fechaInicio;
    private boolean devuelto = false;
    private int diasRetraso = 0;
    private LocalDateTime fechaDevolucion;
    private int diasPrestamo;
    private Socio socio;
    private Ejemplar ejemplar;

    public Prestamo(String dni, LocalDateTime fechaInicio, String idEjemplar) {

    }


    //calcularFechaDevolucion(in fechaInicio:LocalDateTIme, in diasPrestamo:int): fechaDevolucion
    public void calcularFechaDevolucion(){
        this.fechaDevolucion = this.fechaDevolucion.plusDays(diasPrestamo);
    }

    //notificarProximoVencimiento(in medio:MediosContacto)
    public void notificarProximoVencimiento(){
       // System.out.println(socio.getMedioPreferido().toString() + ", el proximo vencimiento es: ",calcularFechaDevolucion());
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public int getDiasRetraso() {
        return diasRetraso;
    }

    public void setDiasRetraso(int diasRetraso) {
        this.diasRetraso = diasRetraso;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
