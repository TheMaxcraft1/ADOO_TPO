package Model;

public class AdaptadorUbicacion {
    private SistemaExternoUbicacion sistema;

    public Ubicacion averiguarUbicacion(){
        Ubicacion ubicacion = new Ubicacion();
        sistema.generarUbicacion(ubicacion);
        return ubicacion;
    }

}

