package clases;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import ventanas.RegistrarEmpleado;

/**
 *
 * @author luism
 */
public class GestionEmpleados {

    private String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();
    public DefaultTableModel tableModel = new DefaultTableModel();
   

    public GestionEmpleados() {

    }

    public void registrarEmpleado() throws FileNotFoundException, IOException {

        Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
        String nombreHoja = libro.getSheetName(0);
        Sheet hoja = libro.getSheet(nombreHoja);
        String[][] datos = RegistrarEmpleado.getDatos();

        int ultimaFila = hoja.getLastRowNum() + 1;

        for (int i = 0; i < datos.length; i++) {
            Row filaNueva = hoja.createRow(i + ultimaFila);
            Row primeraFila = hoja.getRow(0);
            int numeroCeldas = primeraFila.getLastCellNum();
            for (int j = 0; j < numeroCeldas; j++) {

                Cell celdaNueva = filaNueva.createCell(j);
                celdaNueva.setCellValue(datos[i][j]);
            }
        }
        try (OutputStream fileOut = new FileOutputStream(nameFile)) {
            libro.write(fileOut);
            libro.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No existe una base de datos");
        }
    }
    
    public void eliminarEmpleado(int id){
         try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(0);
            Sheet hoja = libro.getSheet(nombreHoja);

            
            new BaseDeDatos().removeRow(hoja, id);

            try (OutputStream fileOut = new FileOutputStream(nameFile)) {
                libro.write(fileOut);
                libro.close();
                JOptionPane.showMessageDialog(null, "Registro del empleado eliminado");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error " + ex);
            }

        } catch (IOException ex) {
            System.err.println("Error en la base de datos" + ex.getMessage());
        }
    }

    public void llenadoTablaEmpleados() {
        
        tableModel.addColumn("NOMBRE");
        tableModel.addColumn("APELLIDO");
        tableModel.addColumn("EMAIL");
        tableModel.addColumn("USERNAME");
        tableModel.addColumn("PASSWORD");
        tableModel.addColumn("CATEGORIA");
        tableModel.addColumn("TELEFONO");
        tableModel.addColumn("DIRECCION");

        
        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(0);
            Sheet hoja = libro.getSheet(nombreHoja);
            

           int primeraFila = 1; // 0 based 
            Object[] obj = null;
            for (int i = primeraFila; i <= hoja.getLastRowNum(); i++) {
                Row fila = hoja.getRow(i);
                if (fila == null) {
                    JOptionPane.showMessageDialog(null, "No hay datos");
                } else {
                    obj = new Object[fila.getLastCellNum()];
                    for (int cn = fila.getFirstCellNum(); cn < fila.getLastCellNum(); cn++) {
                        Cell celda = fila.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                        if (celda == null) {
                            JOptionPane.showMessageDialog(null, "No hay datos"); 
                        } else {
                            obj[cn] = celda.getStringCellValue();
                        }
                    }
                    tableModel.addRow(obj);
                    
                }
            }
        } catch (IOException ex) {
            System.err.println("Error en la base de datos" + ex.getMessage());
        }

    }
    
}
