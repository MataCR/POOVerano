package gestionador;


import controlador.ControladorAgregarEstudiante;
import controlador.ControladorConsultaEstudiantes;
import controlador.ControladorSala;
import controlador.ControladorVerificacionSala;
import dao.EstudianteDAO;
import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Estudiante;
import modelo.Usuario;
import vista.AgregarEstudianteForm;
import vista.AgregarSalaForm;
import vista.ConsultarEstudiantesForm;
import vista.Menu;
import vista.ModificarSala;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class ControladorGestionador implements ActionListener {
  public Menu vista;
  public EstudianteDAO dao;
  public Estudiante modelo;
  
  
  public ControladorGestionador(Menu pVista){
    vista = pVista;
    this.vista.btAgregarEstudiante.addActionListener(this);
    this.vista.btAgregarSala.addActionListener(this);
    this.vista.btAnalisisDatos.addActionListener(this);
    this.vista.btConsultarEstudiante.addActionListener(this);
    this.vista.btConsultarSala.addActionListener(this);
    this.vista.btCrearReserva.addActionListener(this);
    this.vista.btModificarDatosSala.addActionListener(this);
    this.vista.btReservasEstudiante.addActionListener(this);
    this.vista.btCerrarSesion.addActionListener(this);
    this.vista.btCalificarSala.addActionListener(this);
  }
    
    
    @Override
  public void actionPerformed(ActionEvent e){    
      switch(e.getActionCommand()) {
          case "Agregar Estudiante":
              AgregarEstudianteForm estudianteVista = new AgregarEstudianteForm();
              ControladorAgregarEstudiante controladorEstudiante = new 
                  ControladorAgregarEstudiante(estudianteVista);
              controladorEstudiante.vista.setVisible(true);
              vista.setVisible(false);
              controladorEstudiante.vista.setLocationRelativeTo(null);
              controladorEstudiante.cargarCarreras();
              break;
          case "Consultar Estudiante":
              ConsultarEstudiantesForm estudiantesConsultadosVista = new
                  ConsultarEstudiantesForm();
              ControladorConsultaEstudiantes controladorEstudiantesConsultados = new 
                  ControladorConsultaEstudiantes(estudiantesConsultadosVista);   
              controladorEstudiantesConsultados.vista.setVisible(true);
              vista.setVisible(false);
              controladorEstudiantesConsultados.vista.setLocationRelativeTo(null);
              break;
          case "Agregar Sala":
              AgregarSalaForm salaVista = new AgregarSalaForm();
              ControladorSala controladorSala = new 
              ControladorSala(salaVista);
              controladorSala.vista.setVisible(true);
              vista.setVisible(false);
              controladorSala.vista.setLocationRelativeTo(null);
              controladorSala.cargarHorarios();
              break;
          case "Modificar Datos de Salas":
              ModificarSala modificarVista = new ModificarSala();
              ControladorVerificacionSala controladorModificar = new 
              ControladorVerificacionSala(modificarVista);
              controladorModificar.vista.setVisible(true);
              vista.setVisible(false);
              controladorModificar.vista.setLocationRelativeTo(null);
              //controladorModificar.cargarCombo();
              break;
          default:
              break;
      }
  }
}