package dao;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Reserva;
import modelo.Sala;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class ReservaDAO {
  private static ResultSet resultadoConsulta;
  
  
  public ArrayList<Reserva> consultarReservasEstudiante(int carnet)throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec consultarOrganizadorReserva "+carnet+";");
    ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    while (resultadoConsulta.next()) {
      Reserva reservaEncontrada = new Reserva(resultadoConsulta.getInt(1),
        resultadoConsulta.getString(2), resultadoConsulta.getDate(3),
        resultadoConsulta.getDate(4), resultadoConsulta.getTime(5),
        resultadoConsulta.getTime(6), resultadoConsulta.getString(7), 
        resultadoConsulta.getString(8), resultadoConsulta.getBoolean(9));
      reservas.add(reservaEncontrada);
    }
    return reservas;
  }
  
  
 public boolean agregarReserva(Reserva reserva) throws SQLException,
      ClassNotFoundException {
    try {
      CallableStatement entrada = ConexionSQL.getConexionSQL().prepareCall("{call "
          + "registrarReserva (?,?,?,?,?,?)}");
      entrada.setString(1, reserva.getIdSala());
      entrada.setString(2, reserva.getAsunto());
      entrada.setDate(3, reserva.getFechaUso());
      entrada.setTime(4, reserva.getHoraInicio());
      entrada.setTime(5, reserva.getHoraFin());
      entrada.setInt(6, reserva.getOrganizador().getCarnet());
      entrada.execute();
    }
    catch(ClassNotFoundException | SQLException e) {
      return false;
    }
    return true;    
  }


  public int validarUsuario() throws SQLException,
          ClassNotFoundException{
      resultadoConsulta = ConexionSQL.createConsult("exec validarEstudiante;"); 
      int bandera = 0;
      while (resultadoConsulta.next()){
          bandera = resultadoConsulta.getInt(1);        
      }    
      return bandera;
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