package driver;

import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.Scanner;

/**                **   **
 *                **** ****
 *               ***********
 *                *********
 *                 *******
 *                  *****
 *                   ***
 *                    *
 * @author Guevara Areli
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in); 
        
        System.out.println("Dame el nombre del producto:");
        String nom = sn.next();
        
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/dataproductos?serverTimezone=UTC","root","");
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery("select Cantidad from productos where Nombre='"+nom+"'");
                    
            if(rs.next()){                                                
                
                    System.out.println("Cantidad en stock: "+rs.getInt("Cantidad"));                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
