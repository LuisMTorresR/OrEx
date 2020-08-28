package clases;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import ventanas.RegistrarProducto;

/**
 *
 * @author luism
 */
public class GestionProductos {

    public GestionProductos() {
    }
    
    public void registrarProducto() throws FileNotFoundException, IOException{
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
}

