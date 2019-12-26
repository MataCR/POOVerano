/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Xtreme
 */
public class Incidente {
  

  private String detalle;
  private String tipo;

  
  public Incidente(String detalle, String tipo) {
    this.detalle = detalle;
    this.tipo = tipo;
  }

  
  public String getDetalle() {
    return detalle;
  }

  
  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  
  public String getTipo() {
    return tipo;
  }

  
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  
  
  
}
