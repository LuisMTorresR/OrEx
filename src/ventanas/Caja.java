package ventanas;

import clases.ActualizacionDeStock;
import clases.Buscar;
import clases.Disennio;
import clases.Modificar;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luism
 */
public class Caja extends javax.swing.JFrame {

    private float dolar = PrecioDolar.getDolar();
    private static String codigo;
    private String[] datos;
    private String nombre;
    private String marca;
    private String precioUnitarioDolares;
    private String cantidad;
    private static String cantidades;
    private float preciofloatDolares;
    private float precioDoubleBs;
    private static DefaultTableModel tableModel;

    public Caja() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Caja");
        Disennio wallpaperUrl = new Disennio();

        ImageIcon wallpaper = new ImageIcon(new ImageIcon(wallpaperUrl.getWallpaper()).getImage()
                .getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(), Image.SCALE_DEFAULT));
        labelWallpaper.setIcon(wallpaper);

        llenadoTabla();

    }

    @Override
    public Image getIconImage() {
        Disennio icono = new Disennio();
        return icono.getIconImage();
    }

    public void llenadoTabla() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Marca");
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("PrecioUnit $.");
        tableModel.addColumn("Total $.");
        tableModel.addColumn("PrecioUnit Bs.");
        tableModel.addColumn("Total Bs.");

        tabla.setModel(tableModel);
    }

    public void recuperarDatos() {

        codigo = txtCodigo.getText();
        new Buscar().buscarCodigo();
        datos = Buscar.getDatos();

        nombre = datos[1];
        marca = datos[2];
        precioUnitarioDolares = datos[4];
        cantidad = datos[5];
    }

    public void cargarProducto() {

        cantidades = String.valueOf(txtCantidad.getText());
        float cantidadesNum = Float.parseFloat(cantidades);
        preciofloatDolares = Float.parseFloat(precioUnitarioDolares);
        precioDoubleBs = preciofloatDolares * dolar;

        if (cantidadesNum > 1) {
            preciofloatDolares = preciofloatDolares * cantidadesNum;
            precioDoubleBs = precioDoubleBs * cantidadesNum;
        }

        //Tabla de ventas
        String[] articulos = new String[7];
        articulos[0] = nombre;
        articulos[1] = marca;
        articulos[2] = cantidades;
        articulos[3] = precioUnitarioDolares;
        articulos[4] = String.valueOf(Float.parseFloat(precioUnitarioDolares) * cantidadesNum);
        articulos[5] = String.valueOf((int) (Double.parseDouble(precioUnitarioDolares) * dolar));
        articulos[6] = String.valueOf((int) (((Double.parseDouble(precioUnitarioDolares) * dolar)) * cantidadesNum));

        tableModel.addRow(articulos);
        tabla.setModel(tableModel);

        txtCodigo.setText("");
        txtCantidad.setText("");
        verificarStock();

    }

    public void verificarStock() {

        if (Integer.parseInt(cantidades) > Integer.parseInt(cantidad)) {
            int fila = tableModel.getRowCount() - 1;
            tableModel.removeRow(fila);
            JOptionPane.showMessageDialog(null, "No hay stock");

        }

    }

    public void totalCobrar() {

        double t = 0;
        double p = 0;

        if (tabla.getRowCount() > 0) {
            for (int i = 0; i < tabla.getRowCount(); i++) {
                p = Float.parseFloat(tabla.getValueAt(i, 4).toString());
                t += p;
            }
            labelTotalDoll.setText("Total $: " + (float) t);
        }

        if (tabla.getRowCount() > 0) {
            for (int i = 0; i < tabla.getRowCount(); i++) {
                p = Double.parseDouble(tabla.getValueAt(i, 6).toString());
                t += p;
            }
            labelTotalBs.setText("Total Bs: " + (int) t);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonEliminar = new javax.swing.JButton();
        labelTotalDoll = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        botonDetalle = new javax.swing.JButton();
        botonagregar = new javax.swing.JButton();
        labelTotalBs = new javax.swing.JLabel();
        labelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setSize(new java.awt.Dimension(800, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 34, -1, -1));

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 54, 111, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 34, -1, -1));

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 54, 70, -1));

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
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 750, -1));

        botonEliminar.setBackground(new java.awt.Color(102, 102, 102));
        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminar.setText("Eliminar");
        botonEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 100, 40));

        labelTotalDoll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTotalDoll.setForeground(new java.awt.Color(255, 255, 255));
        labelTotalDoll.setText("Total $: ");
        getContentPane().add(labelTotalDoll, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, 350, 30));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cobrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 570, 100, 40));

        botonDetalle.setBackground(new java.awt.Color(102, 102, 102));
        botonDetalle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonDetalle.setForeground(new java.awt.Color(255, 255, 255));
        botonDetalle.setText("Detalle");
        botonDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetalleActionPerformed(evt);
            }
        });
        getContentPane().add(botonDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 100, 40));

        botonagregar.setBackground(new java.awt.Color(102, 102, 102));
        botonagregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonagregar.setForeground(new java.awt.Color(255, 255, 255));
        botonagregar.setText("Agregar");
        botonagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonagregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 100, 40));

        labelTotalBs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTotalBs.setForeground(new java.awt.Color(255, 255, 255));
        labelTotalBs.setText("Total Bs:");
        getContentPane().add(labelTotalBs, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 360, 30));
        getContentPane().add(labelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonagregarActionPerformed

        if (txtCodigo.getText().equals("") || txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar los campos");
        } else {
            cargarProducto();
            totalCobrar();
            new Modificar().actualizarCantidad();

        }
    }//GEN-LAST:event_botonagregarActionPerformed


    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased

        if (txtCodigo.getText().length() > 1) {
            recuperarDatos();
        }

    }//GEN-LAST:event_txtCodigoKeyReleased


    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased

        cantidades = txtCantidad.getText();
        if (cantidades.length() > 0 && Integer.parseInt(cantidades) > Integer.parseInt(cantidad)) {
                JOptionPane.showMessageDialog(null, "No hay Stock");
                txtCantidad.setText("");
            }
            if (Integer.parseInt(cantidades) == Integer.parseInt(cantidad)) {
                txtCantidad.setBackground(Color.red);
            } else {
                txtCantidad.setBackground(Color.white);
            }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            botonagregar.doClick();
        }

    }//GEN-LAST:event_txtCantidadKeyReleased


    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed

        int num = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el producto?", "Eliminar Producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (num == 0) {
            int fila = tabla.getSelectedRow();
            tableModel.removeRow(fila);
            totalCobrar();
        }
        if (tableModel.getRowCount() == 0) {
            labelTotalDoll.setText("Total $:");
            labelTotalBs.setText("Total Bs:");
        }
    }//GEN-LAST:event_botonEliminarActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed


    private void botonDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetalleActionPerformed


    }//GEN-LAST:event_botonDetalleActionPerformed

    public static String getCodigo() {
        return codigo;
    }

    public static String getCantidades() {
        return cantidades;
    }

    public static DefaultTableModel getTableModel() {
        return tableModel;
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
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDetalle;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonagregar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTotalBs;
    private javax.swing.JLabel labelTotalDoll;
    private javax.swing.JLabel labelWallpaper;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    private static javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
