package javaapplication10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication10 {

 
    public static void main(String[] args) {
            try { 
                File f = new File("datos.txt");
                Scanner scan = new Scanner (f);
                int m = 0, n = 0;
                while(scan.hasNext()){
                n = scan.nextInt();
                if(n > m){
                    m = n;
                }
            }
                System.out.println(m);
                scan.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JavaApplication10.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

