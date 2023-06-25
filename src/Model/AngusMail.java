package Model;

public class AngusMail {
    //DIRECCIÓN EMAIL, TOKEN, ETC

    private String email;

    public AngusMail(String email)
    {
        this.email = email;
    }

    public void enviarMensaje(Mensaje mensaje)
    {
        System.out.println();
        System.out.println("Enviando Email a la direccion: " + this.email);
        System.out.println("ASUNTO: " + mensaje.getMotivo() + "\n" + "CUERPO: "+ mensaje.getCuerpo());
        System.out.println("E-mail enviado correctamente");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
