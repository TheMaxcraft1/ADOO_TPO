package Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {

    //getter y setter, constructor
    private LocalDateTime fechaInicio;
    private boolean devuelto = false;
    private LocalDateTime fechaDevolucion;
    private Ejemplar ejemplar;
    private List<ObserverPrestamoDevuelto> observadores;
    private Socio socioAsociado;

    public Prestamo() {
        this.fechaInicio = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        this.devuelto = false;
        this.observadores = new ArrayList<>();
        this.suscribirObserver(new ObserverPrestamoDevuelto()); //SUSCRIBIR
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

    public void notificar() throws Exception {
        for (Observer observer: observadores){
            observer.actualizar();
        }
    }

    public void setDevuelto(boolean devuelto) throws Exception {
        this.devuelto = devuelto;
        this.notificar();
        this.desuscribirObserver(observadores.get(observadores.size()-1)); //DESUSCRIBIR
    }

    public void suscribirObserver(ObserverPrestamoDevuelto observer){
        observer.setPrestamo(this);
        this.observadores.add(observer);
    }

    public void desuscribirObserver(ObserverPrestamoDevuelto observer){
        this.observadores.remove(observer);
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

    public List<ObserverPrestamoDevuelto> getObservadores() {
        return observadores;
    }

    public Socio getSocioAsociado() {
        return socioAsociado;
    }

    public void setSocioAsociado(Socio socioAsociado) {
        this.socioAsociado = socioAsociado;
    }

    public void mostrarPrestamo()
    {
        System.out.println();
        System.out.println("Fecha de inicio Prestamo: " + this.fechaInicio.toString());
        System.out.println("Fecha de devolución del ejemplar: " + this.fechaDevolucion.toString());
        System.out.print("¿El ejemplar ha sido devuelto? ");
        if(this.devuelto)
            System.out.println("SI");
        else
            System.out.println("NO");
        System.out.println("Ejemplar: ID: " + this.ejemplar.getIdEjemplar() + " Titulo: " + this.ejemplar.getTitulo());
        System.out.println("----------------------------------------------------------------------------");
        System.out.println();
    }
}
