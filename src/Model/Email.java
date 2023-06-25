package Model;

public class Email extends EstrategiaMensaje{
    private AdaptadorAngus adaptadorAngus;

    @Override
    public void enviarNotificacion(Mensaje mensaje) {
        adaptadorAngus.enviarMensaje(mensaje);

    }

    public Email(AdaptadorAngus adaptadorAngus)
    {
        this.adaptadorAngus = adaptadorAngus;
    }

    public AdaptadorAngus getAdaptadorAngus()
    {
        return this.adaptadorAngus;
    }

    public void setAdaptadorAngus(AdaptadorAngus adaptadorAngus)
    {
        this.adaptadorAngus = adaptadorAngus;
    }
}
