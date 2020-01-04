package vista;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class AgregarEstudianteForm extends javax.swing.JFrame {
 // ControladorAgregarEstudianteForm controlador ;
    
  public AgregarEstudianteForm() {
//    controlador = new ControladorAgregarEstudianteForm(this);
    initComponents();
 //   controlador.cargarCarreras();
  }

  
  public boolean validarDatosCompletos(){
    String carnet = txtCarnet.getText();
    String correo = txtCorreo.getText();
    String nombre = txtNombre.getText();
    String telefono = txtTelefono.getText();
    String primerApellido = txtPrimerApellido.getText();
    String carrera = (String) cbCarrera.getSelectedItem();
    String segundoApellido = txtSegundoApellido.getText();
    if (carnet.length()==0 || correo.length()==0 || nombre.length()==0 || telefono.length()==0
        || primerApellido.length()==0 || segundoApellido.length()==0 || carrera.length()==0){
      return false;
    }
    return true;
  }
  
/*
  public boolean validarDatosEnteros(){
    String carnet = txtCarnet.getText();
    String telefono = txtTelefono.getText();
    try {
      int carnetEntero = Integer.parseInt(carnet);
      int telefonoEntero = Integer.parseInt(telefono);
    }
    catch(NumberFormatException e) {
      return false;
    }
    return true;
  }
  */
  
  public boolean validarDatosCorreo(){
    String correo = txtSegundoApellido.getText(); 
    if (correo.contains("@")){
      return true;
    }
    return false;
  }
  
  
  public void cancelarRegistroEstudiante(){
    Menu cancelacionRegistro= new Menu();
    cancelacionRegistro.setVisible(true);
    this.setVisible(false);
    this.dispose();
  }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        lbTitulo = new javax.swing.JLabel();
        btRegistrarEstudiante = new javax.swing.JButton();
        lbCarnet = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbPrimerApellido = new javax.swing.JLabel();
        lbSegundoApellido = new javax.swing.JLabel();
        lbCorreo = new javax.swing.JLabel();
        lbTelefono = new javax.swing.JLabel();
        cbCarrera = new javax.swing.JComboBox<>();
        txtCarnet = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPrimerApellido = new javax.swing.JTextField();
        txtSegundoApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lbCarrera = new javax.swing.JLabel();
        btVolver = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTitulo.setText("Agregar Estudiante");

        btRegistrarEstudiante.setText("Registrar");
        btRegistrarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarEstudianteActionPerformed(evt);
            }
        });

        lbCarnet.setText("Carnet");

        lbNombre.setText("Nombre");

        lbPrimerApellido.setText("Primer Apellido");

        lbSegundoApellido.setText("Segundo Apellido");

        lbCorreo.setText("Correo");

        lbTelefono.setText("Telefono");

        lbCarrera.setText("Carrera");

        btVolver.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTelefono)
                    .addComponent(lbCorreo)
                    .addComponent(lbSegundoApellido)
                    .addComponent(lbPrimerApellido)
                    .addComponent(lbNombre)
                    .addComponent(lbCarnet)
                    .addComponent(lbCarrera))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCarnet)
                                    .addComponent(txtNombre)
                                    .addComponent(txtPrimerApellido)
                                    .addComponent(txtSegundoApellido)
                                    .addComponent(txtCorreo)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(42, 42, 42)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btRegistrarEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCarnet)
                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrimerApellido)
                    .addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSegundoApellido)
                    .addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCarrera))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRegistrarEstudiante)
                        .addGap(34, 34, 34)
                        .addComponent(btVolver)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRegistrarEstudianteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudianteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudianteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudianteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudianteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarEstudianteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btRegistrarEstudiante;
    public javax.swing.JButton btVolver;
    public javax.swing.JComboBox<String> cbCarrera;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbCarnet;
    private javax.swing.JLabel lbCarrera;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrimerApellido;
    private javax.swing.JLabel lbSegundoApellido;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTitulo;
    public javax.swing.JTextField txtCarnet;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrimerApellido;
    public javax.swing.JTextField txtSegundoApellido;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
