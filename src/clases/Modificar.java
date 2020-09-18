package clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import ventanas.InformacionDelEmpleado;
import ventanas.ListadoDeEmpleados;
import ventanas.RegistrarDeEmpleado;

/**
 *
 * @author luism
 */
public class Modificar {

    private String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();

    public void modificarUsuario() throws FileNotFoundException, IOException {

        Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
        String nombreHoja = libro.getSheetName(0);
        Sheet hoja = libro.getSheet(nombreHoja);
        String[] datos = InformacionDelEmpleado.getModificar();

        ListadoDeEmpleados num = new ListadoDeEmpleados();
        int id = num.getId();
         int index = 0;
        Row fila = hoja.getRow(id);
        Iterator<Cell> cellIterator = fila.cellIterator();
        while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.setCellValue(datos[index]);
                index += 1;

            }
        
        try (OutputStream fileOut = new FileOutputStream(nameFile)) {
            libro.write(fileOut);
            libro.close();
        } catch (Exception e) {
        }
        
        System.out.println("Calse modificar:" + Arrays.toString(datos));

    }

}