package ventanas;

import clases.Buscar;
import clases.Disennio;
import clases.GestionProductos;
import java.awt.Image;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author luism
 */
public class ListadoDeProductos extends javax.swing.JFrame {

    private static int id;
    
    public ListadoDeProductos() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Gestio de Productos");
        Disennio wallpaperUrl = new Disennio();

        ImageIcon wallpaper = new ImageIcon(new ImageIcon(wallpaperUrl.getWallpaper()).getImage()
                .getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(), Image.SCALE_DEFAULT));
        labelWallpaper.setIcon(wallpaper);
        
        //Lenado de la tabla de Productos
        GestionProductos llenarTabla = new GestionProductos();
        llenarTabla.llenadoTablaProductos();
        DefaultTableModel modelo = llenarTabla.tableModel;
        this.tabla.setModel(modelo);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonActualizar = new javax.swing.JButton();
        botonInfo = new javax.swing.JButton();
        botonModif = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        labelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("Gestion de Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 11, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 646, 311));

        botonActualizar.setText("Actualizar");
        getContentPane().add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, -1));

        botonInfo.setText("Informacion");
        botonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInfoActionPerformed(evt);
            }
        });
        getContentPane().add(botonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        botonModif.setText("Modificar");
        botonModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModifActionPerformed(evt);
            }
        });
        getContentPane().add(botonModif, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        botonEliminar.setText("Eliminar");
        getContentPane().add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, -1, -1));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -3, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
      
        if (evt.getClickCount() == 1) {
           id = tabla.getSelectedRow();
        }

        Buscar selector = new Buscar();
        selector.buscarProducto();
        
    }//GEN-LAST:event_tablaMouseClicked

    private void botonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInfoActionPerformed
        
        new InformacionDelProducto().setVisible(true);
        
    }//GEN-LAST:event_botonInfoActionPerformed

    private void botonModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModifActionPerformed
     
        new ModificarProducto().setVisible(true);
        
    }//GEN-LAST:event_botonModifActionPerformed

    public static int getId() {
        return id;
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
            java.util.logging.Logger.getLogger(ListadoDeProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoDeProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoDeProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoDeProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoDeProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonInfo;
    private javax.swing.JButton botonModif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelWallpaper;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
