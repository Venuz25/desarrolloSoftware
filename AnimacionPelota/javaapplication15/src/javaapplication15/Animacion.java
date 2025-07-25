package javaapplication15;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animacion extends JPanel implements KeyListener{
    private Timer t;
    private double x, dx=1,y, dy=1, dr=1;
    private boolean izq,der,arriba,abajo;
    public Animacion(){
        this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(1500,600));
        x = 20;
        y = 20;
        addKeyListener(this);
        setFocusable(true);
        t = new Timer(15, new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                if(der){
                    x+=5;
                }
                if(izq){
                    x-=5;
                }
                if(abajo){
                    y+=5;
                }
                if(arriba){
                    y-=5;
                }
                        
            repaint();
            }
        });
        t.start();               
    }
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2=(Graphics2D)g;
    Ellipse2D eli=new Ellipse2D.Double(x,y,100,100);
    
   
        g2.setColor(Color.blue);
        g2.fill(eli);
            
}

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            der=true;
            izq=false;
            arriba=false;
            abajo=false;

        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            der=false;
            izq=true;
            arriba=false;
            abajo=false;

        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            der=false;
            izq=false;
            arriba=true;
            abajo=false;

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            der=false;
            izq=false;
            arriba=false;
            abajo=true;

        }
        if(e.getKeyCode() == KeyEvent.VK_E){
            der=false;
            izq=false;
            arriba=false;
            abajo=false;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}