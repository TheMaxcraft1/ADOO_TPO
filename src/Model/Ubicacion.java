package Model;

public class Ubicacion {
    private double latitud;
    private double longitud;
    private AdaptadorUbicacion adapter;

    public Ubicacion(AdaptadorUbicacion adapter)
    {
        this.adapter = adapter;
    }
    public Ubicacion(){}
    public double getLatitud() {
        return latitud;
    }
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    public double getLongitud() {
        return longitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    public void setUbicacion() {
        Ubicacion ubicacionauxiliar = adapter.averiguarUbicacion();
        this.setLongitud(ubicacionauxiliar.longitud);
        this.setLatitud(ubicacionauxiliar.latitud);
    }

}
