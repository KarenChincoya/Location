/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Point;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Karen Velasco
 */
public class PanelDibujo extends JPanel{
    
    Point[] vertices;
    Point objetivo;
    int[] xPoints;
    int[] yPoints;
    
    public PanelDibujo(Point[] vertices, Point objetivo){
        this.setPreferredSize(new Dimension(400,400));
        this.vertices = vertices;
        this.xPoints = new int[vertices.length];
        this.yPoints = new int[vertices.length];
        
        this.objetivo = objetivo;
    }
    
    public void paintComponent( Graphics g ){
        //llama a paintComponent para asegurar que el panel se muestre correctamente
        super.paintComponent(g); 
        
        int x1,y1,x2,y2;
        
        //Tiene que dibujar n lineas 
        for(int i=0;i<vertices.length;i++){
            
            
            xPoints[i] = 200 + vertices[i].getX();
            yPoints[i] = 200 - vertices[i].getY();
           
        }        
        g.drawPolygon(xPoints, yPoints, vertices.length);
        g.drawLine(0, 200, 400, 200);
        g.drawLine(200, 0, 200, 400);
        
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawOval(200 + objetivo.getX(), 200 - objetivo.getY(), 3, 3);
        //g.drawLine(200-objetivo.getX(), 200 - objetivo.getY(), 200-objetivo.getX(), 200 - objetivo.getY());
    }
    
   // public void punto(Graphics2D g2d){
        
   // }
}
