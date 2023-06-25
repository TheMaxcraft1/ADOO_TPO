package Model;

public class AdaptadorTwilio {
    private TwilioSDK twilio;

    public void enviarWPP(Mensaje mensaje)
    {
        twilio.enviarWPP(mensaje);
    }

    public void enviarSMS(Mensaje mensaje)
    {
        twilio.enviarSMS(mensaje);
    }
}

