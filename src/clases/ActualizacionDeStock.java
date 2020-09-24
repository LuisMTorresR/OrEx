package clases;

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import ventanas.Caja;

/**
 *
 * @author luism
 */
public class ActualizacionDeStock {

    private DefaultTableModel tableModel;

    public ActualizacionDeStock() {

        String[][] datos;
        datos = null;
        tableModel = Caja.getTableModel();

        for (int i = 0; i < tableModel.getRowCount(); i++) {
                System.out.println("i = " + i);
            
        }
    }

}
