package clases;

import java.io.*;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import ventanas.RegistrarProducto;

/**
 *
 * @author luism
 */
public class GestionProductos {

    public DefaultTableModel tableModel = new DefaultTableModel();

    public GestionProductos() {
    }

    public void registrarProducto() throws FileNotFoundException, IOException {
        String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();

        Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
        String nombreHoja = libro.getSheetName(1);
        Sheet hoja = libro.getSheet(nombreHoja);
        String[][] datos = RegistrarProducto.getDatos();

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
        } catch (Exception e) {
        }
    }

    public void llenadoTablaProductos() {
        try {
            String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(1);
            Sheet hoja = libro.getSheet(nombreHoja);

            int maxCol = 0;
            for (int a = 0; a <= hoja.getLastRowNum(); a++) {
                if (hoja.getRow(a) != null) {
                    if (hoja.getRow(a).getLastCellNum() > maxCol) {
                        maxCol = hoja.getRow(a).getLastCellNum();
                    }
                }
            }
            if (maxCol > 0) {
                //Añade encabezado a la tabla
                for (int i = 1; i <= maxCol; i++) {
                    tableModel.addColumn("Col." + i);
                }
                //recorre fila por fila
                Iterator<Row> rowIterator = hoja.iterator();
                while (rowIterator.hasNext()) {

                    int index = 0;
                    Row fila = rowIterator.next();

                    Object[] obj = new Object[fila.getLastCellNum()];
                    Iterator<Cell> cellIterator = fila.cellIterator();

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        //contenido para celdas vacias
                        while (index < cell.getColumnIndex()) {
                            obj[index] = "";
                            index += 1;
                        }
                        obj[index] = cell.getStringCellValue();
                        index += 1;
                    }
                    tableModel.addRow(obj);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No existe una base de datos");
            }
        } catch (IOException ex) {
            System.err.println("Error en la base de datos" + ex.getMessage());
        }
    }
}
