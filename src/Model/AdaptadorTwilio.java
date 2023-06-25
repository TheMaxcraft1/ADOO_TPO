package Model;

public class AdaptadorTwilio {
    private TwilioSDK twilio;

    public AdaptadorTwilio(TwilioSDK twilio)
    {
        this.twilio = twilio;
    }

    public void enviarWPP(Mensaje mensaje)
    {
        twilio.enviarWPP(mensaje);
    }

    public void enviarSMS(Mensaje mensaje)
    {
        twilio.enviarSMS(mensaje);
    }

    public TwilioSDK getTwilio() {
        return twilio;
    }

    public void setTwilio(TwilioSDK twilio) {
        this.twilio = twilio;
    }
}

