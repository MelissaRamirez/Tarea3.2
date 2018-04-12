
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class LineExample extends JPanel {

    //controla la cantidad de lineas
    int count;
   
    public LineExample() {
        this.setPreferredSize(new Dimension(1000, 700));
        this.setBackground(Color.BLACK);
    } // constructor

    private void draw(Graphics g) {
        // dibujar los ejes del plano cartesiano
               
           //determina cuantas lineas pintar
            count++;
           if(count==3000){
               stop();
           }
           
           System.out.println(count);
        int color = 0;
        int x0 = (int) (Math.random() * 100)*10;
        int y0 = (int) (Math.random() * 100)*10;
        int x1 = (int) (Math.random() * 100)*10;
        int y1 = (int) (Math.random() * 100)*10;

        color = (int) (Math.random() * 200) * 10;

       

        if (color > 500 && color < 1000) {
            g.setColor(Color.red);
        } else if (color > 1000 && color < 1500) {
            g.setColor(Color.ORANGE);
        } else if (color > 1500 && color < 2000) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.green);
        }
        linearFunction(g, x0, y0, x1, y1);
        //linearFunction(g, 0, 0, 100, 600);

    } // draw

    // funcion lineal f(x) = m x + b
    // x1 y x2 es el rango en el que se graficara la funcion
    private void linearFunction(Graphics g, double x0, double y0, double x1, double y1) {

        double y;
        //double punto;

        //calculo de pendiente y del termino b (interseccion con eje y)
        double m = (y0 - y1) / (x0 - x1);
        double b = y0 - ((y0 - y1) / (x0 - x1)) * x0;

        for (double x = x0; x <= x1; x += 1) {
            //for(double x = x0; x <= x1; x += 0.1){
            y = (m * x + b);// * 10; // se multiplica por 10 para escalar el punto a representar en pantalla
            //punto = x;// * 10;
            g.drawLine((int) coord_x(x0), (int) coord_y(y0), (int) coord_x(x1), (int) coord_y(y1));

        } // for

    }// linearFunction

    private double coord_x(double x) {
        return x;
    }

    private double coord_y(double y) {
        double real_y = (double) this.getHeight() - y;
        return real_y;
    }

    @Override
    protected void paintComponent(Graphics g) {
      //  super.paintComponent(g);
        // se llama al meto draw
       
       
        try {
           
           draw(g);
           Thread.sleep(1);
           
           //pinta las lineas
           repaint();
           
            
             
        } catch (InterruptedException ex) {
            Logger.getLogger(LineExample.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    //detiene el hilo
    public void stop() {      
          Thread.currentThread().stop();
    }

    public static void main(String[] args) {
        
        JFrame window = new JFrame("Graphing Function");
        window.setContentPane(new LineExample());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.BLACK);
        window.pack();
        window.setResizable(false);
        window.setLocation(50, 20);
        window.setVisible(true);       
                       
    }

} // fin clase

