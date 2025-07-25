
package clase5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Anima extends JPanel{
    private Timer t;
    private double x, dx=5;
    public Anima(){
        this.setBackground(Color.green);
        this.setPreferredSize(new Dimension(400,300));
        x = 20;
        t = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            x+=dx;    
 
            
            if (x >= 350)
                dx=-1*dx;
             if (x <= 0)
                dx=-1*dx;
            repaint();
            }
        });
        t.start();
        
        
    }
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2=(Graphics2D)g;
    Ellipse2D eli=new Ellipse2D.Double(x,50,150,150);

        g2.setColor(Color.black);
        g2.fill(eli);
            
}
    
}
