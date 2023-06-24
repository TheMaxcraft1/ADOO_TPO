package Model;
import java.util.Random;

public class SistemaExternoUbicacion {
    public String generarUbicacion(){
        Random random = new Random();

        // Generar coordenadas aleatorias de latitud en el rango de -90 a 90
        double latitud = random.nextDouble() * 180 - 90;
        // Generar coordenadas aleatorias de longitud en el rango de -180 a 180
        double longitud = random.nextDouble() * 360 - 180;

        //Paso a String los valores y los concateno para que se pueda printear por consola
        String posicion = "Latitud: " + String.valueOf(latitud) + "\n" + "Longitud: " + String.valueOf(longitud);

        //Retorno la variable
        return posicion;
    }
}
