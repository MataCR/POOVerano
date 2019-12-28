package controlador;


import dao.EstudianteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.*;
import modelo.Estudiante;
import vista.AgregarEstudiante;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class ControladorEstudiante implements ActionListener {
  public AgregarEstudiante vista;
  public EstudianteDAO dao;
  public Estudiante modelo;
  
  
  public ControladorEstudiante(AgregarEstudiante pVista, Estudiante pModelo){
    vista = pVista;
    modelo = pModelo;
    EstudianteDAO dao= new EstudianteDAO();
    this.vista.btRegistrarEstudiante.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e) {    
    switch(e.getActionCommand()) {
      case "Iniciar logIn":
      //  logIn();
        break;
      
      case "Cancelar logIn":
        //cerrarVentanaLogin();
        break;
      
      default:
        break;
    }
  }
  
  
  public void agregarEstudiante(){
        
  }

  /*
    public void logIn() {
        if (vista.logInDatosCorrectos() == true) {
            String nombreUsuario = vista.txtNombreUsuario.getText();
            String contraseña = vista.txtContrasena.getText();
            modelo = new Usuario(nombreUsuario, contraseña);
            Usuario usuarioActual = dao.iniciarSesion(modelo);
            if (usuarioActual != null) {            
                vista.setVisible(false);

                // Dependiendo del tipo de usuario se puede abrir una                          

                //  vista diferente
               JOptionPane.showMessageDialog(vista, "Bienvenido: " +
                modelo.getNombre());
                vista.setVisible(true);
            }
            else {
               JOptionPane.showMessageDialog(vista, "El usuario indicado no existe");
        }
        else {
            JOptionPane.showMessageDialog(vista, "Todos lo datos son requeridos");
        }

    }

*/
  
}
