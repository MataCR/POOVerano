package maintest;


import controlador.ControladorUsuario;
import vista.LogInForm;
import modelo.Usuario;



/**
 *
 * @author Andrés Pérez Bonilla
 */
public class MainTest {

  public static void main(String[] args) {
    LogInForm vista = new LogInForm();
    Usuario modelo = new Usuario();
    ControladorUsuario controladorUsuario = new ControladorUsuario(vista);
    controladorUsuario.vista.setVisible(true);
    controladorUsuario.vista.setLocationRelativeTo(null);
  }  
}