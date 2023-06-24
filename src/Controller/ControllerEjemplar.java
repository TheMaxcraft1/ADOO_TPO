package Controller;
import Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerEjemplar {

    private List<Ejemplar> listaEjemplares = new ArrayList<>();

    private Map<tipoEjemplar, Integer> valoresDefecto = new HashMap<>();

    { //SE COLOCAN LOS VALORES POR DEFECTO DE LOS PRESTAMOS ORIGINALES
        valoresDefecto.put(tipoEjemplar.Libro, 10);
        valoresDefecto.put(tipoEjemplar.Revista, 5);
        valoresDefecto.put(tipoEjemplar.RevistaEspecializada, 5);
        valoresDefecto.put(tipoEjemplar.Diario, 5);
    }

    public void modificarParametrosPrestamos(tipoEjemplar categoria, Integer nuevoParametro){
        valoresDefecto.put(categoria, nuevoParametro); //BUSCAMOS LA CATEGORIA QUE SE BUSCA MODIFICAR Y CAMBIAMOS SU VALOR EN EL DICCIONARIO, PARA QUE CUANDO SE CREE UN NUEVO PRESTAMO, SE BUSQUE AQUI QUE CANTIDAD DE DIAS ESTA DISPONIBLE PARA PRESTAMO
    }

    public void altaEjemplar(String IDEjemplar, String titulo, String tema, String autor, String fechaPublicacion, tipoEjemplar categoria){
        Integer diasDisp = 0;
        Ejemplar ejemplar = null;
        switch (categoria) {
            case Revista:
                diasDisp = valoresDefecto.getOrDefault(categoria, 0);
                ejemplar = new Revista(IDEjemplar, titulo, tema, autor, fechaPublicacion, false, false, categoria);
                break;
            case RevistaEspecializada:
                ejemplar = new RevistaEspecializada(IDEjemplar, titulo, tema, autor, fechaPublicacion, false, false, categoria);
                break;
            case Diario:
                ejemplar = new Diario(IDEjemplar, titulo, tema, autor, fechaPublicacion, false, false, categoria);
                break;
            case Libro:
                ejemplar = new Libro(IDEjemplar, titulo, tema, autor, fechaPublicacion, false, false, categoria);
                break;
            default:
                throw new IllegalArgumentException("Categoría de ejemplar inválida: " + categoria);
        }
        listaEjemplares.add(ejemplar);
    }


    public void modificarEstadoEjemplar(String IDEjemplar, boolean deBaja, boolean enPrestamo){
        for (Ejemplar ejemplar: listaEjemplares){ //POR CADA EJEMPLAR EN LA LISTA DE EJEMPLARES
            if (ejemplar.getIdEjemplar() == IDEjemplar){ //SE BUSCA EL QUE TENGA EL MISMO ID (SERA UNO SOLO)
                ejemplar.setDeBaja(deBaja); //COLOCAMOS SI ESTA DE BAJA O NO
                ejemplar.setEnPrestamo(enPrestamo); //COLOCAMOS SI ESTA EN PRESTAMO O NO
            }
        }
    }

    public List<Ejemplar> buscarEjemplar(String id, String titulo, String autor, String fecha, tipoEjemplar categoria){
        List<Ejemplar> resultados = new ArrayList<>();
        for (Ejemplar ejemplar : listaEjemplares) { //POR CADA EJEMPLAR EN LA LISTA DE EJEMPLARES
            if  ((id == null || ejemplar.getIdEjemplar().equals(id)) && (titulo == null || ejemplar.getTitulo().equals(titulo)) && //SE VERIFICA QUE EL VALOR BUSCADO O VALGA NULL, ES DECIR QUE NO SE PASO COMO PARAMETRO, O SEA IGUAL AL PARAMETRO QUE SE PASA.
                    (autor == null || ejemplar.getAutor().equals(autor)) && (fecha == null || ejemplar.getFechaPublicacion().equals(fecha)) && (categoria == null || ejemplar.getCategoria().equals(categoria))) {
                resultados.add(ejemplar); //SE AGREGA EL EJEMPLAR A LA LISTA DE RESULTADOS
            }
        }
        return resultados; //SE DEVUELVE LA LISTA DE RESULTADOS
    }
}
