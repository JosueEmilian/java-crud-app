package conexionparadatosempleados;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * cLASE PARA LA CONEXION TABLA DATOS EMPLEADOS
 */
public class ConexionSQLDatosEmpleados {

    Connection conectar = null;

    //nuevo metodo
    public Connection conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/datosempleadosumg?characterEncoding=latin1", "root", "root");

            //JOptionPane.showMessageDialog(null, "Conexion Exitosa!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion: " + e.getMessage());
        }

        return conectar;
    }
}
