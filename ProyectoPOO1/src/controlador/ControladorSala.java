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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Horario;
import modelo.Sala;
import vista.AgregarSalaForm;
import vista.Menu;


/**
 *
 * @author ayanc
 */
public class ControladorSala implements ActionListener{
  public AgregarSalaForm vista;
  public SalaDAO dao;
  public Sala modelo;
  
  
  public ControladorSala(AgregarSalaForm pVista){
    vista = pVista;
    dao= new SalaDAO();
    this.vista.btnAgregarSala.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
    this.vista.btnCargarHorarios.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){    
    try{
      switch(e.getActionCommand()) {
        case "Agregar Sala":
          agregarSala();
          break;
        case "Volver":
          cerrarVentanaAgregarSala();
          break;
        case "Cargar Horarios":
          llenarTablaHorarios();
        default:
          break;
      }
    }
    catch (SQLException ex) {
      Logger.getLogger(ControladorSala.class.getName()).log(Level.SEVERE, null, ex);
    } 
    catch (ClassNotFoundException ex) {
      Logger.getLogger(ControladorSala.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  
  public void agregarSala() throws SQLException, ClassNotFoundException{
    if(vista.validarDatosCompletos() == false) {
      JOptionPane.showMessageDialog(vista, "Debe completar todos los campos mostrados");
    }
//    if(vista.validarDatosEnteros()== false) {
//      JOptionPane.showMessageDialog(vista, "El numero de sala y la capacidad deben ser números enteros");
//    }
    String ubicacion = vista.txtUbicacion.getText();
    String capacidadString = vista.txtCapacidad.getText();
    int capacidad = Integer.parseInt(capacidadString);
    String numeroString = vista.txtNumero.getText();
    int numero = Integer.parseInt(numeroString);
    
    modelo = new Sala(ubicacion,capacidad,numero);
    boolean salaActual = dao.agregarSala(modelo);
    if (salaActual){
      JOptionPane.showMessageDialog(vista, "La sala ha sido ingresada correctamente");
    }
    else{
      JOptionPane.showMessageDialog(vista, "Ha ocurrido un error de conexión");
    }
  }
  
  public void cargarHorarios(){
    try {
      ArrayList<String> recursos = dao.cargarComboHorarios();
      for (int i = 0; i < recursos.size(); i++) {
        String recurso = recursos.get(i);
        vista.cbxHorario.addItem(recurso);         
      }    
    } 
    catch (Exception e) {
      System.out.println(e);
    }
  }
  
    public void llenarTablaHorarios(){
    try {
        ArrayList<Horario> horarios = dao.consultarHorariosDisponibles();
        DefaultTableModel tm=(DefaultTableModel)vista.horariosTable.getModel();
        tm.setRowCount(0);
        for (int i = 0; i < horarios.size(); i++) {
           Object o[]= {horarios.get(i).getIdHorario(),horarios.get(i).getDia(),horarios.get(i).getHoraApertura()
           ,horarios.get(i).getHoraCierre()};
           tm.addRow(o);           
        }               
        } catch (Exception e) {
            System.out.println(e);
        }
  }
  
  
 public void cerrarVentanaAgregarSala() {
  Menu menuVista = new Menu();
  ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
  controladorMenu.vista.setVisible(true);
  this.vista.setVisible(false);
  controladorMenu.vista.setLocationRelativeTo(null); 
  }
}
