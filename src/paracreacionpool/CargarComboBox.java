package paracreacionpool;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author josueemilian
 */
public class CargarComboBox {

    Pool metodospool = new Pool();

    public void consultarEmpleos(JComboBox cbox_Empleos) {

        // Creamos objeto tipo Connection
        java.sql.Connection conectar = null; //permite administrar o guardar la conexion establecida dB

        //Creamos la Consulta SQL
        String SSQL = "SELECT nombre, salario FROM finempleado ORDER BY nombre ASC";

        //Bloque try-catch-finally
        try {

            //Establecemos conexion con la BD
            conectar = metodospool.dataSource.getConnection(); //get.conection nos permite la conexion a la db

            //Preparar la consulta SQL
            java.sql.PreparedStatement pst = conectar.prepareStatement(SSQL); //Linea importante (java.sql.PreparedStatement)
            
            //Ejecutamos la consulta
            ResultSet result = pst.executeQuery();
            
            //Llenamos nuestro ComboBox
            cbox_Empleos.addItem("Seleccione una opcion"); //item pretederminado el cual se muestra de primero simepre
            
            while(result.next()){ // .next recorre todos los resultados guardados en el objeto
                
                //Linea importante para concatenar dos valores
                cbox_Empleos.addItem(result.getString("nombre")+" - Salario: "+result.getString("salario"));
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            
        } finally {
            
            
            if (conectar!=null) { 
                
                try {
                //verificamos si se establecio conexion a la DB
                conectar.close();
                
                } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
                }
                
            }
        }
    }
}
