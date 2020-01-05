/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ReservaDAO;
import dao.SalaDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Estudiante;
import modelo.Reserva;
import modelo.Sala;
import vista.AgregarParticipantes;
import vista.CrearReserva;
import vista.Menu;

/**
 *
 * @author Mata
 */
public class ControladorReservas implements ActionListener{
  public ReservaDAO dao;
  public CrearReserva vista;  
  public Reserva modelo;

  public ControladorReservas(CrearReserva pVista) {
    this.vista = pVista;
    dao = new ReservaDAO();
    this.vista.btnBuscar.addActionListener(this);
    this.vista.btnReservar.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }

  
  public void actionPerformed(ActionEvent e) {    
      switch(e.getActionCommand()) {
          case "Buscar":
              llenarTabla();
              break;
          case "Reservar":
              registrarReserva();
              break;              
          case "Volver":
              cerrarVentanaAgregarSala();
              break;
          default:
              break;
      }
  }  
   
  public void cargarCombo(){
    try {
        ArrayList<String> recursos = dao.cargarComboRecursos();
        for (int i = 0; i < recursos.size(); i++) {
            String recurso = recursos.get(i);
            vista.comboRecursos.addItem(recurso);         
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
  }


  public void llenarTabla(){
    try {
        ArrayList<Sala> salas = dao.consultarSalasMasUtilizadas();
        DefaultTableModel tm=(DefaultTableModel)vista.tableSalas.getModel();
        tm.setRowCount(0);
        for (int i = 0; i < salas.size(); i++) {
           Object o[]= {salas.get(i).getIdSala(),salas.get(i).getUbicacion(),salas.get(i).getCapacidad()
           ,salas.get(i).getEstado()};
           tm.addRow(o);           
        }               
        } catch (Exception e) {
            System.out.println(e);
        }
  }  
  
  public void abrirReserva(){
     AgregarParticipantes x = new AgregarParticipantes(vista.txtIdAReservar.getText());
     x.setVisible(true);
  }

  public void cerrarVentanaAgregarSala() {
  Menu menuVista = new Menu();
  ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
  controladorMenu.vista.setVisible(true);
  this.vista.setVisible(false);
  controladorMenu.vista.setLocationRelativeTo(null); 
  }

  private void registrarReserva() {
    try {
        if (dao.validarUsuario() == 1) {
           Estudiante estudiante = new Estudiante(Integer.parseInt(vista.txtCarnet.getText()));
           String asunto = vista.txtAsunto.getText();
           Date fechaUso=Date.valueOf(vista.txtFecha.getText());  
           
           dao.agregarReserva(modelo);
        } } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
        }
  }
}
