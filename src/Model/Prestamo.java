package Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Prestamo {
    //getter y setter, constructor
    private LocalDateTime fechaInicio;
    private boolean devuelto;
    private int diasRetraso;
    private LocalDateTime fechaDevolucion;
    private int diasPrestamo;
    private Socio socio;


    //calcularFechaDevolucion(in fechaInicio:LocalDateTIme, in diasPrestamo:int): fechaDevolucion
    public void calcularFechaDevolucion(){
        this.fechaDevolucion = this.fechaDevolucion.plusDays(diasPrestamo);
    }

    //notificarProximoVencimiento(in medio:MediosContacto)
    public void notificarProximoVencimiento(){
       // System.out.println(socio.getMedioPreferido().toString() + ", el proximo vencimiento es: ",calcularFechaDevolucion());
    }

}
