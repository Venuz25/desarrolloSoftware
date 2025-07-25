/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guevara Badillo Areli Alejandra
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int e = 1;
        int pesos = 1;
        int opc = 0;
        String tipo = "pesos";
        
        System.out.println("1.Cambio de Visa");
        System.out.println("2.Datos estadisticos");
        System.out.println("3.Salir");
        System.out.println("Opcion:");
        opc = scan.nextInt();
        
        if(opc == 1){
           System.out.println("1.Dolar a peso");
            System.out.println("2.Euro a peso");
            System.out.println("3.Yen a peso");

            System.out.println("Opcion:");
            opc = scan.nextInt();

            if(opc == 1){
                e = 21;
                tipo = "dolares";
            }
            if(opc == 2){
                e = 23;
                tipo = "euros";
            }
            if(opc == 3){
                e = 2;
                tipo = "yenes";
            }

            System.out.println("Cantidad:");
            int cambio = scan.nextInt();

            pesos = cambio * e;

            System.out.println("Cambio: $" + pesos + " pesos");

            try {
               FileOutputStream f = new FileOutputStream("datos.txt",true);
               PrintWriter pw = new PrintWriter (f,true);

               pw.println(tipo + " " + cambio + " " + pesos);

               pw.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(opc == 2){
            File f1 = new File("datos.txt");
            Scanner s = new Scanner(f1);
            int total = 0;

            System.out.println("Tipo Cuantos Pesos");
            while (s.hasNext()){
                String tipos = s.next();
                int cuantos = s.nextInt();
                int peso = s.nextInt();
                total = total + peso;

                System.out.println(tipos + " " + cuantos + " " + peso);     
            }
            System.out.println("Total de pesos:"+total);
            s.close();
        }
        
    }   
}
