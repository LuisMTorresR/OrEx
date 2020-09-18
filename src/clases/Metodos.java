package clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author luism
 */
public class Metodos {

    private String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();

    public void buscarEmpleado() {

        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(0);
            Sheet hoja = libro.getSheet(nombreHoja);

            //recorre celda por celda
            int index = 0;
            Row fila = hoja.getRow(0);

            Object[] obj = new Object[fila.getLastCellNum()];
            Iterator<Cell> cellIterator = fila.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                obj[index] = cell.getStringCellValue();
                index += 1;

            }

        } catch (IOException ex) {
            System.err.println("Error en la base de datos" + ex.getMessage());
        }

    }

    public static void main(String[] args) {
        Metodos prueba = new Metodos();
        prueba.buscarEmpleado();

    }

}
