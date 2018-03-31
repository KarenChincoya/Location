/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Listeners.DatosListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Listeners.LadosListener;
import Listeners.ObjetivoListener;
import Model.Poligono;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Karen Velasco
 */
public class MainFrame extends JFrame{
    //la clase principal debe tener 
    PanelLados datos;
    PnlReadCoordenadas coordenadas;
    PanelDibujo grafica;
    Poligono poligono;
    
    JLabel resultado;
  
    public MainFrame() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setPreferredSize(new Dimension(500,500)); //NO hay preferred sized
//super.setSize(500,500);
        super.setLayout(new BorderLayout());
        
        pack();
//        setResizable( false );
        System.out.println("Creacion de panel Lados");
        datos = new PanelLados();
        
//        datos.setBounds(0, 0, 300, 100);
//        datos.add
        
        

        datos.setLadosListener(new LadosListener() {
            @Override
            public void onBtnClick(Integer n) {
                System.out.println("El poligono es de "+ n +" lados"); //To change body of generated methods, choose Tools | Templates.
                //aqui tengo n lados
                
                coordenadas = new PnlReadCoordenadas(n);
                
                add(coordenadas, BorderLayout.WEST);
                
                repaint();
                
                datos.setEditableFalse();
                setVisible(true);
                
                
                //Hasta aqui esta bien, ahora a dibujar
                coordenadas.setObjetivoListener(new ObjetivoListener() {//este escuchador tiene que dibujar
                    @Override
                    public void onBtnClick() { //desde aqui le envias mensajes a grafica
                       grafica = new PanelDibujo( coordenadas.getVertices() , coordenadas.getObjectivePoint() );
                        
                       add(grafica, BorderLayout.CENTER); 
                       //lo dibuja, coordenadas tiene 
                       poligono = new Poligono(coordenadas.getVertices());
                       
                       System.out.println("Action listener para el poligono, dibujo y funcion isInside ");
                       
                       String result;
                       
                       if(poligono.isInside(coordenadas.getObjectivePoint()) == true) 
                           result="El punto esta dentro del poligono." ;
                       else
                           result = "El punto esta fuera del poligono.";
                       
                       Font fuente=new Font("TimesRoman", Font.BOLD, 15);
                       
                       resultado = new JLabel(result);
                       resultado.setFont(fuente);
                       add(resultado, BorderLayout.SOUTH);
                       
                       setVisible(true);
                    
                    }
                });
                
            }

        });

        //super.repaint(0, 100, 100, 400);
        
        
        super.add(datos, BorderLayout.NORTH); //, 
//        super.add(coordenadas, BorderLayout.WEST); //Este es un NULL pointer exception porque no hay nada
        
        super.setVisible(true);
    }
    
    public void setCoordenadas(PnlReadCoordenadas coordenadas){
        this.coordenadas = coordenadas;
    }
}
