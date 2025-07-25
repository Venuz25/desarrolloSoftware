package driver;

import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.Scanner;

/**                ***   ***
 *                ***** *****
 *               *************
 *                ***********
 *                 *********
 *                  *******
 *                   *****
 *                    ***
 * 
 * @author Guevara Areli
 */
public class Driver {

    public static void main(String[] args) {
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
        
    }
    
}
