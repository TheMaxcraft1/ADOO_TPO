package Model;

public class Mensajeador {
    private EstrategiaMensaje medio;
    private Mensaje mensaje;


    public void setMedioMensaje(EstrategiaMensaje medio)
    {
        this.medio = medio;
    }

    public void enviarMensaje()
    {
        medio.enviarNotificacion(this.mensaje);
    }
}


