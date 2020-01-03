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
  
  /*
  public ArrayList<Reserva> consultarReservas(int carnet)throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec consultarOrganizadorReserva "+carnet+";");
    ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    while (resultadoConsulta.next()) {
      Reserva reservaEncontrada = new Reserva(resultadoConsulta.getInt(1),
          resultadoConsulta.getString(2), resultadoConsulta.getString(3),
          resultadoConsulta.getString(4), resultadoConsulta.getString(5),
          resultadoConsulta.getString(6), resultadoConsulta.getInt(7));
      estudiantes.add(estudianteEncontrado);
    }
    return estudiantes;
  }
*/
}