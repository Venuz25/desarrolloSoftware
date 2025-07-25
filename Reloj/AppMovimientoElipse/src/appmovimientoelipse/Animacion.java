package appmovimientoelipse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animacion extends JPanel {
   private Shape rec1, rec2;
   private AffineTransform at;
   private Timer t,t2;
            
    public Animacion (){
        setFocusable(true);
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.BLACK);
        
        at = new AffineTransform();
        rec1 = new Rectangle2D.Double(250, 250, 5, 150);
        rec2 = new Rectangle2D.Double(250, 250, 10, 100);
        
        Timer t = new Timer(20, new ActionListener(){      
            public void actionPerformed(ActionEvent e) {
                
                at.setToRotation(Math.toRadians(10), 253, 250);
                rec1 = at.createTransformedShape(rec1);
                
            repaint();    
            }
        }); 
        t.start();
        
        Timer t2 = new Timer(100, new ActionListener(){      
            public void actionPerformed(ActionEvent e) {
                
                at.setToRotation(Math.toRadians(10), 255, 250);
                rec2 = at.createTransformedShape(rec2);
                
            repaint();    
            }
        }); 
        t2.start();    
    }
    
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    
    Ellipse2D eli = new Ellipse2D.Double(50,50,400,400);   
  
    g2.setColor(Color.white);
    g2.fill(eli);  
    
    g2.setColor(Color.black);
    g2.fill(rec1);
    g2.fill(rec2);
  
    }
   
}

