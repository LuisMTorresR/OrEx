package ventanas;

import clases.Disennio;
import clases.Buscar;
import clases.Modificar;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author luism
 */
public class InformacionDelEmpleado extends javax.swing.JFrame {

    private static String[] modificar;

    /**
     * Creates new form InformacionDelEmpleado
     */
    public InformacionDelEmpleado() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Información del Empleado");
        Disennio wallpaperUrl = new Disennio();

        ImageIcon wallpaper = new ImageIcon(new ImageIcon(wallpaperUrl.getWallpaper()).getImage()
                .getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(), Image.SCALE_DEFAULT));
        labelWallpaper.setIcon(wallpaper);

        llenadoInfo();

    }

    @Override
    public Image getIconImage() {
        Disennio icono = new Disennio();
        return icono.getIconImage();
    }

    public void llenadoInfo() {

        String[] datos = Buscar.getDatos();
        txtNombre.setText(datos[0]);
        txtApellido.setText(datos[1]);
        txtEmail.setText(datos[2]);
        txtUser.setText(datos[3]);
        txtpassword.setText(datos[4]);
        txtCategoria.setText(datos[5]);
        txtTelf.setText(datos[6]);
        txtDireccion.setText(datos[7]);
    }

    public void guardarInfo() {

        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else if (txtApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else if (txtUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else if (txtpassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else if (txtTelf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else if (txtDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else {

            modificar = new String[8];

            modificar[0] = txtNombre.getText();
            modificar[1] = txtApellido.getText();
            modificar[2] = txtEmail.getText();
            modificar[3] = txtUser.getText();
            modificar[4] = txtpassword.getText();
            modificar[5] = txtCategoria.getText();
            modificar[6] = txtTelf.getText();
            modificar[7] = txtDireccion.getText();

            try {
                new Modificar().modificarUsuario();
            } catch (IOException ex) {
                Logger.getLogger(InformacionDelEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtNombre.setEditable(false);
            txtNombre.setBackground(Color.white);
            txtApellido.setEditable(false);
            txtApellido.setBackground(Color.white);
            txtEmail.setEditable(false);
            txtEmail.setBackground(Color.white);
            txtUser.setEditable(false);
            txtUser.setBackground(Color.white);
            txtpassword.setEditable(false);
            txtpassword.setBackground(Color.white);
            txtTelf.setEditable(false);
            txtTelf.setBackground(Color.white);
            txtDireccion.setEditable(false);
            txtDireccion.setBackground(Color.white);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelf = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        botonEditar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        labelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Mongolian Baiti", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Información del Empleado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 135, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 175, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 215, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dirección:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 215, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 95, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contraseña:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 135, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Categoria:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 175, -1, -1));

        txtNombre.setEditable(false);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 110, -1));

        txtApellido.setEditable(false);
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 110, -1));

        txtEmail.setEditable(false);
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 110, -1));

        txtTelf.setEditable(false);
        getContentPane().add(txtTelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 110, -1));

        txtDireccion.setEditable(false);
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 130, -1));

        txtUser.setEditable(false);
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 130, -1));

        txtpassword.setEditable(false);
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 130, -1));

        txtCategoria.setEditable(false);
        getContentPane().add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 130, -1));

        botonEditar.setBackground(new java.awt.Color(51, 51, 51));
        botonEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonEditar.setForeground(new java.awt.Color(255, 255, 255));
        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 90, 40));

        botonGuardar.setBackground(new java.awt.Color(51, 51, 51));
        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 90, 40));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        guardarInfo();

    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed

        txtNombre.setEditable(true);
        txtNombre.setBackground(new Color(63, 255, 51));
        txtApellido.setEditable(true);
        txtApellido.setBackground(new Color(63, 255, 51));
        txtEmail.setEditable(true);
        txtEmail.setBackground(new Color(63, 255, 51));
        txtUser.setEditable(true);
        txtUser.setBackground(new Color(63, 255, 51));
        txtpassword.setEditable(true);
        txtpassword.setBackground(new Color(63, 255, 51));
        txtTelf.setEditable(true);
        txtTelf.setBackground(new Color(63, 255, 51));
        txtDireccion.setEditable(true);
        txtDireccion.setBackground(new Color(63, 255, 51));

    }//GEN-LAST:event_botonEditarActionPerformed

    public static String[] getModificar() {
        return modificar;
    }

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
            java.util.logging.Logger.getLogger(InformacionDelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionDelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionDelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionDelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionDelEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelWallpaper;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelf;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtpassword;
    // End of variables declaration//GEN-END:variables
}
