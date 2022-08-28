package paracreacionpool;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class Pool {
    
    public DataSource dataSource;
    
    
    public String db = "fundacion";
    public String url = "jdbc:mysql://localhost:8889/finempleado?characterEncoding=latin1";
    public String user = "root";
    public String pass = "root";
    
    
    
    //creamos el constructor
    
    public Pool(){
        inicializar();
    }
    
    
    //para obtener conexion a la base de datos
    
    private void inicializar(){
        
        BasicDataSource basicDataSource = new BasicDataSource();
        
        basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxActive(100); //imortante para extablecer numero maximo de conexiones
        
        dataSource = basicDataSource;
    }
}
