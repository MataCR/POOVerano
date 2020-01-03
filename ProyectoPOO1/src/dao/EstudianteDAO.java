package dao;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Estudiante;
import modelo.Reserva;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class EstudianteDAO {
  private static ResultSet resultadoConsulta;
  
  public boolean agregarOrganizador(Estudiante organizador) throws SQLException,
      ClassNotFoundException {
    try {
      CallableStatement entrada = ConexionSQL.getConexionSQL().prepareCall("{call agregarOrganizador (?,?,?,?,?,?,?,?)}");
      entrada.setInt(1, organizador.getCarnet());
      entrada.setString(2, organizador.getNombre());
      entrada.setString(3, organizador.getPrimerApellido());
      entrada.setString(4, organizador.getSegundoApellido());
      entrada.setString(5, organizador.getCorreo());
      entrada.setInt(6, organizador.getCalificacion());
      entrada.setInt(7, organizador.getTelefono());
      entrada.setInt(8, organizador.getIdCarrera());
      entrada.execute();
    }
    catch(ClassNotFoundException | SQLException e) {
      return false;
    }
    return true;    
  }
  
  
  public ArrayList<String> cargarListaCarreras() throws SQLException, ClassNotFoundException{
    resultadoConsulta =  ConexionSQL.createConsult("exec consultarCarreras;");
    ArrayList<String> carreras = new ArrayList<String>();
    while (resultadoConsulta.next()) {
      String carreraEncontrada = resultadoConsulta.getString(1);
      carreras.add(carreraEncontrada);
    }
    return carreras;
  }
  
  
  /*
  public ArrayList<Estudiante> consultarEstudiantes(int carnet)throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec consultarOrganizadorIncidente "
        +carnet+";");
    ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    while (resultadoConsulta.next()) {
       
      Estudiante estudianteEncontrado = new Estudiante(resultadoConsulta.getInt(1),
          resultadoConsulta.getString(2), resultadoConsulta.getString(3),
          resultadoConsulta.getString(4), resultadoConsulta.getString(5),
          resultadoConsulta.getString(6), resultadoConsulta.getInt(7));
      estudiantes.add(estudianteEncontrado);
    }
    return estudiantes;
  }
  
   
  private ArrayList<Reserva> consultarReservasEstudiante(int carnet)throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec consultarOrganizadorReserva "+carnet+";");
    ArrayList<Reserva> reservasEstudiante = new ArrayList<Reserva>();
    while (resultadoConsulta.next()) {
      Estudiante estudianteEncontrado 
              = new Estudiante(resultadoConsulta.getInt(1),
          resultadoConsulta.getString(2), resultadoConsulta.getString(3),
          resultadoConsulta.getString(4), resultadoConsulta.getString(5),
          resultadoConsulta.getString(6), resultadoConsulta.getInt(7));
      estudiantes.add(estudianteEncontrado);
    }
    return estudiantes;
  }
*/
}
