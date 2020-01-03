/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
