package clases;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import ventanas.Caja;
import ventanas.VentasDiarias;

/**
 *
 * @author luism
 */
public class VentasClass {
    
    Date date = BaseDeDatos.getDate();

    private String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();
    private static DefaultTableModel tableModel;

    public String[][] obtenerInformcion(DefaultTableModel tableModel) {
        int cols = tableModel.getColumnCount();
        int filas = tableModel.getRowCount();
        String[][] datos = new String[tableModel.getRowCount()][tableModel.getColumnCount()];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {

                datos[i][j] = (String) tableModel.getValueAt(i, j);

            }
        }
        return datos;

    }

    public void ventasDiarias() {

        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(2);
            Sheet hoja = libro.getSheet(nombreHoja);
            tableModel = Caja.getTableModel2();
            String[][] datos = obtenerInformcion(tableModel);
            int ultimaFila = hoja.getLastRowNum() + 1;

            for (int i = 0; i < datos.length; i++) {
                Row filaNueva = hoja.createRow(i + ultimaFila);
                Row primeraFila = hoja.getRow(0);
                var numeroCeldas = primeraFila.getLastCellNum();
                for (int j = 0; j < numeroCeldas; j++) {

                    Cell celdaNueva = filaNueva.createCell(j);
                    celdaNueva.setCellValue(datos[i][j]);
                }
            }

            try (OutputStream fileOut = new FileOutputStream(nameFile)) {
                libro.write(fileOut);
                libro.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No existe una base de datos" + ex);
            }

        } catch (Exception e) {
        }

    }

    public void ventasMensuales() {

        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(3);
            Sheet hoja = libro.getSheet(nombreHoja);
            tableModel = VentasDiarias.getTableModel();
            String[][] datos = obtenerInformcion(tableModel);
            int ultimaFila = hoja.getLastRowNum() + 1;

            for (int i = 0; i < datos.length; i++) {
                Row filaNueva = hoja.createRow(i + ultimaFila);
                Row primeraFila = hoja.getRow(0);
                var numeroCeldas = primeraFila.getLastCellNum();
                for (int j = 0; j < numeroCeldas; j++) {

                    Cell celdaNueva = filaNueva.createCell(j);
                    celdaNueva.setCellValue(datos[i][j]);
                }
            }

            try (OutputStream fileOut = new FileOutputStream(nameFile)) {
                libro.write(fileOut);
                libro.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No existe una base de datos" + ex);
            }

        } catch (Exception e) {
        }
    }

    public void llenadoTablaVentas(int num) {

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Marca");
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("PrecioUnit $");
        tableModel.addColumn("Total $");
        tableModel.addColumn("Ganancia $");
        tableModel.addColumn("PrecioUnit Bs");
        tableModel.addColumn("Total Bs");
        tableModel.addColumn("Ganancia Bs");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("MetDePago");

        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(num);
            Sheet hoja = libro.getSheet(nombreHoja);
            int primeraFila = 1;
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
                            // The cell is empty 
                        } else {
                            obj[cn] = celda.getStringCellValue();
                        }
                    }
                    tableModel.addRow(obj);

                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No existe una base de datos" + ex);
        }
    }

    public void totalGanancia(DefaultTableModel tableModel) {
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaDiaria = fecha.format(date);
        String[] totales = new String[10];
        double totalDoll = 0;
        double totalBs = 0;
        double gananciasDoll = 0;
        double gananciasBs = 0;
        double p = 0;

        if (tableModel.getRowCount() > 0) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                p = Float.parseFloat(tableModel.getValueAt(i, 4).toString());
                totalDoll += p;
            }
        }

        if (tableModel.getRowCount() > 0) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                p = Double.parseDouble(tableModel.getValueAt(i, 5).toString());
                gananciasDoll += p;
            }
        }
        
        if (tableModel.getRowCount() > 0) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                p = Double.parseDouble(tableModel.getValueAt(i, 7).toString());
                totalBs += p;
            }
        }
        
        if (tableModel.getRowCount() > 0) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                p = Double.parseDouble(tableModel.getValueAt(i, 8).toString());
                gananciasBs += p;
            }
        }
        
        totales[0] = "";
        totales[1] = "";
        totales[2] = "";
        totales[3] = "";
        totales[4] = "Total $";
        totales[5] = "Ganancia $";
        totales[6] = "";
        totales[7] = "Total Bs";
        totales[8] = "Ganancia Bs";
        totales[9] = "";
        tableModel.addRow(totales);
        
        totales[0] = "";
        totales[1] = "";
        totales[2] = "";
        totales[3] = "";
        totales[4] = String.valueOf(totalDoll);
        totales[5] = String.valueOf(gananciasDoll);
        totales[6] = "";
        totales[7] = String.valueOf((int) totalBs);
        totales[8] = String.valueOf(gananciasBs);
        totales[9] = fechaDiaria;
        tableModel.addRow(totales);
    }

    public static DefaultTableModel getTableModel() {
        return tableModel;
    }

}
