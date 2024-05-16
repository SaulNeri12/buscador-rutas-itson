/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import grafos.Locacion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author saul
 */
public class DibujaFormas {
    
     public static void dibujarPunto(Graphics2D g2d, Locacion locacion) {
        
        int x = (int) locacion.getX();
        int y = (int) locacion.getY();
         
        g2d.setColor(locacion.getColor());
        g2d.setStroke(new BasicStroke(2));
        g2d.fillOval(x, y, 10, 10);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, 10, 10);
        
        g2d.setColor(Color.YELLOW);
        Font fuente = new Font("Monospaced", Font.BOLD, 13);
        g2d.setFont(fuente);
        g2d.drawString(locacion.getNombre(), x, y);
    }

    public static void dibujarAristaEntreLocaciones(Graphics2D g2d, Locacion loc1, Locacion loc2, boolean iluminada) {
        int xAux = 0;
        int yAux = 0;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        BasicStroke stroke = new BasicStroke(1);
        
        Color color = Color.RED;
        
        if (iluminada) {
            stroke = new BasicStroke(2);
            color = Color.GREEN;
        }
        
        g2d.setColor(color);
        g2d.setStroke(stroke);
        
        int x1 = (int) loc1.getX();
        int y1 = (int) loc1.getY();
        
        int x2 = (int) loc2.getX();
        int y2 = (int) loc2.getY();
        
        g2d.drawLine(x1 + 10, y1 + 10, x2 + 10, y2 + 10);
        
        /*
        if (x1 <= x2) {
            xAux = ((x2 - x1) / 2) + x1;
        }
        if (x1 > x2) {
            xAux = ((x1 - x2) / 2) + x2;
        }
        if (y1 < y2) {
            yAux = ((y2 - y1) / 2) + y1;
        }
        if (y1 >= y2) {
            yAux = ((y1 - y2) / 2) + y2;
        }
     */
        //g2d.setColor(Color.BLUE);
        //Font fuente = new Font("Monospaced", Font.PLAIN, 12);
        //g2d.setFont(fuente);
    }

}
