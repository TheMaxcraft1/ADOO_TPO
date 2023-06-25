package Controller;
import Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerEjemplar {

    private List<Ejemplar> listaEjemplares = new ArrayList<>();

    private Map<tipoEjemplar, Integer> valoresDefecto = new HashMap<>();
    private static ControllerEjemplar CONTROLLEREJEMPLAR = null;

    public static synchronized ControllerEjemplar getInstances() throws Exception {
        if(CONTROLLEREJEMPLAR == null) CONTROLLEREJEMPLAR = new ControllerEjemplar();
        return CONTROLLEREJEMPLAR;
    }


    { //SE COLOCAN LOS VALORES POR DEFECTO DE LOS PRESTAMOS ORIGINALES
        valoresDefecto.put(tipoEjemplar.Libro, 10);
        valoresDefecto.put(tipoEjemplar.Revista, 5);
        valoresDefecto.put(tipoEjemplar.RevistaEspecializada, 5);
        valoresDefecto.put(tipoEjemplar.Diario, 5);
    }

    public void modificarParametrosPrestamos(tipoEjemplar categoria, Integer nuevoParametro){
        valoresDefecto.put(categoria, nuevoParametro); //BUSCAMOS LA CATEGORIA QUE SE BUSCA MODIFICAR Y CAMBIAMOS SU VALOR EN EL DICCIONARIO, PARA QUE CUANDO SE CREE UN NUEVO PRESTAMO, SE BUSQUE AQUI QUE CANTIDAD DE DIAS ESTA DISPONIBLE PARA PRESTAMO
        for (Ejemplar ejemplar: listaEjemplares){
            ejemplar.setDiasDisp(valoresDefecto.get(ejemplar.getCategoria()));
        }
    }

    public void altaEjemplar(String IDEjemplar, String titulo, String tema, String autor, String fechaPublicacion, tipoEjemplar categoria){

        Integer diasDisp = valoresDefecto.get(categoria);

        Ejemplar ejemplar = null;

        switch (categoria) {
            case Revista:
                ejemplar = new Revista(IDEjemplar, titulo, tema, autor, fechaPublicacion, categoria, diasDisp);
                break;
            case RevistaEspecializada:
                ejemplar = new RevistaEspecializada(IDEjemplar, titulo, tema, autor, fechaPublicacion, categoria, diasDisp);
                break;
            case Diario:
                ejemplar = new Diario(IDEjemplar, titulo, tema, autor, fechaPublicacion, categoria, diasDisp);
                break;
            case Libro:
                ejemplar = new Libro(IDEjemplar, titulo, tema, autor, fechaPublicacion, categoria, diasDisp);
                break;
            default:
                throw new IllegalArgumentException("Categoría de ejemplar inválida: " + categoria);
        }
        if (ejemplar != null)
            listaEjemplares.add(ejemplar);
    }


    public void modificarEstadoEjemplar(String IDEjemplar, boolean deBaja, boolean enPrestamo){
        for (Ejemplar ejemplar: listaEjemplares){ //POR CADA EJEMPLAR EN LA LISTA DE EJEMPLARES
            if (ejemplar.getIdEjemplar().equals(IDEjemplar)){ //SE BUSCA EL QUE TENGA EL MISMO ID (SERA UNO SOLO)
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
        for (Ejemplar ejemplar: resultados){
            ejemplar.getUbicacion();
        }
        return resultados;
    }

    public List<Ejemplar> buscarEjemplar() {
        List<Ejemplar> resultados = buscarEjemplar(null, null, null, null, null);
        /*for (Ejemplar ejemplar: resultados)
        {
            mostrarEjemplar(ejemplar);
        }

         */
        return resultados;
    }

    public List<Ejemplar> buscarEjemplar(String id) {
        List<Ejemplar> resultados = buscarEjemplar(id, null, null, null, null);
        /*for (Ejemplar ejemplar: resultados)
        {
            mostrarEjemplar(ejemplar);
        }

         */
        return resultados;
    }

    public List<Ejemplar> buscarEjemplar(String id, String titulo) {
        List<Ejemplar> resultados = buscarEjemplar(id, titulo, null, null, null);
        /*for (Ejemplar ejemplar: resultados)
        {
            mostrarEjemplar(ejemplar);
        }

         */
        return resultados;
    }

    public List<Ejemplar> buscarEjemplar(String id, String titulo, String autor) {
        List<Ejemplar> resultados = buscarEjemplar(id, titulo, autor, null, null);
        /*for (Ejemplar ejemplar: resultados)
        {
            mostrarEjemplar(ejemplar);
        }

         */
        return resultados;
    }

    public List<Ejemplar> buscarEjemplar(String id, String titulo, String autor, String fecha) {
        List<Ejemplar> resultados = buscarEjemplar(id, titulo, autor, fecha, null);
        /*for (Ejemplar ejemplar: resultados)
        {
            mostrarEjemplar(ejemplar);
        }

         */
        return resultados;
    }

    public void mostrarEjemplar(Ejemplar ejemplar){
        System.out.println("ID:" + ejemplar.getIdEjemplar());
        System.out.println("Titulo: " + ejemplar.getTitulo());
        System.out.println("Tema:" + ejemplar.getTema());
        System.out.println("Autor:" + ejemplar.getAutor());
        System.out.println("Fecha de publicacion:" + ejemplar.getFechaPublicacion());
        System.out.println("Categoria" + ejemplar.getCategoria());
        System.out.println("Ubicacion: Latitud: " + ejemplar.getUbicacion().getLatitud() + "| Longitud: " +ejemplar.getUbicacion().getLongitud());
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public Ejemplar buscarEjemplarParaPrestamo(String id){
        for (Ejemplar ejemplar: listaEjemplares){
            if (ejemplar.getIdEjemplar().equals(id))
                //mostrarEjemplar(ejemplar);
                return ejemplar;
        }
        System.out.println("No se ha encontrado el ejemplar buscado.");
        return null;
    }
    public List<Ejemplar> getListaEjemplares() {
        return listaEjemplares;
    }
}
