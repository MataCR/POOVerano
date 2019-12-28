package modelo;

/**
 *
 * @author Xtreme
 */
public class Estudiante {   
  private String nombre; 
  private String primerApellido; 
  private String segundoApellido; 
  private String correo;
  private int carnet;
  private int calificacion; 
  private int idCarrera; 
  private int telefono; 
  
  
  public Estudiante(int pCarnet, String pNombre, String pPrimerApellido, String pSegundoApellido, 
        String pCorreo, int pIdCarrera, int pTelefono) {
    this.carnet = pCarnet;
    this.nombre = pNombre;
    this.primerApellido = pPrimerApellido;
    this.segundoApellido = pSegundoApellido;
    this.correo = pCorreo;
    this.calificacion = 100;
    this.idCarrera = pIdCarrera;
    this.telefono = pTelefono;
  }

  
  public int getCarnet() {
    return this.carnet;
  }

  
  public void setCarnet(int pCarnet) {
    this.carnet = pCarnet;
  }

  
  public String getNombre() {
    return this.nombre;
  }

  
  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  
  public String getPrimerApellido() {
    return this.primerApellido;
  }

  
  public void setPrimerApellido(String pPrimerApellido) {
    this.primerApellido = pPrimerApellido;
  }
  
  
  public String getSegundoApellido() {
    return this.segundoApellido;
  }

  
  public void setSegundoApellido(String pSegundoApellido) {
    this.primerApellido = pSegundoApellido;
  }

  
  public String getCorreo() {
    return this.correo;
  }

  
  public void setCorreo(String pCorreo) {
    this.correo = pCorreo;
  }

  
  public int getIdCarrera() {
    return this.idCarrera;
  }

  
  public void setCarrera(int pIdCarrera) {
    this.idCarrera = pIdCarrera;
  }

  
  public int getCalificacion() {
    return this.calificacion;
  }

  
  public void setCalificacion(int pCalificacion) {
    this.calificacion = pCalificacion;
  }

  
  public int getTelefono() {
    return this.telefono;
  }

  
  public void setTelefono(int pTelefono) {
    this.telefono = pTelefono;
  }
}
