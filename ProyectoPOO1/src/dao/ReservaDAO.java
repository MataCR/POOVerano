package dao;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Reserva;


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
}