package Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Prestamo {

    //getter y setter, constructor
    private LocalDateTime fechaInicio;
    private boolean devuelto = false;
    private int diasRetraso = 0;
    private LocalDateTime fechaDevolucion;
    private Ejemplar ejemplar;

    public Prestamo() {
        this.fechaInicio = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        this.diasRetraso = 0;
        this.devuelto = false;
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


    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public void mostrarPrestamo()
    {
        System.out.println("Fecha de inicio Prestamo: " + this.fechaInicio.toString());
        System.out.println("Fecha de devolución del ejemplar: " + this.fechaDevolucion.toString());
        System.out.print("¿El ejemplar ha sido devuelto? ");
        if(this.devuelto)
            System.out.println("SI");
        else
            System.out.println("NO");
        System.out.println("Dias de retraso en la devolución: " + this.diasRetraso);
        System.out.println("Ejemplar: " + this.ejemplar.getIdEjemplar() + " " + this.ejemplar.getTitulo());
        System.out.println("----------------------------------------------------------------------------");
        System.out.println();
    }
}
