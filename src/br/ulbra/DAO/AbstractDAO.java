
package br.ulbra.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AbstractDAO {
   
    private static final String DRIVER = "com.mysql.jdbc.Driver";//Driver jdbc 
    private static final String URL = "Jdbc:mysql://local host: 3306/crudgamevault"; //url do Bd
    private static final String USER = "root"; //login banco
    private static final String PASS = " "; //senha do banco
    
    public static Connection getConnection() throws SQLException{
        try{
          Class.forName(DRIVER);
          return DriverManager.getConnection(URL,USER,PASS); 
        } catch (ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro: "+ ex.getMessage());
            return null;
        }
    }   
}
