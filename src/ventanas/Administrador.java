
package ventanas;

import clases.BaseDeDatos;
import clases.Disennio;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author luism
 */
public class Administrador extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Administrador");
        Disennio wallpaperUrl = new Disennio();
        
        ImageIcon wallpaper = new ImageIcon(new ImageIcon(wallpaperUrl.getWallpaper()).getImage()
                .getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(), Image.SCALE_DEFAULT));
        labelWallpaper.setIcon(wallpaper);
        
    }
    
    @Override
    public Image getIconImage(){
        Disennio icono = new Disennio();
        return icono.getIconImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAggProducto = new javax.swing.JButton();
        botonGestionProducto = new javax.swing.JButton();
        botonRegistroEmpl = new javax.swing.JButton();
        botonGestionEmpl = new javax.swing.JButton();
        bontonVentas = new javax.swing.JButton();
        botonInventario = new javax.swing.JButton();
        botonCrearBaseDeDatos = new javax.swing.JButton();
        botonCaja = new javax.swing.JButton();
        botonLibros = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAggProducto.setBackground(new java.awt.Color(102, 102, 102));
        botonAggProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anadir-a-la-cesta.png"))); // NOI18N
        botonAggProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        botonAggProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAggProductoActionPerformed(evt);
            }
        });
        getContentPane().add(botonAggProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 80, 70));

        botonGestionProducto.setBackground(new java.awt.Color(102, 102, 102));
        botonGestionProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        botonGestionProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        botonGestionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionProductoActionPerformed(evt);
            }
        });
        getContentPane().add(botonGestionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 80, 70));

        botonRegistroEmpl.setBackground(new java.awt.Color(102, 102, 102));
        botonRegistroEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        botonRegistroEmpl.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        botonRegistroEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroEmplActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistroEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 80, 70));

        botonGestionEmpl.setBackground(new java.awt.Color(102, 102, 102));
        botonGestionEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        botonGestionEmpl.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        botonGestionEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionEmplActionPerformed(evt);
            }
        });
        getContentPane().add(botonGestionEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 80, 70));

        bontonVentas.setBackground(new java.awt.Color(102, 102, 102));
        bontonVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dinero.png"))); // NOI18N
        bontonVentas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bontonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonVentasActionPerformed(evt);
            }
        });
        getContentPane().add(bontonVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 80, 70));

        botonInventario.setBackground(new java.awt.Color(102, 102, 102));
        botonInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inventario.png"))); // NOI18N
        botonInventario.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        botonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInventarioActionPerformed(evt);
            }
        });
        getContentPane().add(botonInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 80, 70));

        botonCrearBaseDeDatos.setBackground(new java.awt.Color(102, 102, 102));
        botonCrearBaseDeDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/servidor.png"))); // NOI18N
        botonCrearBaseDeDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        botonCrearBaseDeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearBaseDeDatosActionPerformed(evt);
            }
        });
        getContentPane().add(botonCrearBaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 80, 70));

        botonCaja.setBackground(new java.awt.Color(102, 102, 102));
        botonCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja-registradora.png"))); // NOI18N
        botonCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        botonCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCajaActionPerformed(evt);
            }
        });
        getContentPane().add(botonCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 80, 70));

        botonLibros.setBackground(new java.awt.Color(102, 102, 102));
        botonLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configuraciones.png"))); // NOI18N
        botonLibros.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(botonLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 80, 70));

        jLabel1.setFont(new java.awt.Font("Mongolian Baiti", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Panel de Administrador");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Caja");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Inventario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ventas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registrar Empleado");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registrar Producto");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sistema");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Crear Base de Datos");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gestion de Productos");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Listado de Empleados");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGestionEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionEmplActionPerformed
       
        try {
            new ListadoDeEmpleados().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botonGestionEmplActionPerformed

    private void botonRegistroEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroEmplActionPerformed
        
        new RegistrarDeEmpleado().setVisible(true);
        
    }//GEN-LAST:event_botonRegistroEmplActionPerformed

    private void botonCrearBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearBaseDeDatosActionPerformed
  
        try {
            new BaseDeDatos().crearBaseDeDatos();
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botonCrearBaseDeDatosActionPerformed

    private void botonAggProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAggProductoActionPerformed

        new RegistrarProducto().setVisible(true);
        
    }//GEN-LAST:event_botonAggProductoActionPerformed

    private void botonGestionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionProductoActionPerformed
       
        new ListadoDeProductos().setVisible(true);
        
    }//GEN-LAST:event_botonGestionProductoActionPerformed

    private void botonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInventarioActionPerformed
        
        new Inventario().setVisible(true);
        
    }//GEN-LAST:event_botonInventarioActionPerformed

    private void bontonVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonVentasActionPerformed
        
        new Ventas().setVisible(true);
        
    }//GEN-LAST:event_bontonVentasActionPerformed

    private void botonCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCajaActionPerformed
        
        new Caja().setVisible(true);
        
    }//GEN-LAST:event_botonCajaActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bontonVentas;
    private javax.swing.JButton botonAggProducto;
    private javax.swing.JButton botonCaja;
    private javax.swing.JButton botonCrearBaseDeDatos;
    private javax.swing.JButton botonGestionEmpl;
    private javax.swing.JButton botonGestionProducto;
    private javax.swing.JButton botonInventario;
    private javax.swing.JButton botonLibros;
    private javax.swing.JButton botonRegistroEmpl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelWallpaper;
    // End of variables declaration//GEN-END:variables
}
