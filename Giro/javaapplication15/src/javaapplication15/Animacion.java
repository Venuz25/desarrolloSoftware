package javaapplication15;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Animacion extends JPanel implements KeyListener{
    private double x;
    private boolean izq,der;
    private Shape cir1, cir2;
    private AffineTransform at;
    private boolean ele, ele2;
    private Graphics2D g2;
            
    public Animacion(){
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(500,500));
        
        at = new AffineTransform();
        cir1 = new Ellipse2D.Double(150,250,50,50);
        cir2 = new Ellipse2D.Double(250,250,50,50);
        ele = false;
        ele2 = false;
        
        addKeyListener(this);
        setFocusable(true);
                                               
    }
    
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    g2=(Graphics2D)g;
    
    
        g2.setColor(Color.GRAY);
        g2.fill(cir1);
        
        g2.setColor(Color.GRAY);
        g2.fill(cir2);
        
        if(ele==true){
            g2.setColor(Color.cyan);
            g2.fill(cir1);
            g2.setColor(Color.GRAY);
            g2.fill(cir2);   

        }
        if(ele2==true){
            g2.setColor(Color.cyan);
            g2.fill(cir2);
            g2.setColor(Color.GRAY);
            g2.fill(cir1);   

        }
        
}

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_1){
            ele = true;
            ele2 = false;
            repaint();
        }
        
        if(ele==true){
             if(e.getKeyCode() == KeyEvent.VK_LEFT){
                at.setToTranslation(-5, 0);
                cir1 = at.createTransformedShape(cir1);
                repaint();
            }
            
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                at.setToTranslation(5, 0);
                cir1 = at.createTransformedShape(cir1);
                repaint();
            }
        }
           
        if(e.getKeyCode() == KeyEvent.VK_2){
            ele2 = true;
            ele = false;
            repaint();
        }
        
        if(ele2==true){
             if(e.getKeyCode() == KeyEvent.VK_LEFT){
                at.setToTranslation(-5, 0);
                cir2 = at.createTransformedShape(cir2);
                repaint();
            }
            
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                at.setToTranslation(5, 0);
                cir2 = at.createTransformedShape(cir2);
                repaint();
            }
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}