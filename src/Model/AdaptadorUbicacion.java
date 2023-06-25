package Model;

public class AdaptadorUbicacion {
    private SistemaExternoUbicacion sistema;

    public Ubicacion averiguarUbicacion(){
        Ubicacion ubicacion = new Ubicacion();
        sistema.generarUbicacion(ubicacion);
        return ubicacion;
    }

    public AdaptadorUbicacion(SistemaExternoUbicacion sistema)
    {
        this.sistema = sistema;
    }

}

