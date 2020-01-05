/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SalaDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.CalificacionSalaForm;
import vista.Menu;

/**
 *
 * @author Mata
 */
public class ControladorCalificarSala implements ActionListener{
  public SalaDAO dao;
  public CalificacionSalaForm vista;  

  
public ControladorCalificarSala(CalificacionSalaForm pVista) {
    this.vista = pVista;
    dao = new SalaDAO();
    this.vista.btnCalificar.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }  


  public void actionPerformed(ActionEvent e) {    
    //try{
      switch(e.getActionCommand()) {
          case "Calificar Sala":
              calificarSala();
              break;          
          case "Volver":
              cerrarVentanaAgregarSala();
              break;
          default:
              break;
      }
   // }catch(Exception x){
     // JOptionPane.showMessageDialog(null, "Error con el ingreso de datos");
   //}
  }

  private void calificarSala() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
    
   
  public void cerrarVentanaAgregarSala() {
    Menu menuVista = new Menu();
    ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
    controladorMenu.vista.setVisible(true);
    this.vista.setVisible(false);
    controladorMenu.vista.setLocationRelativeTo(null); 
  }
}
