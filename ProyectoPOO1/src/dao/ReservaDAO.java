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
          resultadoConsulta.getDate4), resultadoConsulta.getTime(5),
          resultadoConsulta.getTime(6), resultadoConsulta.getString(7); 
          resultadoConsulta.getString(8); resultadoConsulta.getString(9));
      reservas.add(reservaEncontrada);
    }
    return reservas;
  }

  
    this.id = pId;
    this.asunto = pAsunto;
    this.fechaSolicitud = pFechaSolicitud;
    this.fechaUso = pFechaUso;
    this.horaInicio = pHoraInicio;
    this.horaFin = pHoraFin;
    this.idSala = pIdSala;
    this.estado = pEstado;
    this.isExitosa = pIsExitosa;
  
  
  
  
}