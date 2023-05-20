package Model;

import java.time.LocalDateTime;

public class Prestamo {
    private String clienteAsociado;
    private LocalDateTime fechaInicio;
    private boolean devuelto;
    private int diasRetraso;
    private LocalDateTime fechaDevolucion;
}
