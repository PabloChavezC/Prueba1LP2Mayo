/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Marcelo Esperguel
 */
public class Mensaje {
    
    private int id_mensaje;
    private Usuario emisor;
    private Usuario receptor;
    private String contenido;

    public Mensaje(int id_mensaje, Usuario emisor, Usuario receptor, String contenido) {
        this.id_mensaje = id_mensaje;
        this.emisor = emisor;
        this.receptor = receptor;
        this.contenido = contenido;
    }

    public Mensaje() {
    }

    public Mensaje(int id_mensaje, String contenido, int id_emisor, int id_receptor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }


    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Object getMensaje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
