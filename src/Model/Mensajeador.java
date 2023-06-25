package Model;

public class Mensajeador {
    private EstrategiaMensaje medio;

    public void setMedioMensaje(EstrategiaMensaje medio)
    {
        this.medio = medio;
    }

    public void enviarMensaje(Mensaje mensaje)
    {
        medio.enviarNotificacion(mensaje);
    }

    public EstrategiaMensaje getMedio()
    {
        return medio;
    }
}


