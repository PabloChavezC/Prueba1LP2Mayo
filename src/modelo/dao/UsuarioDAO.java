package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author pablo
 */
public class UsuarioDAO {
    
    Conexion con;
    public UsuarioDAO() {
        con = new Conexion();
    }
    
    public ArrayList<Usuario> getUsuarios() throws SQLException{
        
        ArrayList<Usuario> usuariosBD = new ArrayList();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM usuario";
            
            
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int id= Integer.parseInt(resultados.getString("id_usuario"));
                String nombre = resultados.getString("nombre");
                
                
                usuariosBD.add(new Usuario(id,nombre));
            }
            accesoBD.close();
            return usuariosBD;
        }catch (Exception e){
            System.out.println("Error al obtener Usuario");
             accesoBD.close();
            return null;
        }
    }
}
