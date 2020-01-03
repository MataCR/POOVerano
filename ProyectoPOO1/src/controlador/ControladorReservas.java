/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SalaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Sala;
import vista.CrearReserva;
import vista.Reserva;

/**
 *
 * @author Mata
 */
public class ControladorReservas {
  public SalaDAO dao;
  public Reserva vista;  

  public ControladorReservas(Reserva pVista) {
    this.vista = pVista;
    dao = new SalaDAO();
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
     CrearReserva x = new CrearReserva(vista.txtIdAReservar.getText());
     x.setVisible(true);
  }
}
