package javaapplication4;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f=newFile("datos.txt");
        Scanner scan=newScanner(f);
        int par1=0;
        int par2=0;
        int par3=0;
        int prom1=0;
        int prom2=0;
        int prom3=0;
        String nombre;
    }
    while(scan.hasNext()){
        par1=scan.nextInt();
        par2=scan.nextInt();
        par3=scan.nextInt();
        
        
    }

    private static File newFile(String datostxt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Scanner newScanner(File f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
