package Controller;
import Model.Diario;
import Model.Ejemplar;
import Model.Revista;
import Model.tipoEjemplar;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerEjemplar {

    private List<Ejemplar> listaEjemplares;

    private Map<tipoEjemplar, Integer> valoresDefecto = new HashMap<>();

    {
        valoresDefecto.put(tipoEjemplar.Libro, 10);
        valoresDefecto.put(tipoEjemplar.Revista, 5);
        valoresDefecto.put(tipoEjemplar.RevistaEspecializada, 5);
        valoresDefecto.put(tipoEjemplar.Diario, 5);
    }

    public void modificarParametrosPrestamos(tipoEjemplar categoria, Integer nuevoParametro){
        valoresDefecto.put(categoria, nuevoParametro);
    }

    public void altaEjemplar(String IDEjemplar, String titulo, String tema, String autor, String fechaPublicacion, tipoEjemplar categoria){
        Integer diasDisp = valoresDefecto.getOrDefault(categoria, 0);
        if (categoria == tipoEjemplar.Revista)
            Revista nuevoEjemplar = new Revista(IDEjemplar, titulo, tema, autor, fechaPublicacion,false, false, categoria, diasDisp);

        //NO SE POR QUE PASA ESTO
    }


    public void modificarEstadoEjemplar(String IDEjemplar, boolean deBaja, boolean enPrestamo){

    }

    public String buscarEjemplar(String titulo == null, String autor, LocalDateTime fecha, tipoEjemplar categoria){
        String ejemplar = "";

        //HAY QUE VER COMO SE PONEN LAS COSAS POR DEFECTO


        return ejemplar;
    }
}
