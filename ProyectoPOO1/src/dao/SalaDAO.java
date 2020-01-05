/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import modelo.Horario;
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
  
  public ArrayList<Horario> consultarHorariosDisponibles() throws SQLException,
          ClassNotFoundException{
      resultadoConsulta = ConexionSQL.createConsult("exec tablaHorarios;");
      ArrayList<Horario> horarios = new ArrayList<Horario>();
      while (resultadoConsulta.next()){
          int idHorario = resultadoConsulta.getInt(1);
          String dia = resultadoConsulta.getString(2);
          Time horaApertura = resultadoConsulta.getTime(3);
          Time horaCierre = resultadoConsulta.getTime(4);
          
          Horario horario = new Horario (idHorario,dia,horaApertura,horaCierre);
          horarios.add(horario);
      }
      return horarios;
  }
  
  public ArrayList<String> cargarComboHorarios() throws SQLException, ClassNotFoundException{
    resultadoConsulta =  ConexionSQL.createConsult("exec consultarHorarios;");
    ArrayList<String> horarios = new ArrayList<String>();
    while (resultadoConsulta.next()) {
      String horarioEncontrado = resultadoConsulta.getString(1);
      horarios.add(horarioEncontrado);
    }
    return horarios;
  }
  
  public Sala verificarSala(Sala sala) throws SQLException, ClassNotFoundException{
      ArrayList <String> salas= cargarSalas();
      int cantidad = salas.size();   
      for (int i = 0; i<cantidad; i++){
        if(sala.equals(salas.get(i))){
            return sala;
        }
  }
      return null;
  }
  
  public ArrayList<String> cargarSalas() throws SQLException, ClassNotFoundException{
      resultadoConsulta = ConexionSQL.createConsult("exec cargarSalas;");
      ArrayList <String> salas = new ArrayList<String>();
      while (resultadoConsulta.next()){
          String salaEncontrada = resultadoConsulta.getString(1);
          salas.add(salaEncontrada);
      }
      return salas;
  }
  
  public boolean agregarHorario(Sala sala, Horario horario) throws SQLException, ClassNotFoundException{
      try{
        CallableStatement entry = ConexionSQL.getConexionSQL().prepareCall("{call agregarHorarioSala"
          + "(?,?)}");
        entry.setInt(1, horario.getIdHorario());
        entry.setString(2, sala.getIdSala()); 
        entry.execute();
    }
    catch(ClassNotFoundException | SQLException e) {
      return false;
    }
    return true;    
  }
}

