package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class Conexion {
    
    Connection con=null;
    String user="root";
    String pass="";
    String server="jdbc:mysql://localhost:3306/"; 
    String db="prueba1lp2"; 
    String driver="com.mysql.jdbc.Driver"; 
    

    public Conexion() {
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(server+db, user, pass);
            //JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa");
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public Connection getConexion(){
        return con;   
    }

    public Connection cerrarConexion(){
        
        try {
            con.close();
             System.out.println("Cerrando conexion a "+server+db+" . . . . . Ok");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        con=null;
        return con;

    }

}
    

