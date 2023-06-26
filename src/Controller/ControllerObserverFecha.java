package Controller;

import Model.Observer;
import Model.ObserverFechaActual;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ControllerObserverFecha {

    private static ControllerObserverFecha Controller = null;

    public ControllerObserverFecha() throws Exception {
    }
    public static synchronized ControllerObserverFecha getInstances() throws Exception {
        if(Controller == null) Controller = new ControllerObserverFecha();
        return Controller;
    }

    public void notificar() throws Exception {
        for (ObserverFechaActual observer: listaObservers){
            observer.actualizar();
        }
    }
    public void suscribirObserver(ObserverFechaActual observer){
        this.listaObservers.add(observer);
    }

    public void desuscribirObserver(ObserverFechaActual observer){
        this.listaObservers.remove(observer);
    }

    private List<ObserverFechaActual> listaObservers = new ArrayList<>();

    public void comenzarChequeoDiario(Integer tiempo) throws Exception {
        ControllerObserverFecha controller = ControllerObserverFecha.getInstances();
        ObserverFechaActual observerFechaActual = new ObserverFechaActual(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        controller.suscribirObserver(observerFechaActual);

        while (true){
            observerFechaActual.actualizar();
            Thread.sleep(tiempo); //24*60*60*1000 = 1 dia, tomar en cuenta para poner el valor que se quiera
        }
    }
}
