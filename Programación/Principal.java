
import java.io.File;
import java.io.FileOutputStream; 
import java.util.Scanner; 
import java.io.PrintWriter; 
import java.io.FileNotFoundException; 




public class Principal{
     public static void main(String[] arg){ 
   File f =new File (arg [0]);
     try{
         Scanner scan=new Scanner(f);
         FileOutputStream fo=new FileOutputStream(arg[1],true);
         PrintWriter pw=new PrintWriter (fo,true); 
             while(scan.hasNextLine()){
                 String linea=scan.nextLine ();
                  pw.println(linea); 
}
    scan.close();
    pw.close(); 

}catch(FileNotFoundException ex){
}


     }
}
