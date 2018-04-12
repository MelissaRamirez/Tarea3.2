/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nelson
 */
public class UseColor extends JPanel{

    // constructor
    public UseColor() {
        this.setPreferredSize(new Dimension(800, 600));
    }
    
    // sera el metodo encargado de realizar el pintado en pantalla
    // recibe como parametro un atributo de tipo Graphics
    private void draw(Graphics g){        
        
        // figuras con relleno
        g.setColor(Color.red);
        g.fillRect(20, 140, 100, 50);
        
        
        g.setColor(Color.blue);
        g.fillOval(20, 200, 100, 100);
        
        Color myColor = new Color(200, 200, 200);
        g.setColor(myColor);
        g.fillRoundRect(20, 330, 100, 100, 20, 20);               
        
    } // draw
    
    // es necesario sobreescribir el metodo paintComponent para poder pintar
    // en pantalla utilizando el objeto Graphics 
   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // se llama al metodo draw
        draw(g);

    }
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame("BasicGraphics");
        
        window.setContentPane(new UseColor());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();//compress to all inner components
        
        window.setResizable(false);
        window.setLocation(150, 100);
        window.setVisible(true);        
    }
    
} // fin clase
