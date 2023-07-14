package codes;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

//public class BDconect {
//
//    public static Connection getConnection() {
//        System.out.println(" getConnection started");
//        Connection conn = null;
//
//        String db = "ak47-s";
//        String user = "root";
//        String password = "";
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = (Connection) DriverManager.getConnection("jdbc:MySQL://localhost:3306/bookshop/ak47-s","root","");
//            System.out.println("S=======db Connecting======");
//
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("E=======db Connecting======" + e);
//        }
//
//        return conn;
//    }
//
//    public static TableModel resultSetToTableModel(ResultSet rs) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}

public class BDconect {
    
    
    
   public static java.sql.Connection getConnection(){
       
   java.sql.Connection conn = null;
         
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ak47-s","root","");
        
            }
        catch(Exception e){
            System.out.println(e);
 
        }
      return conn;  
}
}
