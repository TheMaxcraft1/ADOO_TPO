package Model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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








    //Getters y Setters
    public String getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getDiasDisp() {
        return diasDisp;
    }

    public void setDiasDisp(Integer diasDisp) {
        this.diasDisp = diasDisp;
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

    public void setCategoria(tipoEjemplar categoria) {
        this.categoria = categoria;
    }

    public Ejemplar(String idEjemplar, String titulo, String tema, String autor, String fechaPublicacion, boolean enPrestamo, boolean deBaja, tipoEjemplar categoria, Integer diasDisp) {
        this.idEjemplar = idEjemplar;
        this.titulo = titulo;
        this.tema = tema;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.enPrestamo = enPrestamo;
        this.deBaja = deBaja;
        this.categoria = categoria;
        this.diasDisp = diasDisp;
    }
}
