package JavaApplication2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication2 {

    public static void main(String[] args) {
        String res = "";
        double pr = 0;
        res = getPetName(new File ("documento.txt"));
        System.out.println("El perro con menor edad es: " + res);
        pr = getPromedio(new File("documento.txt"));
        System.out.println("El promedio de edad es: " + pr);
    }
    
    public static String getPetName(File x){
        try {
            Scanner scan = new Scanner(x);
            String nm = "", nm2 = "";
            double peso = 0;
            int edad = 0, menor = 100;
            while(scan.hasNext()){
                nm = scan.next();
                edad = scan.nextInt();
                peso = scan.nextDouble();
                if(edad<menor){
                    menor = edad;
                    nm2 = nm;
                }
            }
            scan.close();
            return nm2;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public static double getPromedio(File x){
            double prom = 0;
        try {
            Scanner scan = new Scanner(x);
            String nm = "", nm2 = "";
            double peso = 0;
            int edad = 0, suma = 0;
            while(scan.hasNext()){
                nm = scan.next();
                edad = scan.nextInt();
                peso = scan.nextDouble();
                suma = suma + edad;
            }
            scan.close();
            prom = (double)suma/2;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prom;
    }
}