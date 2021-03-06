package clases;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseDeDatos {

    private static Date date = new Date();
    private static final String NOMBRE_ARCHIVO = "BaseDeDatos.xlsx";

    public void crearBaseDeDatos() throws IOException {
        String nameHoja1 = "Emepleados";
        String nameHoja2 = "Productos";
        String nameHoja3 = "VentasDiarias";
        String nameHoja4 = "VentasMensuales";
        //Verificamos si el archivo existe
        //De no existir se crea
        File ficheroXls = new File(NOMBRE_ARCHIVO);
        if (!ficheroXls.isFile()) {
            XSSFWorkbook libro = new XSSFWorkbook();
            XSSFSheet hoja1 = libro.createSheet(nameHoja1);
            String[] cabecero = new String[]{"Nombre", "Apellido", "Email", "Username", "Password", "Categoria", "Telefono", "Direccion"};
            XSSFRow fila = hoja1.createRow(0);
            for (int i = 0; i < cabecero.length; i++) {
                if (fila.getRowNum() == 0) {
                    XSSFCell celda = fila.createCell(i);
                    celda.setCellValue(cabecero[i]);
                }
            }
            XSSFSheet hoja2 = libro.createSheet(nameHoja2);
            String[] cabecero2 = new String[]{"Codigo", "Nombre", "Marca", "Precio de Compra", "Porcentaje", "Precio de Venta $", "Cantidad"};
            XSSFRow fila2 = hoja2.createRow(0);
            for (int i = 0; i < cabecero2.length; i++) {
                if (fila2.getRowNum() == 0) {
                    XSSFCell celda = fila2.createCell(i);
                    celda.setCellValue(cabecero2[i]);
                }
            }
            XSSFSheet hoja3 = libro.createSheet(nameHoja3);
            String[] cabecero3 = new String[]{"Nombre", "Marca", "Cantidad", "PrecioUnt $", "Total $", "Ganancia $", "PrecioUnit Bs", "Total Bs", "Ganancia Bs", "Fecha", "MetDePago"};
            XSSFRow fila3 = hoja3.createRow(0);
            for (int i = 0; i < cabecero3.length; i++) {
                if (fila3.getRowNum() == 0) {
                    XSSFCell celda = fila3.createCell(i);
                    celda.setCellValue(cabecero3[i]);
                }
            }
            XSSFSheet hoja4 = libro.createSheet(nameHoja4);
            String[] cabecero4 = new String[]{"Nombre", "Marca", "Cantidad", "PrecioUnt $", "Total $", "Ganancia $", "PrecioUnit Bs", "Total Bs", "Ganancia Bs", "Fecha", "MetDePago"};
            XSSFRow fila4 = hoja4.createRow(0);
            for (int i = 0; i < cabecero4.length; i++) {
                if (fila4.getRowNum() == 0) {
                    XSSFCell celda = fila4.createCell(i);
                    celda.setCellValue(cabecero4[i]);
                }
            }

            try (OutputStream fileOut = new FileOutputStream(NOMBRE_ARCHIVO)) {
//                Path path = Paths.get(NOMBRE_ARCHIVO);
//                Boolean hidden = (Boolean) Files.getAttribute(path, "dos:hidden", LinkOption.NOFOLLOW_LINKS);
//                if (hidden != null && !hidden) {
//                    Files.setAttribute(path, "dos:hidden", Boolean.TRUE, LinkOption.NOFOLLOW_LINKS);
                libro.write(fileOut);
                JOptionPane.showMessageDialog(null, "Se creo la base de datos con exito.");
//                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al crear la base de datos " + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una base de datos!");
        }
    }

    public void removeRow(Sheet sheet, int rowIndex) {
        int lastRowNum = sheet.getLastRowNum();
        if (rowIndex >= 0 && rowIndex < lastRowNum) {
            sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
        }
        if (rowIndex == lastRowNum) {
            Row removingRow = sheet.getRow(rowIndex);
            if (removingRow != null) {
                sheet.removeRow(removingRow);
            }
        }
    }

    public void refreshVentasDiarias() {

        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaDiaria = fecha.format(date);
        try {

            Workbook libro = WorkbookFactory.create(new FileInputStream(NOMBRE_ARCHIVO));
            String nombreHoja = libro.getSheetName(2);
            Sheet hoja = libro.getSheet(nombreHoja);

            int ultimaFila = hoja.getLastRowNum();
            Row fila = hoja.getRow(ultimaFila);
            int ultimaCelda = fila.getLastCellNum() - 1;
            Cell celdaFecha = fila.getCell(ultimaCelda);
            String fechaAnterior = celdaFecha.getStringCellValue();

            if (fechaDiaria.equals(fechaAnterior) == false) {

                for (int i = 1; i <= ultimaFila; ultimaFila--) {
                    removeRow(hoja, ultimaFila);
                }
            }
            try (OutputStream fileOut = new FileOutputStream(NOMBRE_ARCHIVO)) {
                libro.write(fileOut);
                libro.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No existe una base de datos" + ex);
            }

        } catch (Exception e) {
        }

    }

    public static String getNOMBRE_ARCHIVO() {
        return NOMBRE_ARCHIVO;
    }

    public static Date getDate() {
        return date;
    }

}
