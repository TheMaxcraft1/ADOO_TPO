package Model;
import java.util.Random;

public class SistemaExternoUbicacion {
    public void generarUbicacion(Ubicacion ubicacion){
        Random random = new Random();

        // Generar coordenadas aleatorias de latitud en el rango de -90 a 90
        double latitud = random.nextDouble() * 180 - 90;
        // Generar coordenadas aleatorias de longitud en el rango de -180 a 180
        double longitud = random.nextDouble() * 360 - 180;

        ubicacion.setLatitud(latitud);
        ubicacion.setLongitud(longitud);
    }
}
