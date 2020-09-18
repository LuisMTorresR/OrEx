package clases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import ventanas.ListadoDeEmpleados;
import ventanas.ListadoDeProductos;

/**
 *
 * @author luism
 */
public class Buscar {

    private String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();
    private int id;
    private static String[] datos;

    public void buscarEmpleado() {
        

        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(0);
            Sheet hoja = libro.getSheet(nombreHoja);

            //recorre celda por celda
            ListadoDeEmpleados num = new ListadoDeEmpleados();
            id = num.getId();
            int index = 0;
            Row fila = hoja.getRow(id);

            datos = new String[fila.getLastCellNum()];
            Iterator<Cell> cellIterator = fila.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                datos[index] = cell.getStringCellValue();
                index += 1;

            }

        } catch (IOException ex) {
            System.err.println("Error en la base de datos" + ex.getMessage());
        }

    }
    
    public void buscarProducto(){
        
        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(1);
            Sheet hoja = libro.getSheet(nombreHoja);

            //recorre celda por celda
            id = ListadoDeProductos.getId();
            int index = 0;
            Row fila = hoja.getRow(id);

            datos = new String[fila.getLastCellNum()];
            Iterator<Cell> cellIterator = fila.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                datos[index] = cell.getStringCellValue();
                index += 1;

            }

        } catch (IOException ex) {
            System.err.println("Error en la base de datos" + ex.getMessage());
        }
        
    }

    public static String[] getDatos() {
        return datos;
    }

}
