/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SalaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Sala;
import vista.AgregarSalaForm;


/**
 *
 * @author ayanc
 */
public class ControladorSala implements ActionListener{
  public AgregarSalaForm vista;
  public SalaDAO dao;
  public Sala modelo;
  
  
  public ControladorSala(AgregarSalaForm pVista, Sala pModelo){
    vista = pVista;
    modelo = pModelo;
    SalaDAO dao= new SalaDAO();
    this.vista.btnAgregarSala.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){    
    try{
      switch(e.getActionCommand()) {
        case "Agregar Sala":
          agregarSala();
          break;
        case "Volver":
          cerrarVentanaAgregarSalas();
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
  
  
  public void agregarSala() throws SQLException, ClassNotFoundException{
    if(vista.validarDatosCompletos() == false) {
      JOptionPane.showMessageDialog(vista, "Debe completar todos los campos mostrados");
    }
    if(vista.validarDatosEnteros()== false) {
      JOptionPane.showMessageDialog(vista, "El carnet y el télefono deben ser números enteros");
    }
    String ubicacion = vista.txtUbicacion.getText();
    String capacidadString = vista.txtCapacidad.getText();
    int capacidad = Integer.parseInt(capacidadString);
    String numeroString = vista.txtNumero.getText();
    int numero = Integer.parseInt(numeroString);
    modelo = new Sala(ubicacion,capacidad,numero);
    
    // VERIFICAR QUE NO SE INSERTE DOS VECES
    boolean estudianteActual = dao.agregarSala(modelo);
    if (estudianteActual){
      dao.agregarSala(modelo);
    }
    else{
      JOptionPane.showMessageDialog(vista, "Ha ocurrido un error de conexión");
    }
  }
  
  
  public void cerrarVentanaAgregarSalas() {
    vista.cancelarRegistroSala();
  }
}
