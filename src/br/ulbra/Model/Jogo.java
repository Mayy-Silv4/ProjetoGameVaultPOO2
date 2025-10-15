
package br.ulbra.Model;


public class Jogo {
    private int id;
    public String titulo;
    public String genero;
    public String plataforma;
    private double nota;
    private String comentario;

    public Jogo() {
    }

    public Jogo(int id, String titulo, String genero, String plataforma, double nota, String comentario) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Jogo(int aInt, String string, String string0, String string1, double aDouble, String string2, Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public Jogo(int aInt, String string, String string0, String string1, double aDouble, String string2, Usuario u) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public int getId(int id) {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Jogo{" + "id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", plataforma=" + plataforma + ", nota=" + nota + ", comentario=" + comentario + '}';
    }

    public Object getUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
