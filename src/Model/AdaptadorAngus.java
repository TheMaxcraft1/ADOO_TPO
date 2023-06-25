package Model;

public class AdaptadorAngus {
    private AngusMail angus;


    public void enviarMensaje(Mensaje mensaje)
    {
        angus.enviarMensaje(mensaje);
    }
}
