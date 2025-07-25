package javaapplication1;

import java.io.File;
import java.io.FileNotFoundExeption;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
try{
int suma=0;
File f=new File("documento.txt");
float p=0;
int menor=16;
String nom=""; 
Scanner scan=new Scanner(f);
 while(scan.hasNext()){ //siempre se coloca while  
int e=scan.nextInt();
String n= scan.next();
double pe=scan.nextDouble();
suma=suma+e;
if (e<menor){
menor=e;
nom=n;
}

}
scan.close();
} catch(FileNotFoundExeption ex){
}
p=(float)sum/4;
System.out.println("El promedio de edad:"+p);

System.out.println("Elperro con menor edad es;" + nom + "y tiene" + menor + "años de edad");

/*System.out.println(scan.next());
System.out.println(scan.nextInt());
System.out.println (scan.nextDouble()); */
    }

}   

