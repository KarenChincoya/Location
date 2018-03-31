/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Listeners.CoordenadasListener;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Listeners.DatosListener;
import Listeners.LadosListener;
import Listeners.ObjetivoListener;
import Model.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Karen Velasco
 */
public class PnlReadCoordenadas extends JPanel{
    //tendra un boton de envi
    private JLabel instrucciones;
    private Integer lados;
    
    private Point[] vertice;
    private Point objectivePoint;
    
    PanelPointReader puntoObjetivo;
    
    ObjetivoListener listener;    
    
    public PnlReadCoordenadas(Integer lados){
        //debes mostrar n+1 panelPoint
        this.setPreferredSize(new Dimension(160,400));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.lados = lados; 
        
        instrucciones = new JLabel("Coordenadas del poligono. ");
        instrucciones.setPreferredSize(new Dimension(100,50));
        
        
        super.add(instrucciones);
        
        vertice = new Point[lados];
        
        //ahora agrega los PanelPoint desde aqui
                for(int i=0; i<lados; i++){//para leer las coordenadas del poligono, AGREGA
            
                    JLabel punto = new JLabel("Punto "+i);
                    this.add(punto);
            
                    PanelPointReader pp = new PanelPointReader(i);
                    
                    pp.setCoordenadasListener(new CoordenadasListener() {
                        @Override
                        public void onBtnClick(Integer n, Integer x, Integer y) {
                            //esto es dentro de pnlReadCoordenas, esto debe pasar a Main
                            
                            vertice[n] = new Point(x,y);
                            System.out.println("Se ha creado un nuevo punto con coordenadas: "+x+" , "+y);
                            
                            pp.setUneditable();
                        }
                    });
                    
                    this.add(pp);
                }
                
        //Now, we have to read the last point
        JLabel objetivo = new JLabel("Punto a identificar");
        objetivo.setPreferredSize(new Dimension(100,20));
        
        super.add(objetivo);
        
        puntoObjetivo = new PanelPointReader(lados);
        
        puntoObjetivo.setCoordenadasListener(new CoordenadasListener() {
            @Override
            public void onBtnClick(Integer n, Integer x, Integer y) {
            //esto es dentro de pnlReadCoordenas, esto debe pasar a Main
            
            objectivePoint = new Point(x,y);
            System.out.println("Se ha creado un nuevo punto con coordenadas: "+x+" , "+y);
                            
              puntoObjetivo.setUneditable();
              listener.onBtnClick();
              
            }
        });
                    
        this.add(puntoObjetivo);
        
        
    }
    
    public void setObjetivoListener(ObjetivoListener listener){
        this.listener = listener;
    }
 
    
    public Point[] getVertices(){
        return vertice;
    }

    public Point getObjectivePoint(){
        return objectivePoint;
    }
}
