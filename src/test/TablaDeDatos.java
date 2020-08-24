package test;

import ventanas.VisualTablaDeDatos;
import java.io.*;
import javax.swing.*;
import org.apache.poi.hssf.usermodel.*;

public class TablaDeDatos {

    private JTable tabla = new VisualTablaDeDatos().getTabla();
    private final String nombreFichero = "baseDeDatos.xls"; //nombre del archivo
    private HSSFWorkbook libro = null;
    private HSSFSheet hoja1 = null;
    private HSSFSheet hoja2 = null;
    private HSSFSheet hoja3 = null;
    private HSSFSheet hoja4 = null;
    private HSSFSheet hoja5 = null;
    private File ficheroXls;
    private FileOutputStream fichero;

    public TablaDeDatos() {

    }

    public void crearBaseDeDatos() {
        //Verificamos si el archivo existe
        //De no existir se crea
        try {
            ficheroXls = new File(nombreFichero);

            if (!ficheroXls.isFile()) {
                fichero = new FileOutputStream(nombreFichero);
                libro = new HSSFWorkbook();
                hoja1 = libro.createSheet("Listado de Empleados");
                hoja2 = libro.createSheet("Listado de Productos");
                hoja3 = libro.createSheet("Control Ventas Diarias");
                hoja4 = libro.createSheet("Control Ventas Semanales");
                hoja5 = libro.createSheet("Control Ventas Mensaules");
            }else{
                JOptionPane.showMessageDialog(null, "Ya existe una base de datos");
            }

        } catch (FileNotFoundException e) {
        }
    }

    public void llenadoBaseDeDatos() throws IOException {

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            HSSFRow fila = hoja1.createRow(i);
            if (i == 0) {
                for (int j = 0; j < tabla.getColumnCount() - 1; j++) {
                    HSSFCell celda = fila.createCell(j);
                    celda.setCellValue(new HSSFRichTextString(tabla.getColumnModel().getColumn(j).getHeaderValue().toString()));
                }
            } else {
                for (int j = 0; j < tabla.getColumnCount() - 1; j++) {
                    HSSFCell celda = fila.createCell(j);
                    if (tabla.getValueAt(i, j) != null) {
                        celda.setCellValue(new HSSFRichTextString(tabla.getValueAt(i, j).toString()));
                    }
                }

            }
        }
        
        libro.write(fichero);
        libro.close();
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

}
