/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.swing.JFrame;

public class JavaApplication1 {

    public static void main(String[] args) {
        JFrame w = new JFrame("Primera Ventana");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Animacion a = new Animacion();
        w.add(a);
        w.pack();
        w.setVisible(true);
    }
    
}
