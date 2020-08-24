
package ventanas;

import clases.Disennio;
import java.awt.Image;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAggProducto = new javax.swing.JButton();
        botonGestionProducto = new javax.swing.JButton();
        botonRegistroEmpl = new javax.swing.JButton();
        botonGestionEmpl = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        botonInventario = new javax.swing.JButton();
        botonVentas = new javax.swing.JButton();
        botonCaja = new javax.swing.JButton();
        botonLibros = new javax.swing.JButton();
        labelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAggProducto.setText("Agg Producto");
        botonAggProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(botonAggProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 80, 70));

        botonGestionProducto.setText("Gestion Producto");
        botonGestionProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(botonGestionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 80, 70));

        botonRegistroEmpl.setText("Registrar Empleado");
        botonRegistroEmpl.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(botonRegistroEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 80, 70));

        botonGestionEmpl.setText("Gestionoar Empleado");
        botonGestionEmpl.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(botonGestionEmpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 80, 70));

        jButton5.setText("Inventario");
        jButton5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 80, 70));

        botonInventario.setText("Inventario");
        botonInventario.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(botonInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 80, 70));

        botonVentas.setText("Ventas");
        botonVentas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(botonVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 80, 70));

        botonCaja.setText("Caja");
        botonCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(botonCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 80, 70));

        botonLibros.setText("Libros");
        botonLibros.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(botonLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 80, 70));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JButton botonAggProducto;
    private javax.swing.JButton botonCaja;
    private javax.swing.JButton botonGestionEmpl;
    private javax.swing.JButton botonGestionProducto;
    private javax.swing.JButton botonInventario;
    private javax.swing.JButton botonLibros;
    private javax.swing.JButton botonRegistroEmpl;
    private javax.swing.JButton botonVentas;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel labelWallpaper;
    // End of variables declaration//GEN-END:variables
}
