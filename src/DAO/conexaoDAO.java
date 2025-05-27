 package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
import javax.swing.JOptionPane;


public class conexaoDAO {
    public Connection conectaBD() throws ClassNotFoundException{
    Connection conn = null ; 
    
             Class.forName("com.mysql.jdbc.Driver");

        try {
            String url = "jdbc:mysql://mysql-3fad72ed-projetoiia.l.aivencloud.com:21817/defaultdb?useSSL=true&user=avnadmin&password=AVNS_hiGZCucMJwbqGscPVod";
            conn = DriverManager.getConnection(url);
                   
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "conexaoDAO" + erro.getMessage());
        }
        return conn;
}
            
}
