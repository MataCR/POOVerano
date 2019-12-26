package modelo;

/**
 *
 * @author Xtreme
 */
public class Estudiante {

    
  private int carnet;
  private String nombre; 
  private String apellido; 
  private String correo; 
  private String carrera; 
  private int calificacion; 
  private int telefono; 
  
  
  public Estudiante(int carnet, String nombre, String apellido, String correo, String carrera, int telefono) {
    this.carnet = carnet;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.carrera = carrera;
    this.telefono = telefono;
  }

  
  public int getCarnet() {
    return carnet;
  }

  
  public void setCarnet(int carnet) {
    this.carnet = carnet;
  }

  
  public String getNombre() {
    return nombre;
  }

  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  
  public String getApellido() {
    return apellido;
  }

  
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  
  public String getCorreo() {
    return correo;
  }

  
  public void setCorreo(String correo) {
    this.correo = correo;
  }

  
  public String getCarrera() {
    return carrera;
  }

  
  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  
  public int getCalificacion() {
    return calificacion;
  }

  
  public void setCalificacion(int calificacion) {
    this.calificacion = calificacion;
  }

  
  public int getTelefono() {
    return telefono;
  }

  
  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }
  
 
}
