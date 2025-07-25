
package clase5;

import javax.swing.JFrame;

public class Clase5 {
    
    public static void main(String[] args) {
   JFrame w =  new JFrame (" ventana");
   w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   Anima a = new Anima();
   w.add(a);
   w.pack();
   w.setVisible(true);
    }

    
    
}
