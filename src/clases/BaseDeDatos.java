package clases;

import java.io.*;
import javax.swing.*;
import org.apache.poi.hssf.usermodel.*;
import ventanas.VisualTablaDeDatos;

public class BaseDeDatos {

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

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public HSSFWorkbook getLibro() {
        return libro;
    }

    public void setLibro(HSSFWorkbook libro) {
        this.libro = libro;
    }

    public HSSFSheet getHoja1() {
        return hoja1;
    }

    public void setHoja1(HSSFSheet hoja1) {
        this.hoja1 = hoja1;
    }

    public HSSFSheet getHoja2() {
        return hoja2;
    }

    public void setHoja2(HSSFSheet hoja2) {
        this.hoja2 = hoja2;
    }

    public HSSFSheet getHoja3() {
        return hoja3;
    }

    public void setHoja3(HSSFSheet hoja3) {
        this.hoja3 = hoja3;
    }

    public HSSFSheet getHoja4() {
        return hoja4;
    }

    public void setHoja4(HSSFSheet hoja4) {
        this.hoja4 = hoja4;
    }

    public HSSFSheet getHoja5() {
        return hoja5;
    }

    public void setHoja5(HSSFSheet hoja5) {
        this.hoja5 = hoja5;
    }
    
}