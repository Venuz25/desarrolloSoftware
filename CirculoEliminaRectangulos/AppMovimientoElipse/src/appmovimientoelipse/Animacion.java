package appmovimientoelipse;

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
    private double x,y;
    private boolean izq, der, arriba, abajo;
    private Rectangle2D recs[];
    private boolean rec0,rec1,rec2,rec3,rec4;
    
            
    public Animacion (){
        x = 10;
        y = 10;
        rec0 = true;
        rec1 = true;
        rec2 = true;
        rec3 = true;
        rec4 = true;
        
        recs = new Rectangle2D[5];
        for(int i = 0; i < 5; i++){
            recs[i] = new Rectangle2D.Double(Math.random()*450, Math.random()*350,50,50);
        }
        
        addKeyListener(this);
        setFocusable(true);
        setPreferredSize(new Dimension(500,400));
        setBackground(Color.BLACK);
        Timer t = new Timer(50, new ActionListener(){  /*cada cuantos milisegundos se quiere la señal*/       
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
                
                if(recs[0].contains(x,y)){
                    rec0 = false;
                } 
                if(recs[1].contains(x,y)){
                    rec1 = false;
                } 
                if(recs[2].contains(x,y)){
                    rec2 = false;
                } 
                if(recs[3].contains(x,y)){
                    rec3 = false;
                } 
                if(recs[4].contains(x,y)){
                    rec4 = false;
                } 
            }
        }); 
        t.start();
        
        
        
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
            izq=true;
            der=false;
            arriba=false;
            abajo=false; 
        }    
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            der=false;
            izq=false;
            arriba=false;
            abajo=true; 
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            izq=false;
            der=false;
            arriba=true;
            abajo=false; 
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            izq=false;
            der=false;
            arriba=false;
            abajo=false; 
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    Ellipse2D eli = new Ellipse2D.Double(x,y,40,40);   /*x,y,ancho, alto*/
    g2.setColor(Color.white);/*Cambiar el color de relleno*/
    g2.fill(eli);  /*Rellena la figura=fill, draw=dibuja la figura*/
    
    g2.setColor(Color.CYAN); /*color rectangulos*/    
    
    if(rec0){
        g2.fill(recs[0]);
    }
    if(rec1){
        g2.fill(recs[1]);
    }
    if(rec2){
        g2.fill(recs[2]);
    }
    if(rec3){
        g2.fill(recs[3]);
    }
    if(rec4){
        g2.fill(recs[4]);
    }
       
   
    
    
    }
    
}

