/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.Orientation.Colinear;

/**
 *
 * @author Karen Velasco
 */
public class Segment {
    private Point start;
    private Point end;
    
    public Segment(Point start, Point end){
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
    
    public Integer getMaxX(){
        if(start.getX()>=end.getX())
            return start.getX();
        else
            return end.getX();
    }
    
    public Integer getMinX(){
        if(start.getX()<=end.getX())
            return start.getX();
        else
            return end.getX();
    }
    
    public Integer getMaxY(){
        if(start.getY()>=end.getY())
            return start.getY();
        else
            return end.getY();
    }
    
    public Integer getMinY(){
        if(start.getY()<=end.getY())
            return start.getY();
        else
            return end.getY();
    }

    public boolean hasPoint(Point p){
        if (p.getX() <= this.getMaxX() && p.getX() >= this.getMinX() &&
            p.getY() <= this.getMaxY() && p.getY() >= this.getMinY())
                return true;
        
         return false;
    }
    
    public boolean doIntersect(Segment s1, Segment s2){
        //general case
        Orientation o1 = s2.getStart().calculateOrientation(s1, s2.getStart()); //s1 y s2.start
        Orientation o2 = s2.getEnd().calculateOrientation(s1, s2.getEnd()); //s1 y s2.end
        Orientation o3 = s1.getStart().calculateOrientation(s2, s1.getStart()); //s2 y s1.start
        Orientation o4 = s1.getEnd().calculateOrientation(s2, s1.getEnd()); //s2 y s1.end
        
        //General case
        if(o1!=o2 && o3!=o4)
            return true;
        // Special Cases
        // s1 and s2.start are colinear and p2 lies on segment s1,   el metodo es del segmento
        if (o1 == Colinear && s1.hasPoint(s2.getStart())) return true;

        // s1 and s2.end are colinear and q2 lies on segment s1, PERO solo nos interesa el punto de INICIO porque es el PUNTO
//        if (o2 == Colinear && s1.onSegment(s2.getEnd())) return true;
        if (o2 == Colinear && s1.hasPoint(s2.getStart())) return true;

        // s2 and s1.start are colinear and s1.start lies on segment s2
//        if (o3 == Colinear && s2.onSegment(s1.getStart())) return true;
        if (o3 == Colinear && s1.hasPoint(s2.getStart())) return true;

//         // s2 and s1.end are colinear and s1.end lies on segment s2
//         if (o4 == Colinear && s2.onSegment(s1.getEnd())) return true;
         if (o4 == Colinear && s1.hasPoint(s2.getStart())) return true;
         
        return false; // Doesn't fall in any of the above cases
        
    }
}
