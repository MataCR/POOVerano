package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Xtreme
 */
public class Reserva {


  private String estado;
  private Date fechaCreacion;
  private Date fechaReserva;
  private Time horaInicio;
  private Time horFin;

  
  public Reserva(String estado, Date fechaCreacion, Date fechaReserva, Time horaInicio, Time horFin) {
    this.estado = estado;
    this.fechaCreacion = fechaCreacion;
    this.fechaReserva = fechaReserva;
    this.horaInicio = horaInicio;
    this.horFin = horFin;
  }

  
  public String getEstado() {
    return estado;
  }

  
  public void setEstado(String estado) {
    this.estado = estado;
  }

  
  public Date getFechaCreacion() {
    return fechaCreacion;
  }

  
  public void setFechaCreacion(Date fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  
  public Date getFechaReserva() {
    return fechaReserva;
  }

  
  public void setFechaReserva(Date fechaReserva) {
    this.fechaReserva = fechaReserva;
  }

  
  public Time getHoraInicio() {
    return horaInicio;
  }

  
  public void setHoraInicio(Time horaInicio) {
    this.horaInicio = horaInicio;
  }

  
  public Time getHorFin() {
    return horFin;
  }

  
  public void setHorFin(Time horFin) {
    this.horFin = horFin;
  }
  
  
  
}
