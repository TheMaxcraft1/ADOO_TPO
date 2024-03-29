package Model;

public class TwilioSDK {
    //Cosas de Twilio, por ejemplo NUMERO DE CELULAR, TOKEN, ETC
    private String numero;

    public TwilioSDK(String numero)
    {
        this.numero = numero;
    }

    public void enviarWPP(Mensaje mensaje)
    {
        System.out.println();
        System.out.println("Enviando WhatsApp al número: " + this.numero);
        System.out.println("TEMA: " + mensaje.getMotivo() + "\n" + "CUERPO: "+ mensaje.getCuerpo());
        System.out.println("WhatsApp enviado correctamente");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");
    }

    public void enviarSMS(Mensaje mensaje)
    {
        System.out.println();
        System.out.println("Enviando SMS al número: " + this.numero);
        System.out.println("TEMA: " + mensaje.getMotivo() + "\n" + "CUERPO: "+ mensaje.getCuerpo());
        System.out.println("SMS enviado correctamente");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");
    }
}
