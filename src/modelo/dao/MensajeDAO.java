/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Mensaje;


/**
 *
 * @author pablo
 */
public class MensajeDAO {
   Conexion con;
    public MensajeDAO() {
        con = new Conexion();
    }
    
    public ArrayList<Mensaje> getMensaje() throws SQLException{
        
        ArrayList<Mensaje> mensajeBD = new ArrayList();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM mensaje";
            
            
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int id_mensaje= Integer.parseInt(resultados.getString("id_mensaje"));
                String contenido = resultados.getString("contenido");
                int id_emisor= Integer.parseInt(resultados.getString("id_usr_emisor"));
                int id_receptor= Integer.parseInt(resultados.getString("id_usr_receptor"));
                
                
                mensajeBD.add(new Mensaje(id_mensaje,contenido,id_emisor,id_receptor));
            }
            accesoBD.close();
            return mensajeBD;
        }catch (Exception e){
            System.out.println("Error al obtener Mensaje");
             accesoBD.close();
            return null;
        }
    }
}
