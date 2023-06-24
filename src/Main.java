public class Main {
    public static void main(String[] args) throws Exception {
        ControllerSocio cs = ControllerSocio.getInstances();
        cs.altaSocio("1", "Nico", "Lomfain", "mail1", "tel1", MediosContacto.SMS);
        Ejemplar libro1 = new Ejemplar("1", "titulo1", "cac", "Max Fain", "14/06/2002",
                tipoEjemplar.Libro, 4) {
        };
        cs.generarPrestamo("1", libro1);

        System.out.println(cs.getListaSocios().get(0).getHistorialPrestamo().get(0).isDevuelto());

    }
}