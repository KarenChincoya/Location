/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Point;
import Model.Poligono;
import Model.Segment;

/**
 *
 * @author Karen Velasco
 */
public class Test {
    public static void main(String[] args) {
        
        
    //condicion de mayor a 3 lados

//debemos tener el punto susodicho
        
        Integer lados = 3;
        
        Integer x = -6; 
        Integer y = 3;
        
        Point punto = new Point(x,y);
        //vertice, pero no tiene valores
        Point[] vertice = new Point[lados];
        
        Integer[] xS = {-6,3,0};
        Integer[] yS = {3,3,-5};
        
        for(int i=0; i<lados; i++){
            vertice[i] = new Point(xS[i], yS[i]);
        }
        
        Poligono poligono = new Poligono(vertice);
        
        if(poligono.isInside(punto)){
            System.out.println("El punto esta dentro del poligono.");
        }else{
            System.out.println("El punto esta fuera del poligono");
        }
            
    }
}
