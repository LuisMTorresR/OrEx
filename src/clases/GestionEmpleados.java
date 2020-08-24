package clases;

import ventanas.RegistroDeEmpleados;

/**
 *
 * @author luism
 */
public class GestionEmpleados {

    private String nombre = "";
    private String apellido = "";
    private String email = "";
    private String username = "";
    private String password = "";
    private String telefono = "";
    private String direccion = "";
    private RegistroDeEmpleados data = new RegistroDeEmpleados();
    private static String datos[];
    public void registroEmpleados(){
        nombre = data.getTxtNombre().toString();
        apellido = data.getTxtApellido().toString();
        email = data.getTxtEmail().toString();
        username = data.getTxtUsername().toString();
        password = data.getTxtPassword().toString();
        telefono = data.getTxtTelefono().toString();
        direccion = data.getTxtDireccion().toString();
        
        datos[0] = nombre;
        datos[1] = apellido;
        datos[2] = email;
        datos[3] = username;
        datos[4] = password;
        datos[5] = telefono;
        datos[6] = direccion;
    }

    public String[] getDatos() {
        return datos;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }
    
}
