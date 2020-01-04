/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionListener;
import dao.SalaDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.SeleccionModificar;
import vista.Menu;
import modelo.Sala;

/**
 *
 * @author luisg
 */
public class ControladorModificacionSala implements ActionListener{
    public SeleccionModificar vista;
    public SalaDAO dao;
    public Sala modelo;
    
    public ControladorModificacionSala (SeleccionModificar pVista){
        vista = pVista;
        dao = new SalaDAO();
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent e){
        try{
            switch(e.getActionCommand()){
                case "Modificar Sala":
                    modificarSala();
                    break;
                case "Volver":
                    cerrarVentanaSeleccionModificar();
                    break;
                default:
                    break;
            }
        }
      catch (SQLException | ClassNotFoundException ex) {
          Logger.getLogger(ControladorSala.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
    
    public void modificarSala() throws SQLException, ClassNotFoundException{
        
    }
  public void cargarCombo(){
    try {
        ArrayList<String> recursos = dao.cargarComboRecursos();
        for (int i = 0; i < recursos.size(); i++) {
            String recurso = recursos.get(i);
            vista.cbxRecursos.addItem(recurso);         
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
  }
    
  public void cerrarVentanaSeleccionModificar() {
    Menu menuVista = new Menu();
    ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
    controladorMenu.vista.setVisible(true);
    this.vista.setVisible(false);
    controladorMenu.vista.setLocationRelativeTo(null); 
  }
}
