package ventanas;

import clases.Disennio;
import clases.GestionEmpleados;
import clases.Metodos;
import java.awt.Image;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luism
 */
public class ListadoDeEmpleados extends javax.swing.JFrame {
    
    private static int id;
    
    public ListadoDeEmpleados() throws IOException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Gestion de Empleados");
        Disennio wallpaperUrl = new Disennio();
        
        ImageIcon wallpaper = new ImageIcon(new ImageIcon(wallpaperUrl.getWallpaper()).getImage()
                .getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(), Image.SCALE_DEFAULT));
        labelWallpaper.setIcon(wallpaper);

        //Lenado de la tabla de Empleados
        GestionEmpleados llenarTabla = new GestionEmpleados();
        llenarTabla.llenadoTablaEmpleados();
        DefaultTableModel modelo = llenarTabla.tableModel;
        this.tabla.setModel(modelo);
        
    }
    
    @Override
    public Image getIconImage() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonInfo = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int col){
                for(int i = 0; i<tabla.getRowCount(); i++){
                    if(row==i){
                        return false;
                    }
                }
                return true;
            }
        };
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 669, 275));

        botonInfo.setText("Informacion");
        botonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInfoActionPerformed(evt);
            }
        });
        getContentPane().add(botonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 397, -1, -1));

        botonEliminar.setText("Eliminar");
        getContentPane().add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Gestion de Empleados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 700, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        

    }//GEN-LAST:event_botonModificarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
    
        if (evt.getClickCount() == 1) {
           id = tabla.getSelectedRow();
        }

        Metodos seletor = new Metodos();
        seletor.buscarEmpleado();
        
        
    }//GEN-LAST:event_tablaMouseClicked

    private void botonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInfoActionPerformed
        
        new InformacionDelEmpleado().setVisible(true);
        
    }//GEN-LAST:event_botonInfoActionPerformed
    
    public int getId() {
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
            java.util.logging.Logger.getLogger(ListadoDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoDeEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListadoDeEmpleados().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ListadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonInfo;
    private javax.swing.JButton botonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelWallpaper;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}