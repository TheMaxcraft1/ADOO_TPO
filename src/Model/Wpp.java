package Model;

public class Wpp extends EstrategiaMensaje{
    private AdaptadorTwilio adaptadorTwilio;

    public Wpp (AdaptadorTwilio adaptadorTwilio)
    {
        this.adaptadorTwilio = adaptadorTwilio;
    }
    @Override
    public void enviarNotificacion(Mensaje mensaje) {
        adaptadorTwilio.enviarWPP(mensaje);
    }
    public AdaptadorTwilio getAdaptadorTwilio() {
        return adaptadorTwilio;
    }
    public void setAdaptadorTwilio(AdaptadorTwilio adaptadorTwilio) {
        this.adaptadorTwilio = adaptadorTwilio;
    }
}
