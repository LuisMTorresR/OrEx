package clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import ventanas.Caja;
import ventanas.PrecioDolar;

/**
 *
 * @author luism
 */
public class CajaClass {

    private String nameFile = BaseDeDatos.getNOMBRE_ARCHIVO();
    private float dolar = PrecioDolar.getDolar();
    private static String codigo;
    private String nombre;
    private String marca;
    private String porcentaje;
    private String precioUnitDoll;
    private static String cantidadEnStock;
    private String cantidadAComprar;
    private Date date = BaseDeDatos.getDate();
    private static String[] datosDelProductoCaja;
    private static String[] datosDelArticuloVentas;

    public void recuperarDatos() {

        codigo = Caja.getCodigo();
        new Buscar().buscarCodigo();
        String[] datos = Buscar.getDatos();

        nombre = datos[1];
        marca = datos[2];
        porcentaje = datos[4];
        precioUnitDoll = datos[5];
        cantidadEnStock = datos[6];
    }

    public void llenadoTablaCaja() {

        recuperarDatos();

        //Cargar producto en la tabla
        cantidadAComprar = Caja.getCantidadAComprar();
        float cantidadAComprarNum = Float.parseFloat(cantidadAComprar);
        float precioUnitDollNum = Float.parseFloat(precioUnitDoll);
        float precioUnitBsNum = precioUnitDollNum * dolar;
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaDeVenta = fecha.format(date);

        datosDelProductoCaja = new String[8];
        datosDelProductoCaja[0] = nombre;
        datosDelProductoCaja[1] = marca;
        datosDelProductoCaja[2] = cantidadAComprar;
        datosDelProductoCaja[3] = precioUnitDoll;
        datosDelProductoCaja[4] = String.valueOf(precioUnitDollNum * cantidadAComprarNum);
        datosDelProductoCaja[5] = String.valueOf((int) (precioUnitDollNum * dolar));
        datosDelProductoCaja[6] = String.valueOf((int)(precioUnitBsNum * cantidadAComprarNum));
        datosDelProductoCaja[7] = fechaDeVenta;
    }

    public void llenadoHojaDeVentas(){

        recuperarDatos();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaDeVenta = fecha.format(date);
        String metodoDePago = Caja.getMetodoDePago();
        cantidadAComprar = Caja.getCantidadAComprar();
        float cantidadAComprarNum = Float.parseFloat(cantidadAComprar);
        float precioUnitDollNum = Float.parseFloat(precioUnitDoll);
        String precioUnitBs = String.valueOf(precioUnitDollNum * dolar);
        float precioUnitBsNum = Float.parseFloat(precioUnitBs);
        float porcentajeNum = Float.parseFloat(porcentaje);

        datosDelArticuloVentas = new String[11];
        datosDelArticuloVentas[0] = nombre;
        datosDelArticuloVentas[1] = marca;
        datosDelArticuloVentas[2] = cantidadAComprar;
        datosDelArticuloVentas[3] = precioUnitDoll;
        datosDelArticuloVentas[4] = String.valueOf(precioUnitDollNum * cantidadAComprarNum);
        datosDelArticuloVentas[5] = String.valueOf(Float.parseFloat(datosDelArticuloVentas[4]) * porcentajeNum / 100);
        datosDelArticuloVentas[6] = String.valueOf((int) (precioUnitDollNum * dolar));
        datosDelArticuloVentas[7] = String.valueOf((int)(precioUnitBsNum  * cantidadAComprarNum));
        datosDelArticuloVentas[8] = String.valueOf((int)(Float.parseFloat(datosDelArticuloVentas[5]) * dolar));
        datosDelArticuloVentas[9] = fechaDeVenta;
        datosDelArticuloVentas[10] = metodoDePago;


    }

    public static String[] getDatosDelProductoCaja() {
        return datosDelProductoCaja;
    }

    public static String[] getDatosDelArticuloVentas() {
        return datosDelArticuloVentas;
    }

    public static String getCantidadEnStock() {
        return cantidadEnStock;
    }

    public static String getCodigo() {
        return codigo;
    }

}
