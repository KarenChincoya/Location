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
public class Poligono {
    Integer lados;
    Point[] vertice;
    Segment[] arista;
    
    public Poligono(Point[] vertice){
        this.lados = vertice.length;
        this.vertice = new Point[lados];
        this.arista = new Segment[lados];
        
        for(int i=0;i<lados;i++){
            this.vertice[i] = new Point(vertice[i].getX(), vertice[i].getY());
        }
        
        for(int i=0;i<lados;i++){
            if(i == (lados-1)){
                arista[i] = new Segment(vertice[i], vertice[0]);
            }else{
                arista[i] = new Segment(vertice[i], vertice[i+1]);                 
            }
        }
        
    }
    
    public Integer getLados(){
        return lados;
    }
    
    public Point getVertice(Integer n){
        return vertice[n];
    }
    
    public Segment getArista(Integer n){
        return arista[n];
    }
    
    public Integer getMaxX(){//para la recta que se creara
        //debemos ordenar las x's
        Integer[] xValues = new Integer[lados];
        //llenar el arreglo x's con las x's de los vertices
        for(int i=0;i<lados;i++){
            xValues[i] = vertice[i].getX();
        }
        xValues = this.quickSort(xValues);
        
        return xValues[lados-1];
    }
    
    public Integer[] quickSort(Integer[] list){
        
        if(list.length == 1)return list;
        
        Integer pivot = list[list.length - 1]; //no llega a cero
        Integer[] right;
        Integer[] left;
        
        Integer current = 0;
        Integer wall = 0;
        Integer aux;
 
        while(current < (list.length-1)){
            if(list[current] < pivot){//when the value is less than the pivot, swap
                aux = list[current];
                list[current] = list[wall];
                list[wall] = aux;
                wall++;
            }
            current++;
        }
                
        //cuando current = pivote, de, CUANDO THE WALL NO SEA el pivote, pero se refiere a la posicion, NO al valor
        if(wall!=(list.length-1)){//list[wall] != pivot
            aux = list[current];
            list[current] = list[wall];
            list[wall] = aux;
            wall++;
        }
        
        int i=0;
        left = new Integer[wall];
        while(i<wall){
            left[i] = list[i];
            i++;
        }
        
        int k=0;
        right = new Integer[list.length-wall];
        
        while(i<list.length){
            right[k] = list[i];
            k++; 
            i++;
        }
        
        
        if(left.length!=0) left = quickSort(left);            
       
        if(right.length !=0 )right = quickSort(right);
                 
        i = 0;
        
        while(i < left.length){
            list[i] = left[i];
            i++;
        }
        k=0;
        while(i<list.length){//longitud
            list[i] = right[k];
            k++; 
            i++;
        }
  
        return list;
    }
    
    public boolean isInside(Point punto){
        Point puntoFinal = new Point(this.getMaxX()+1, punto.getY());
        Segment horizontalLine = new Segment(punto, puntoFinal);
        int counter = 0;
        for(int i=0;i<lados;i++){
            if(punto.getX()==vertice[i].getX() && punto.getY()==vertice[i].getY())
                counter++;
        }
        if(counter>0) return true;
            
        counter = 0;

        for(int i=0;i<lados;i++){//verificar la interseccion entre aristas y la horizontalLine
            if(this.getArista(i).doIntersect(this.getArista(i), horizontalLine))
                counter++;    
        }
        
        //System.out.println("Intersecciones = "+counter);
        
        if(counter%2 == 0)
            return false;
        else 
            return true;
        
    }
}

