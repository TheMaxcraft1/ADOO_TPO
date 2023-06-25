package Model;

public class AdaptadorAngus {
    private AngusMail angus;

    public AdaptadorAngus(AngusMail angus)
    {
        this.angus = angus;
    }

    public void enviarMensaje(Mensaje mensaje)
    {
        angus.enviarMensaje(mensaje);
    }

    public AngusMail getAngus() {
        return angus;
    }

    public void setAngus(AngusMail angus) {
        this.angus = angus;
    }
}
