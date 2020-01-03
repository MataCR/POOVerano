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
public class Sala {

  private int numero;
  private String idSala;
  private String ubicacion;
  private int capacidad;
  private String estado;
  private int califacion;

  public Sala(String ubicacion, int capacidad, int numero) {
    this.ubicacion = ubicacion;
    this.capacidad = capacidad;
    this.numero = numero;
  }

  
  public Sala(String idSala, String ubicacion, int capacidad, String estado) {
    this.idSala = idSala;
    this.ubicacion = ubicacion;
    this.capacidad = capacidad;
    this.estado = estado;
  }

  
  public String getIdSala() {
    return idSala;
  }

  
  public void setIdSala(String idSala) {
    this.idSala = idSala;
  }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
  public String getUbicacion() {
    return ubicacion;
  }

  
  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  
  public int getCapacidad() {
    return capacidad;
  }

  
  public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
  }

  
  public String getEstado() {
    return estado;
  }

  
  public void setEstado(String estado) {
    this.estado = estado;
  }

  
  public int getCalifacion() {
    return califacion;
  }

  
  public void setCalifacion(int califacion) {
    this.califacion = califacion;
  }
  
  
  
}
