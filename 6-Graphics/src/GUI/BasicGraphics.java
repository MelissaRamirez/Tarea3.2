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
public class BasicGraphics extends JPanel{

    // constructor
    public BasicGraphics() {
        this.setPreferredSize(new Dimension(800, 600));        
    }
    
    // sera el metodo encargado de realizar el pintado en pantalla
    // recibe como parametro un atributo de tipo Graphics
    private void draw(Graphics g){
        //primitivas haciendo uso de Graphics
        g.drawLine(20, 20, 120, 20);
        
        g.drawRect(20, 40, 100, 50);
        
        g.drawOval(20, 100, 100, 100);        
        
        // figuras con relleno
        g.fillRect(20, 240, 100, 50);
        g.fillOval(20, 300, 100, 100);
        g.fillRoundRect(20, 430, 100, 100, 20, 20);
        
        // polígono relleno con objeto Polygon
        Polygon poligono2 = new Polygon();
        poligono2.addPoint( 165, 135 );
        poligono2.addPoint( 175, 150 );
        poligono2.addPoint( 270, 200 );
        poligono2.addPoint( 200, 220 );
        poligono2.addPoint( 130, 180 );
        g.fillPolygon( poligono2);        

        
    } // draw
    
    // es necesario sobreescribir el metodo paintComponent para poder pintar
    // en pantalla utilizando el objeto Graphics 
   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // se llama al meto draw
        draw(g);

    }
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame("BasicGraphics");
        ventana.setContentPane(new BasicGraphics());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        
        ventana.setResizable(false);
        ventana.setLocation(150, 100);
        ventana.setVisible(true);        
    }
    
} // fin clase
