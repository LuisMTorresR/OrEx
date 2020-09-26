package clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import ventanas.Caja;

/**
 *
 * @author luism
 */
public class VentasClass {

    private String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();

    public String[][] obtenerInformcion() {
        DefaultTableModel tableModel = Caja.getTableModel();
        int cols = tableModel.getColumnCount();
        int filas = tableModel.getRowCount();
        String[][] datos = new String[tableModel.getRowCount()][tableModel.getColumnCount()];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                // System.out.print(tableModel.getValueAt(i,j));
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
            String[][] datos = obtenerInformcion();
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
            System.out.println(Arrays.deepToString(datos));
            try (OutputStream fileOut = new FileOutputStream(nameFile)) {
                libro.write(fileOut);
                libro.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No existe una base de datos" + ex);
            }

        } catch (Exception e) {
        }

    }
}
