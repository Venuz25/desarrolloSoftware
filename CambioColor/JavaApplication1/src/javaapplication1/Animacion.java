/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

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
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animacion extends JPanel implements KeyListener{
    private Timer t;
    private double x, y;
    private boolean izq, der, arriba,abajo;
    private Rectangle2D recs[];
    private boolean [] dibuja;
    private Color color[];
    private int Red , Green, Blue;
   // private boolean colorear [];
    public Animacion(){
        color=new Color [5];
        //colorear= new boolean [5];
        dibuja= new boolean[5];
         for (int i=0; i<5; i++){
                dibuja[i]=true;
                //colorear[i]=true;
        } 
        
         for (int c=0; c<5; c++){
             //if (colorear[c]){
        Red = (int) (Math.random()*255);
        Green = (int) (Math.random()*255);
        Blue= (int) (Math.random()*255);
        color [c]= new Color (Red, Green, Blue);
         }
        addKeyListener(this);
        setFocusable(true);
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(1000,500));
        recs = new Rectangle2D[5];
        x = 10;
        y = 10;
        for(int i=0;i<5;i++){
            recs[i]=new Rectangle2D.Double(Math.random()*450, Math.random()*450, 50, 50);
        }
       
       
        t = new Timer(1, new ActionListener() {
            @Override
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
                 for (int i=0; i<5; i++){
                     if (recs[i].intersects(x, y, 50, 50))
                     dibuja[i]=false;
                    // colorear[i]=false;
                 }
                 
                
            repaint();
            }
        });
        t.start();               
    }
    @Override
    public void paintComponent(Graphics g){
        //for (int con=0;con<5;con++)
          //  Color c= new Color(Red[con], Green[con], Blue[con]);
    super.paintComponent(g);
    Graphics2D g2=(Graphics2D)g;
        
    
    Ellipse2D eli=new Ellipse2D.Double(x,y,50,50);

      for (int i=0; i<5; i++){
          if (dibuja[i]){
              g2.setColor(color[i]);
              g2.fill(recs[i]);}
              
      }
      
    
    g2.setColor(color[1]);
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
        if (e.getKeyCode()== KeyEvent.VK_SPACE){
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

