package ventanas;

import clases.BaseDeDatos;
import clases.CajaClass;
import clases.Disennio;
import clases.Modificar;
import clases.VentasClass;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Date;
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
    private String cantidadEnStock;
    private static String metodoDePago;
    private static String cantidadAComprar;
    private static DefaultTableModel tableModel;
    private static DefaultTableModel tableModel2;
    private int fila;
    private Date date = BaseDeDatos.getDate();
    private static String productoDevuelto;

    public Caja() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Caja");
        Disennio wallpaperUrl = new Disennio();

        ImageIcon wallpaper = new ImageIcon(new ImageIcon(wallpaperUrl.getWallpaper()).getImage()
                .getScaledInstance(labelWallpaper.getWidth(), labelWallpaper.getHeight(), Image.SCALE_DEFAULT));
        labelWallpaper.setIcon(wallpaper);

        encabezadoTabla();
    }

    @Override
    public Image getIconImage() {
        Disennio icono = new Disennio();
        return icono.getIconImage();
    }

    public void encabezadoTabla() {

        //Encabezado de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Marca");
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("PrecioUnit $");
        tableModel.addColumn("Total $");
        tableModel.addColumn("PrecioUnit Bs");
        tableModel.addColumn("Total Bs");
        tableModel.addColumn("Fecha");

        //Encabezado de la tabla de ventas
        tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("Nombre");
        tableModel2.addColumn("Marca");
        tableModel2.addColumn("Cantidad");
        tableModel2.addColumn("PrecioUnit $");
        tableModel2.addColumn("Total $");
        tableModel2.addColumn("Ganancia $");
        tableModel2.addColumn("PrecioUnit Bs");
        tableModel2.addColumn("Total Bs");
        tableModel2.addColumn("Ganancia Bs");
        tableModel2.addColumn("Fecha");
        tableModel2.addColumn("MetDePago");
    }

    public void cargarProducto() {

        new CajaClass().llenadoTablaCaja();
        new CajaClass().llenadoHojaDeVentas();
        String[] datosDelProductoCaja;
        String[] datosDelArticuloVentas;
        datosDelProductoCaja = CajaClass.getDatosDelProductoCaja();
        datosDelArticuloVentas = CajaClass.getDatosDelArticuloVentas();
        tableModel.addRow(datosDelProductoCaja);
        tableModel2.addRow(datosDelArticuloVentas);
        tabla.setModel(tableModel);
    }

    public void verificarStock() {

        if (Integer.parseInt(cantidadAComprar) > Integer.parseInt(cantidadEnStock)) {
            int id = tableModel.getRowCount() - 1;
            tableModel.removeRow(id);
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

    public void metodoDePago() {

        if (jRadioButtonDevito.isSelected()) {
            metodoDePago = "Devito";
        } else if (jRadioButtonEfectivo.isSelected()) {
            metodoDePago = "Efectivo";
        } else if (jRadioButtonDevito.isSelected() == false && jRadioButtonEfectivo.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un metodo de pago");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonEliminar = new javax.swing.JButton();
        labelTotalDoll = new javax.swing.JLabel();
        botonCobrar = new javax.swing.JButton();
        botonagregar = new javax.swing.JButton();
        labelTotalBs = new javax.swing.JLabel();
        jRadioButtonEfectivo = new javax.swing.JRadioButton();
        jRadioButtonDevito = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 750, 330));

        botonEliminar.setBackground(new java.awt.Color(51, 51, 51));
        botonEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminar.setText("Eliminar");
        botonEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 100, 40));

        labelTotalDoll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTotalDoll.setForeground(new java.awt.Color(255, 255, 255));
        labelTotalDoll.setText("Total $: ");
        getContentPane().add(labelTotalDoll, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, 350, 30));

        botonCobrar.setBackground(new java.awt.Color(51, 51, 51));
        botonCobrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonCobrar.setForeground(new java.awt.Color(255, 255, 255));
        botonCobrar.setText("Cobrar");
        botonCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCobrarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 100, 40));

        botonagregar.setBackground(new java.awt.Color(51, 51, 51));
        botonagregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonagregar.setForeground(new java.awt.Color(255, 255, 255));
        botonagregar.setText("Agregar");
        botonagregar.setEnabled(false);
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

        buttonGroup1.add(jRadioButtonEfectivo);
        jRadioButtonEfectivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonEfectivo.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonEfectivo.setText("Efectivo");
        getContentPane().add(jRadioButtonEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, -1, -1));

        buttonGroup1.add(jRadioButtonDevito);
        jRadioButtonDevito.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonDevito.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonDevito.setText("Debito");
        getContentPane().add(jRadioButtonDevito, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Metodo de Pago:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));
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
            txtCodigo.setText("");
            txtCantidad.setText("");

        }
    }//GEN-LAST:event_botonagregarActionPerformed


    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased

        codigo = txtCodigo.getText();
        metodoDePago();
        if (txtCodigo.getText().length() > 1) {
            new CajaClass().recuperarDatos();

        }

    }//GEN-LAST:event_txtCodigoKeyReleased

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased

        cantidadEnStock = CajaClass.getCantidadEnStock();
        cantidadAComprar = txtCantidad.getText();

        if (isNumeric(cantidadAComprar)) {

            if (cantidadAComprar.length() > 0 && Integer.parseInt(cantidadAComprar) > Integer.parseInt(cantidadEnStock)) {
                JOptionPane.showMessageDialog(null, "No hay Stock");
                txtCantidad.setText("");
                botonagregar.setEnabled(false);

            } else {
                if (Integer.parseInt(cantidadAComprar) == Integer.parseInt(cantidadEnStock)) {
                    txtCantidad.setBackground(Color.red);
                } else {
                    txtCantidad.setBackground(Color.white);
                }
                botonagregar.setEnabled(true);

                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    botonagregar.doClick();
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Cantidad no valida");
            botonagregar.setEnabled(false);
        }
    }//GEN-LAST:event_txtCantidadKeyReleased


    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
        } else {
            int num = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el producto?", "Eliminar Producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (num == 0) {
                tableModel.removeRow(fila);
                totalCobrar();
            }
            if (tableModel.getRowCount() == 0) {
                labelTotalDoll.setText("Total $:");
                labelTotalBs.setText("Total Bs:");
                new Modificar().devolverProducto();
            }

        }

    }//GEN-LAST:event_botonEliminarActionPerformed


    private void botonCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCobrarActionPerformed

        new VentasClass().ventasDiarias();
        int filas = tableModel.getRowCount();
        for (int i = 0; i < filas; i++) {
            tableModel.removeRow(0);
        }
        labelTotalDoll.setText("Total $:");
        labelTotalBs.setText("Total Bs:");

    }//GEN-LAST:event_botonCobrarActionPerformed


    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        if (evt.getClickCount() == 1) {
            fila = tabla.getSelectedRow();
        }

        productoDevuelto = (String) tableModel.getValueAt(fila, 2);

    }//GEN-LAST:event_tablaMouseClicked

    public static String getCodigo() {
        return codigo;
    }

    public static String getMetodoDePago() {
        return metodoDePago;
    }

    public static String getCantidadAComprar() {
        return cantidadAComprar;
    }

    public static DefaultTableModel getTableModel() {
        return tableModel;
    }

    public static DefaultTableModel getTableModel2() {
        return tableModel2;
    }

    public static String getProductoDevuelto() {
        return productoDevuelto;
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
    private javax.swing.JButton botonCobrar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonagregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButtonDevito;
    private javax.swing.JRadioButton jRadioButtonEfectivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTotalBs;
    private javax.swing.JLabel labelTotalDoll;
    private javax.swing.JLabel labelWallpaper;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    private static javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
