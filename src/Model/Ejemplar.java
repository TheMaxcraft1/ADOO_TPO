package Model;
public abstract class Ejemplar {
    private String idEjemplar;
    private String titulo;
    private String tema;
    private String autor;
    private String fechaPublicacion;
    private boolean enPrestamo;
    private boolean deBaja;
    private tipoEjemplar categoria;
    private Integer diasDisp;
    private Ubicacion ubicacion;


    //Getters y Setters
    public String getIdEjemplar() {
        return idEjemplar;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getTema() {
        return tema;
    }

    public String getAutor() {
        return autor;
    }


    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public boolean isEnPrestamo() {
        return enPrestamo;
    }

    public void setEnPrestamo(boolean enPrestamo) {
        this.enPrestamo = enPrestamo;
    }

    public boolean isDeBaja() {
        return deBaja;
    }

    public void setDeBaja(boolean deBaja) {
        this.deBaja = deBaja;
    }

    public tipoEjemplar getCategoria() {
        return categoria;
    }

    public Integer getDiasDisp() {
        return diasDisp;
    }

    public void setDiasDisp(Integer diasDisp) {
        this.diasDisp = diasDisp;
    }

    public Ubicacion getUbicacion() {
        ubicacion.setUbicacion(); //Actualizamos ubicacion
        return ubicacion;
    }

    public Ejemplar(String idEjemplar, String titulo, String tema, String autor, String fechaPublicacion, tipoEjemplar categoria, Integer diasDisp) {
        this.idEjemplar = idEjemplar;
        this.titulo = titulo;
        this.tema = tema;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.enPrestamo = false;
        this.deBaja = false;
        this.categoria = categoria;
        this.diasDisp = diasDisp;
        this.ubicacion = new Ubicacion(new AdaptadorUbicacion(new SistemaExternoUbicacion()));
    }
}
