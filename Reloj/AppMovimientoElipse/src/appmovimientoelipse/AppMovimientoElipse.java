package appmovimientoelipse;

import javax.swing.JFrame;

public class AppMovimientoElipse {

    public static void main(String[] args) {
       JFrame Ven = new JFrame("Mi primer ventana");
       Ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Animacion ani = new Animacion();
       Ven.add(ani);
       Ven.pack();/*se ajusta al tamaño dado en la clase*/
       Ven.setVisible(true);
       
     
    }
    
}
