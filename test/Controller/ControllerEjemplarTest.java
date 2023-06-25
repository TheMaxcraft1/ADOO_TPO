package Controller;

import Model.Ejemplar;
import Model.RevistaEspecializada;
import Model.Revista;
import Model.Libro;
import Model.tipoEjemplar;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ControllerEjemplarTest {

    @Test
    void modificarParametrosPrestamosTest() throws Exception {

        Map<tipoEjemplar, Integer> valoresDefectoTestOriginal = new HashMap<>();

        { //SE COLOCAN LOS VALORES POR DEFECTO DE LOS PRESTAMOS ORIGINALES
            valoresDefectoTestOriginal.put(tipoEjemplar.Libro, 10);
            valoresDefectoTestOriginal.put(tipoEjemplar.Revista, 5);
            valoresDefectoTestOriginal.put(tipoEjemplar.RevistaEspecializada, 5);
            valoresDefectoTestOriginal.put(tipoEjemplar.Diario, 5);
        }

        ControllerEjemplar ce = ControllerEjemplar.getInstances();
        ce.altaEjemplar("1", "Libro 1", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro);
        ce.altaEjemplar("2", "Libro 2", "Chemistry", "Alfred", "20/09/2020", tipoEjemplar.Libro);
        ce.altaEjemplar("3", "RevistaE 1", "Math", "Richard", "14/06/2002", tipoEjemplar.RevistaEspecializada);
        ce.altaEjemplar("4", "RevistaE 2", "English", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada);
        ce.altaEjemplar("5", "Revista 1", "Algebra", "Richard", "14/06/2002", tipoEjemplar.Revista);
        ce.altaEjemplar("6", "Revista 2", "Science", "Alfred", "20/09/2020", tipoEjemplar.Revista);
        ce.altaEjemplar("7", "Diario 1", "Computers", "Richard", "14/06/2002", tipoEjemplar.Diario);
        ce.altaEjemplar("8", "Diario 2", "French", "Alfred", "20/09/2020", tipoEjemplar.Diario);

        List<Ejemplar> listaEjemplares = ce.getListaEjemplares();

        for (Ejemplar ejemplar: listaEjemplares){
            System.out.println("ID: " + ejemplar.getIdEjemplar());
            System.out.println("Categoria: " + ejemplar.getCategoria());
            System.out.println("Dias Disponible para prestamo por defecto: " + ejemplar.getDiasDisp());
            System.out.println("------------------------------------------------------------------------");
        }

        assertEquals(ce.getListaEjemplares().get(0).getDiasDisp(), valoresDefectoTestOriginal.get(ce.getListaEjemplares().get(0).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(1).getDiasDisp(), valoresDefectoTestOriginal.get(ce.getListaEjemplares().get(1).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(2).getDiasDisp(), valoresDefectoTestOriginal.get(ce.getListaEjemplares().get(2).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(3).getDiasDisp(), valoresDefectoTestOriginal.get(ce.getListaEjemplares().get(3).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(4).getDiasDisp(), valoresDefectoTestOriginal.get(ce.getListaEjemplares().get(4).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(5).getDiasDisp(), valoresDefectoTestOriginal.get(ce.getListaEjemplares().get(5).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(6).getDiasDisp(), valoresDefectoTestOriginal.get(ce.getListaEjemplares().get(6).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(7).getDiasDisp(), valoresDefectoTestOriginal.get(ce.getListaEjemplares().get(7).getCategoria()));

        ce.modificarParametrosPrestamos(tipoEjemplar.Libro, 25);
        ce.modificarParametrosPrestamos(tipoEjemplar.RevistaEspecializada, 20);
        ce.modificarParametrosPrestamos(tipoEjemplar.Revista, 7);
        ce.modificarParametrosPrestamos(tipoEjemplar.Diario, 3);

        for (Ejemplar ejemplar: listaEjemplares){
            System.out.println("ID: " + ejemplar.getIdEjemplar());
            System.out.println("Categoria: " + ejemplar.getCategoria());
            System.out.println("Dias Disponible para prestamo por defecto: " + ejemplar.getDiasDisp());
            System.out.println("------------------------------------------------------------------------");
        }

        Map<tipoEjemplar, Integer> valoresDefectoTestModificado = new HashMap<>();
        { //SE COLOCAN LOS VALORES POR DEFECTO DE LOS PRESTAMOS ORIGINALES
            valoresDefectoTestModificado.put(tipoEjemplar.Libro, 25);
            valoresDefectoTestModificado.put(tipoEjemplar.Revista, 7);
            valoresDefectoTestModificado.put(tipoEjemplar.RevistaEspecializada, 20);
            valoresDefectoTestModificado.put(tipoEjemplar.Diario, 3);
        }

        assertEquals(ce.getListaEjemplares().get(0).getDiasDisp(), valoresDefectoTestModificado.get(ce.getListaEjemplares().get(0).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(1).getDiasDisp(), valoresDefectoTestModificado.get(ce.getListaEjemplares().get(1).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(2).getDiasDisp(), valoresDefectoTestModificado.get(ce.getListaEjemplares().get(2).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(3).getDiasDisp(), valoresDefectoTestModificado.get(ce.getListaEjemplares().get(3).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(4).getDiasDisp(), valoresDefectoTestModificado.get(ce.getListaEjemplares().get(4).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(5).getDiasDisp(), valoresDefectoTestModificado.get(ce.getListaEjemplares().get(5).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(6).getDiasDisp(), valoresDefectoTestModificado.get(ce.getListaEjemplares().get(6).getCategoria()));
        assertEquals(ce.getListaEjemplares().get(7).getDiasDisp(), valoresDefectoTestModificado.get(ce.getListaEjemplares().get(7).getCategoria()));

    }

    @Test
    void buscarEjemplarPorID() throws Exception {

        ControllerEjemplar ce = ControllerEjemplar.getInstances();

        ce.altaEjemplar("1", "Libro 1", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro);
        ce.altaEjemplar("2", "Libro 2", "Chemistry", "Alfred", "20/09/2020", tipoEjemplar.Libro);
        ce.altaEjemplar("3", "RevistaE 1", "Math", "Richard", "14/06/2002", tipoEjemplar.RevistaEspecializada);
        ce.altaEjemplar("4", "RevistaE 2", "English", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada);
        ce.altaEjemplar("5", "Revista 1", "Algebra", "Richard", "14/06/2002", tipoEjemplar.Revista);
        ce.altaEjemplar("6", "Revista 2", "Science", "Alfred", "20/09/2020", tipoEjemplar.Revista);
        ce.altaEjemplar("7", "Diario 1", "Computers", "Richard", "14/06/2002", tipoEjemplar.Diario);
        ce.altaEjemplar("8", "Diario 2", "French", "Alfred", "20/09/2020", tipoEjemplar.Diario);

        Ejemplar ejemplarTest = new Revista("5", "Revista 1", "Algebra", "Richard", "14/06/2002", tipoEjemplar.Revista, 5);

        assertEquals(ejemplarTest.getIdEjemplar(), ce.buscarEjemplar("5").get(0).getIdEjemplar());
        assertEquals(ejemplarTest.getTema(), ce.buscarEjemplar("5").get(0).getTema());
        assertEquals(ejemplarTest.getTitulo(), ce.buscarEjemplar("5").get(0).getTitulo());
        assertEquals(ejemplarTest.getAutor(), ce.buscarEjemplar("5").get(0).getAutor());
        assertEquals(ejemplarTest.getFechaPublicacion(), ce.buscarEjemplar("5").get(0).getFechaPublicacion());
        assertEquals(ejemplarTest.getCategoria(), ce.buscarEjemplar("5").get(0).getCategoria());

    }
    @Test
    void buscarEjemplarPorTituloYCategoria() throws Exception {

        ControllerEjemplar ce = ControllerEjemplar.getInstances();

        ce.altaEjemplar("1", "Libro 1", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro);
        ce.altaEjemplar("2", "Libro 2", "Chemistry", "Alfred", "20/09/2020", tipoEjemplar.Libro);
        ce.altaEjemplar("3", "RevistaE 1", "Math", "Richard", "14/06/2002", tipoEjemplar.RevistaEspecializada);
        ce.altaEjemplar("4", "RevistaE 2", "English", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada);
        ce.altaEjemplar("5", "Revista 1", "Algebra", "Richard", "14/06/2002", tipoEjemplar.Revista);
        ce.altaEjemplar("6", "Revista 2", "Science", "Alfred", "20/09/2020", tipoEjemplar.Revista);
        ce.altaEjemplar("7", "Diario 1", "Computers", "Richard", "14/06/2002", tipoEjemplar.Diario);
        ce.altaEjemplar("8", "Diario 2", "French", "Alfred", "20/09/2020", tipoEjemplar.Diario);

        Ejemplar ejemplarTest = new Libro("2", "Libro 2", "Chemistry", "Alfred", "20/09/2020", tipoEjemplar.Libro, 10);

        assertEquals(ejemplarTest.getIdEjemplar(), ce.buscarEjemplar(null, "Libro 2", null, null, tipoEjemplar.Libro).get(0).getIdEjemplar());
        assertEquals(ejemplarTest.getTema(), ce.buscarEjemplar(null, "Libro 2", null, null, tipoEjemplar.Libro).get(0).getTema());
        assertEquals(ejemplarTest.getTitulo(), ce.buscarEjemplar(null, "Libro 2", null, null, tipoEjemplar.Libro).get(0).getTitulo());
        assertEquals(ejemplarTest.getAutor(), ce.buscarEjemplar(null, "Libro 2", null, null, tipoEjemplar.Libro).get(0).getAutor());
        assertEquals(ejemplarTest.getFechaPublicacion(), ce.buscarEjemplar(null, "Libro 2", null, null, tipoEjemplar.Libro).get(0).getFechaPublicacion());
        assertEquals(ejemplarTest.getCategoria(), ce.buscarEjemplar(null, "Libro 2", null, null, tipoEjemplar.Libro).get(0).getCategoria());

    }
    @Test
    void buscarEjemplarPorTodo() throws Exception {

        ControllerEjemplar ce = ControllerEjemplar.getInstances();

        ce.altaEjemplar("1", "Libro 1", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro);
        ce.altaEjemplar("2", "Libro 2", "Chemistry", "Alfred", "20/09/2020", tipoEjemplar.Libro);
        ce.altaEjemplar("3", "RevistaE 1", "Math", "Richard", "14/06/2002", tipoEjemplar.RevistaEspecializada);
        ce.altaEjemplar("4", "RevistaE 2", "English", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada);
        ce.altaEjemplar("5", "Revista 1", "Algebra", "Richard", "14/06/2002", tipoEjemplar.Revista);
        ce.altaEjemplar("6", "Revista 2", "Science", "Alfred", "20/09/2020", tipoEjemplar.Revista);
        ce.altaEjemplar("7", "Diario 1", "Computers", "Richard", "14/06/2002", tipoEjemplar.Diario);
        ce.altaEjemplar("8", "Diario 2", "French", "Alfred", "20/09/2020", tipoEjemplar.Diario);

        ce.buscarEjemplar("4");

        Ejemplar ejemplarTest = new RevistaEspecializada("4", "RevistaE 2", "English", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada, 5);

        ce.mostrarEjemplar(ce.buscarEjemplar("4").get(0));

        assertEquals(ejemplarTest.getIdEjemplar(), ce.buscarEjemplar("4", "RevistaE 2", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada).get(0).getIdEjemplar());
        assertEquals(ejemplarTest.getTema(), ce.buscarEjemplar("4", "RevistaE 2", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada).get(0).getTema());
        assertEquals(ejemplarTest.getTitulo(), ce.buscarEjemplar("4", "RevistaE 2", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada).get(0).getTitulo());
        assertEquals(ejemplarTest.getAutor(), ce.buscarEjemplar("4", "RevistaE 2", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada).get(0).getAutor());
        assertEquals(ejemplarTest.getFechaPublicacion(), ce.buscarEjemplar("4", "RevistaE 2", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada).get(0).getFechaPublicacion());
        assertEquals(ejemplarTest.getCategoria(), ce.buscarEjemplar("4", "RevistaE 2", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada).get(0).getCategoria());
    }

    @Test
    void buscarEjemplar() throws Exception{ //Test para mostrar la lista de todos los ejemplares
        ControllerEjemplar ce = ControllerEjemplar.getInstances();

        ce.altaEjemplar("1", "Libro 1", "Physics", "Richard", "14/06/2002", tipoEjemplar.Libro);
        ce.altaEjemplar("2", "Libro 2", "Chemistry", "Alfred", "20/09/2020", tipoEjemplar.Libro);
        ce.altaEjemplar("3", "RevistaE 1", "Math", "Richard", "14/06/2002", tipoEjemplar.RevistaEspecializada);
        ce.altaEjemplar("4", "RevistaE 2", "English", "Alfred", "20/09/2020", tipoEjemplar.RevistaEspecializada);
        ce.altaEjemplar("5", "Revista 1", "Algebra", "Richard", "14/06/2002", tipoEjemplar.Revista);
        ce.altaEjemplar("6", "Revista 2", "Science", "Alfred", "20/09/2020", tipoEjemplar.Revista);
        ce.altaEjemplar("7", "Diario 1", "Computers", "Richard", "14/06/2002", tipoEjemplar.Diario);
        ce.altaEjemplar("8", "Diario 2", "French", "Alfred", "20/09/2020", tipoEjemplar.Diario);

        ce.buscarEjemplar();

    }
}