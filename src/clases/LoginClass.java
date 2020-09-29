
package clases;

import java.awt.HeadlessException;
import java.io.*;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import ventanas.Administrador;
import ventanas.Login;
import ventanas.PrecioDolar;

/**
 *
 * @author luism
 */
public class LoginClass {
    
    private String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();
    private int id;
    
    public void login(){
    
        try {
            Workbook libro = WorkbookFactory.create(new FileInputStream(nameFile));
            String nombreHoja = libro.getSheetName(0);
            Sheet hoja = libro.getSheet(nombreHoja);
            String user;
            String password;
            String password2 = Login.getPassword();
            String[] datos;
            
            Iterator<Row> rowIterator = hoja.iterator();
            String username = Login.getUsername();
            while (rowIterator.hasNext()) {
                Row fila = rowIterator.next();
                Cell celda = fila.getCell(3);
                user = celda.getStringCellValue();

                if (user.equals(username)) {
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
            password = datos[4];
            if (password.equals(password2)){
                new Administrador().setVisible(true);
                new PrecioDolar().setVisible(true);
                new Login().dispose();
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuario ó contraseña incorrecta");
                
            }
            
        } catch (HeadlessException | IOException | EncryptedDocumentException e) {
        }
    }
    
}
