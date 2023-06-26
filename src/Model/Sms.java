package Model;

public class Sms extends EstrategiaMensaje{
    private AdaptadorTwilio adaptadorTwilio;


    public Sms(AdaptadorTwilio adaptadorTwilio)
    {
        this.adaptadorTwilio = adaptadorTwilio;
    }
    @Override
    public void enviarNotificacion(Mensaje mensaje) {
        adaptadorTwilio.enviarSMS(mensaje);

    }
    public AdaptadorTwilio getAdaptadorTwilio() {
        return adaptadorTwilio;
    }
    public void setAdaptadorTwilio(AdaptadorTwilio adaptadorTwilio) {
        this.adaptadorTwilio = adaptadorTwilio;
    }
}
