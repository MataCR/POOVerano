package controlador;


import com.sun.javafx.scene.control.skin.VirtualFlow;
import dao.GraficosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import vista.AgregarEstudianteForm;
import vista.Reporte;
/**
 *
 * @author Mata
 */
public class ControladorGraficos {
  GraficosDAO dao;
  public Reporte vista;

  public ControladorGraficos(Reporte pVista){
    vista = pVista;
    dao= new GraficosDAO();
  }
  
  public void graficar(){
    if (this.vista.comboGrafico.getSelectedIndex() == 0) {
       graficarTopSalasUtilizadas();  
    }
   
    
    if (this.vista.comboGrafico.getSelectedIndex() == 1) {
       graficarTopHorarios();  
    }  
    
    
    if (this.vista.comboGrafico.getSelectedIndex() == 2) {
       graficarTopCarreras();  
    } 


    if (this.vista.comboGrafico.getSelectedIndex() == 3) {
       graficarTopSalasCalificacion();  
    }    
  }
  public void graficarTopSalasUtilizadas(){
    try {
        ArrayList<String> salas = dao.consultarSalasMasUtilizadas();  
        ArrayList<Integer> cantidades = dao.consultarSalasMasUtilizadasCantidades(); 
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(cantidades.get(0), salas.get(0), "Salas");
        dataSet.addValue(cantidades.get(1), salas.get(1), "Salas");
        dataSet.addValue(cantidades.get(2), salas.get(2), "Salas");
        dataSet.addValue(cantidades.get(3), salas.get(3), "Salas");
        dataSet.addValue(cantidades.get(4), salas.get(4), "Salas");
        JFreeChart grafica = ChartFactory.createBarChart("Salas mas utilizadas", " x", "Salas", dataSet, PlotOrientation.HORIZONTAL, true, true, false);
        ChartPanel contenedor = new ChartPanel(grafica);
        JFrame ventana = new JFrame("graficas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }      
  }

    private void graficarTopHorarios() {
    try {
        ArrayList<String> horario = dao.consultarTopHorarios();  
        ArrayList<Integer> cantidades = dao.consultarSalasMasUtilizadasCantidades(); 
        DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue(horario.get(0), cantidades.get(0));
        dataSet.setValue(horario.get(1), cantidades.get(1));
        dataSet.setValue(horario.get(2), cantidades.get(2));
        dataSet.setValue(horario.get(3), cantidades.get(3));
        dataSet.setValue(horario.get(4), cantidades.get(4));
        JFreeChart grafica = ChartFactory.createPieChart("Horarios mas utilizados", dataSet, true, true, Locale.ITALY);
        ChartPanel contenedor = new ChartPanel(grafica);
        JFrame ventana = new JFrame("graficas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void graficarTopCarreras() {
    try {
        ArrayList<String> carrera = dao.consultarTopCarreras();  
        ArrayList<Integer> cantidades = dao.consultarTopCarrerasCantidades(); 
        DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue(carrera.get(0), cantidades.get(0));
        dataSet.setValue(carrera.get(1), cantidades.get(1));
        dataSet.setValue(carrera.get(2), cantidades.get(2));
        dataSet.setValue(carrera.get(3), cantidades.get(3));
        dataSet.setValue(carrera.get(4), cantidades.get(4));
        JFreeChart grafica = ChartFactory.createPieChart("Carreras con mas reservas", dataSet, true, true, Locale.ITALY);
        ChartPanel contenedor = new ChartPanel(grafica);
        JFrame ventana = new JFrame("Carreras");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void graficarTopSalasCalificacion() {
    try {
        ArrayList<String> salas = dao.consultarSalasPuntuacion();  
        ArrayList<Integer> cantidades = dao.consultarSalasPuntuacionCantidades(); 
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(cantidades.get(0), salas.get(0), "Salas");
        dataSet.addValue(cantidades.get(1), salas.get(1), "Salas");
        dataSet.addValue(cantidades.get(2), salas.get(2), "Salas");
        dataSet.addValue(cantidades.get(3), salas.get(3), "Salas");
        dataSet.addValue(cantidades.get(4), salas.get(4), "Salas");
        JFreeChart grafica = ChartFactory.createBarChart("Salas mas utilizadas", " x", "Salas", dataSet, PlotOrientation.HORIZONTAL, true, true, false);
        ChartPanel contenedor = new ChartPanel(grafica);
        JFrame ventana = new JFrame("graficas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}
