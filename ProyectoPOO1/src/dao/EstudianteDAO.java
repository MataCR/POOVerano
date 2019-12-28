package dao;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Estudiante;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class EstudianteDAO {
  private static ResultSet resultadoConsulta;
  
  private boolean agregarOrganizador(Estudiante organizador) throws SQLException,
      ClassNotFoundException {
    try {
      CallableStatement entry = ConexionSQL.getConexionSQL().prepareCall("{call agregarOrganizador"
          + "(?,?,?,?,?,?,?,?)}");
      entry.setInt(1, organizador.getCarnet());
      entry.setString(2, organizador.getNombre());
      entry.setString(3, organizador.getPrimerApellido());
      entry.setString(4, organizador.getSegundoApellido());
      entry.setString(5, organizador.getCorreo());
      entry.setInt(6, organizador.getCalificacion());
      entry.setInt(7, organizador.getTelefono());
      entry.setInt(8, organizador.getIdCarrera());
      entry.execute();
    }
    catch(ClassNotFoundException | SQLException e) {
      return false;
    }
    return true;    
  } 
}
