/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Sala;

/**
 *
 * @author luisg
 */
public class SalaDAO {
  private static ResultSet resultadoConsulta;
  
  public boolean agregarSala(Sala sala) throws SQLException,
      ClassNotFoundException {
    try {
      CallableStatement entry = ConexionSQL.getConexionSQL().prepareCall("{call agregarSala"
          + "(?,?,?)}");
      entry.setString(1, sala.getUbicacion());
      entry.setInt(2, sala.getCapacidad()); 
      entry.setInt(3, sala.getNumero());
      entry.execute();
    }
    catch(ClassNotFoundException | SQLException e) {
      return false;
    }
    return true;    
  }
  
  
  public ArrayList<Sala> consultarSalasMasUtilizadas()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec salasDisp "+";");
    ArrayList<Sala> salas = new ArrayList<Sala>();
    while (resultadoConsulta.next()) {
       
      String idSala = resultadoConsulta.getString(1);
      String ubicacion = resultadoConsulta.getString(2);
      int capacidad = resultadoConsulta.getInt(3);
      String estado = resultadoConsulta.getString(4);
      Sala sala = new Sala(idSala, ubicacion, capacidad, estado);
      salas.add(sala);
    }
    return salas;
  }
  
  
  public ArrayList<String> cargarComboRecursos()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec recursos "+";");
    ArrayList<String> recursos = new ArrayList<String>();
    while (resultadoConsulta.next()) {
       
      String recurso = resultadoConsulta.getString(2);
      recursos.add(recurso);
    }
    return recursos;
  }
}
