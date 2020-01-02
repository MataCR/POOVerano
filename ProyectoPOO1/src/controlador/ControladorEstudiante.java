package controlador;


import dao.EstudianteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import vista.AgregarEstudianteForm;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class ControladorEstudiante implements ActionListener {
  public AgregarEstudianteForm vista;
  public EstudianteDAO dao;
  public Estudiante modelo;
  
  
  public ControladorEstudiante(AgregarEstudianteForm pVista, Estudiante pModelo){
    vista = pVista;
    modelo = pModelo;
    EstudianteDAO dao= new EstudianteDAO();
    this.vista.btRegistrarEstudiante.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){    
    try{
      switch(e.getActionCommand()) {
        case "Registrar":
          agregarEstudiante();
          break;
        case "Volver":
          cerrarVentanaRegistroEstudiantes();
          break;
        default:
          break;
      }
    }
    catch (SQLException ex) {
      Logger.getLogger(ControladorEstudiante.class.getName()).log(Level.SEVERE, null, ex);
    } 
    catch (ClassNotFoundException ex) {
      Logger.getLogger(ControladorEstudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  
  public void agregarEstudiante() throws SQLException, ClassNotFoundException{
    if(vista.validarDatosCorreo() == false) {
      JOptionPane.showMessageDialog(vista, "Debe ingresar una dirección de correo");
    } 
    if(vista.validarDatosCompletos() == false) {
      JOptionPane.showMessageDialog(vista, "Debe completar todos los campos mostrados");
    }
    if(vista.validarDatosEnteros()== false) {
      JOptionPane.showMessageDialog(vista, "El carnet y el télefono deben ser números enteros");
    }
    String carnetString = vista.txtCarnet.getText();
    int carnet = Integer.parseInt(carnetString);
    String correo = vista.txtCorreo.getText();
    String nombre = vista.txtNombre.getText();
    String telefonoString = vista.txtTelefono.getText();
    int telefono = Integer.parseInt(telefonoString);
    String primerApellido = vista.txtPrimerApellido.getText();
    String segundoApellido = vista.txtSegundoApellido.getText();
    int idCarrera = vista.cbCarrera.getSelectedIndex() + 1;
    modelo = new Estudiante(carnet, nombre, primerApellido, segundoApellido, correo, idCarrera, 
        telefono);
    
    // VERIFICAR QUE NO SE INSERTE DOS VECES
    boolean estudianteActual = dao.agregarOrganizador(modelo);
    if (estudianteActual){
      dao.agregarOrganizador(modelo);
    }
    else{
      JOptionPane.showMessageDialog(vista, "Ha ocurrido un error de conexión");
    }
  }
  
  
  public void cerrarVentanaRegistroEstudiantes() {
    vista.cancelarRegistroEstudiante();
  }
}
