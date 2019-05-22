package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.BandejaEntrada;
import javax.swing.JOptionPane;
import modelo.Mensaje;
import modelo.dao.MensajeDAO;
import modelo.dao.UsuarioDAO;
import vista.Login;
import vista.NuevoMensaje;
/**
 *
 * @author pablo
 */
public class MensajeController implements ActionListener{
    
    
    private Mensaje NewMensaje;

    public MensajeController(Mensaje NewMensaje) {
        this.NewMensaje = NewMensaje;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Mensaje")){
            
            try {
                String contenido = (String) NewMensaje.getMensaje();
                
                MensajeDAO mDAO = new MensajeDAO(); //No modificar
                
                ArrayList<Mensaje>mensajeBD = mDAO.getMensaje();
                boolean mensajeEnBD=false;
                int id=-1;
                for(int i = 0; i < mensajeBD.size(); i++) {
                    
                    if(mensajeBD.get(i).getMensaje().equals(contenido)){
                        mensajeEnBD=true;
                        id=mensajeBD.get(i).getId_mensaje();
                        break;
                        }
                    
                }
                
                if(mensajeEnBD){
                    
                    NuevoMensaje.setVisible(true);
                    
                }else{
                    JOptionPane.showMessageDialog(NewMensaje, "Error el usuariono existe en la BD", "ERROR", JOptionPane.ERROR);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }