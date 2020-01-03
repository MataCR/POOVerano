package maintest;


import dao.ConexionSQL;
import dao.SalaDAO;
import java.sql.SQLException;
/**
 *
 * @author Andrés Pérez Bonilla
 */
public class MainTest {
  public static void main(String[] args) throws SQLException, ClassNotFoundException{
    ConexionSQL.getConexionSQL();
    SalaDAO x = new SalaDAO();
      System.out.println(x.cargarComboRecursos().toString());
    
  }  
}
