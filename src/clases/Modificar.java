package clases;

import java.io.*;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import ventanas.Caja;
import ventanas.InformacionDelEmpleado;
import ventanas.ListadoDeEmpleados;
import ventanas.GestionDeProductos;
import ventanas.ModificarProducto;

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

        int id = ListadoDeEmpleados.getId() + 1;
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
            JOptionPane.showMessageDialog(null, "Cambios guardados con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }

    }

    public void modificarProducto() throws FileNotFoundException, IOException {

        Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
        String nombreHoja = libro.getSheetName(1);
        Sheet hoja = libro.getSheet(nombreHoja);
        String[] datos = ModificarProducto.getModificar();

        int id = GestionDeProductos.getId() + 1;
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
            JOptionPane.showMessageDialog(null, "Producto Modificado");
        } catch (Exception e) {
        }
    }

    public void actualizarCantidad() {
        int id = 0;
        String[] datos = null;
        String cantidadRestar = Caja.getCantidadAComprar();
        String cantidadStock = "";
        int cantidadFinal = 0;

        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(1);
            Sheet hoja = libro.getSheet(nombreHoja);
            String codigo;

            //recorre fila por fila
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
            cantidadStock = datos[6];
            cantidadFinal = Integer.parseInt(cantidadStock) - Integer.parseInt(cantidadRestar);

            Cell celdaModificar = fila.createCell(6);
            celdaModificar.setCellValue(String.valueOf(cantidadFinal));

            try (OutputStream fileOut = new FileOutputStream(nameFile)) {
                libro.write(fileOut);
                libro.close();
            } catch (Exception e) {
            }

        } catch (IOException | EncryptedDocumentException e) {
        }

    }

    public void devolverProducto() {
        int id = 0;
        String[] datos = null;
        String productoDevuelto = Caja.getProductoDevuelto();
        String cantidadStock = "";
        int cantidadFinal = 0;

        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(1);
            Sheet hoja = libro.getSheet(nombreHoja);
            String codigo;

            //recorre fila por fila
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
            cantidadStock = datos[6];
            cantidadFinal = Integer.parseInt(cantidadStock) + Integer.parseInt(productoDevuelto);

            Cell celdaModificar = fila.createCell(6);
            celdaModificar.setCellValue(String.valueOf(cantidadFinal));

            try (OutputStream fileOut = new FileOutputStream(nameFile)) {
                libro.write(fileOut);
                libro.close();
            } catch (Exception e) {
            }

        } catch (IOException | EncryptedDocumentException e) {
        }

    }

}
