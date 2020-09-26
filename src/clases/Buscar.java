package clases;

import java.io.*;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import ventanas.Caja;
import ventanas.ListadoDeEmpleados;

/**
 *
 * @author luism
 */
public class Buscar {

    private String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();
    private int id;
    private static String[] datos;

    public void buscarEmpleado( int id) {

        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(0);
            Sheet hoja = libro.getSheet(nombreHoja);

            //recorre celda por celda
            ListadoDeEmpleados num = new ListadoDeEmpleados();
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

    //buscar producto por ID
    public void buscarProducto(int id) {

        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(1);
            Sheet hoja = libro.getSheet(nombreHoja);

            //recorre celda por celda
            
            //id = ListadoDeProductos.getId();
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

    //buscar producto por codigo
    public void buscarCodigo() {

        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(1);
            Sheet hoja = libro.getSheet(nombreHoja);
            String codigo;

            Iterator<Row> rowIterator = hoja.iterator();
            String codigoCaja = Caja.getCodigo();
            while (rowIterator.hasNext()) {
                Row fila = rowIterator.next();
                Cell celda = fila.getCell(0);
                codigo = celda.getStringCellValue();

                if (codigo.equals(codigoCaja)) {
                    id = celda.getRowIndex();
                }
            }
            int index = 0;
            Row fila = hoja.getRow(id);

            datos = new String[fila.getLastCellNum()];
            Iterator<Cell> cellIterator = fila.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                datos[index] = cell.getStringCellValue();
                index += 1;

            }

        } catch (IOException | EncryptedDocumentException e) {
        }

    }
    

    

    public static String[] getDatos() {
        return datos;
    }

}
