package Model;

public class AngusMail {
    //DIRECCIÓN EMAIL, TOKEN, ETC

    private String email;

    public void enviarMensaje(Mensaje mensaje)
    {
        System.out.println("Enviando Email a la direccion: " + this.email);
        System.out.println("Mensaje enviado correctamente");
    }
}
