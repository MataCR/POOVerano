package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Xtreme
 */
public class Horario {


  private Date dia;
  private Time horaApertura;
  private Time horaCierre;

    
  public Horario(Date dia, Time horaApertura, Time horaCierre) {
    this.dia = dia;
    this.horaApertura = horaApertura;
    this.horaCierre = horaCierre;
  }

    
  public Date getDia() {
    return dia;
  }

  
  public void setDia(Date dia) {
    this.dia = dia;
  }

  
  public Time getHoraApertura() {
    return horaApertura;
  }

  
  public void setHoraApertura(Time horaApertura) {
    this.horaApertura = horaApertura;
  }

    
  public Time getHoraCierre() {
    return horaCierre;
  }

  
  public void setHoraCierre(Time horaCierre) {
    this.horaCierre = horaCierre;
  }
  
  
  
  
  
}
