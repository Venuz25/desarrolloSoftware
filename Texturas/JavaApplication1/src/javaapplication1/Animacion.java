/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animacion extends JPanel implements KeyListener{
    private double x, y;
    private boolean izq, der, arriba,abajo;
    private boolean [] dibuja;
    private int Red , Green, Blue;
    private int puntaje;
    private Timer t;
    private Image img;
    private Rectangle2D recs[];
    private Color color[];
    private TexturePaint tex,text;
    BufferedImage im;
    BufferedImage [] ima;
    
    
    public Animacion(){
        
        try {
            img = ImageIO.read(new File("howl_by_nishihiku_deyacik-pre.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        im = null;
        try {
            im = ImageIO.read(new File("1000156.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        color = new Color [5];
        dibuja = new boolean[5];
        ima = new BufferedImage[5];
        
        for (int i = 0; i < 5; i++){
                dibuja[i] = true;
        } 
        
        for (int i = 0; i < 5; i++){
            try {
                ima[i] = ImageIO.read(new File("recs.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (int c = 0; c < 5; c++){   
            Red = (int) (Math.random()*255);
            Green = (int) (Math.random()*255);
            Blue= (int) (Math.random()*255);
            color [c]= new Color (Red, Green, Blue);
        }
        
        addKeyListener(this);
        setFocusable(true);
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(1000,500));
        recs = new Rectangle2D[5];
        x = 10;
        y = 10;
        
        for(int i = 0; i < 5; i++){
            recs[i]=new Rectangle2D.Double(Math.random()*450, Math.random()*450, 50, 50);
            text = new TexturePaint(ima[i], new Rectangle2D.Double(x,y,100,80));
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
                
                tex = new TexturePaint(im, new Rectangle2D.Double(x,y,100,80));
                             
                puntaje = 0;
                for (int i = 0; i < 5; i++){
                    if (recs[i].intersects(x, y, 50, 50))
                        dibuja[i] = false;
                     
                    if(dibuja[i] == false)
                        puntaje = puntaje+10;                     
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
        Ellipse2D eli=new Ellipse2D.Double(x,y,50,50);

        g2.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        g2.setPaint(tex);
        g2.fill(eli);
        
        g2.setPaint(text);

        for (int i=0; i<5; i++){
            if (dibuja[i]){               
                g2.fill(recs[i]);
            }        
        }

       Font f = new Font("Times New Roman", Font.BOLD,20);
       g2.setFont(f);
       g2.setColor(Color.black);
       g2.drawString("Puntaje:" + puntaje, 290, 400);   
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

