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
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animacion extends JPanel {
   private Shape eli;
   private AffineTransform at,at2;
   private Timer t;
   private double x,y;
   private boolean crece,decrece;
            
    public Animacion (){
        setFocusable(true);
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(500,500));
        
        x = 225;
        y = 225; 
        
        crece = true;
        decrece = false;

        eli = new Ellipse2D.Double(225, 225, 50, 50);
        at = new AffineTransform();
        at2 = new AffineTransform();
           
        t = new Timer(50, new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
   
                if(crece){
                    at.setToScale(1.2,1.2);             
                    at2.setToTranslation(-50,-50); 

                    if(eli.getBounds2D().getWidth() >= 480) {
                        crece = false;
                        decrece=true;
                    }
                }

                if(decrece){
                    at.setToScale(0.8,0.8);            
                    at2.setToTranslation(50,50);
                    
                    if(eli.getBounds2D().getWidth() <= 50){
                        crece = true;
                        decrece=false;
                    }
                }
                
                eli = at.createTransformedShape(eli);  
                eli = at2.createTransformedShape(eli);
                
                repaint();            
            }
            
        });

        t.start();  
    }
    
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    
    g2.setColor(Color.white);
    g2.fill(eli);  
  
    }
   
}

