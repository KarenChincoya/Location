/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Karen Velasco
 */
public class Point {
    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
    
    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    
    public Orientation calculateOrientation(Point p1, Point p2, Point p3){
        int result = (p2.getY() - p1.getY()) * (p3.getX() - p2.getX()) - (p2.getX() - p1.getX()) * (p3.getY() - p2.getY());
        
//        if(result==0) System.out.println("Orientacion = colinear");
        if(result==0) return Orientation.Colinear;
        
//        System.out.println((result > 0)? "Clockwise": "CounterClockwise"); // clock or counterclock wise
        return (result > 0)? Orientation.Clockwise: Orientation.CounterClockwise; // clock or counterclock wise
    }
    
    public Orientation calculateOrientation(Segment s, Point p3){
        Point p1 = s.getStart();
        Point p2 = s.getEnd();
        return calculateOrientation(p1,p2,p3);
    }
    
}
