/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Listeners.CoordenadasListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class PanelPointReader extends JPanel{//va a leer dos datos
    JPanel xS;
    JPanel yS;
    
    JLabel lblX;
    JLabel lblY;
    
    JTextField txtX;
    JTextField txtY;
    
    Integer n;
    
    CoordenadasListener listener;
    
    public PanelPointReader(Integer n){
        
        //super.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
    //    super.setPreferredSize(new Dimension(150,30));
        super.setBorder(BorderFactory.createLineBorder(Color.black));
        
        super.setLayout(new GridLayout(0,3));
        
        this.n = n;
        
        xS = new JPanel();
        xS.setLayout(new FlowLayout());
        
        xS.setPreferredSize(new Dimension(120,50));
        

    //flowLayout, deberia estar en horizontal
        lblX = new JLabel("X: ");
        lblX.setPreferredSize(new Dimension(20,25));
        txtX = new JTextField();
        txtX.setPreferredSize(new Dimension(20,25));
        
        xS.add(lblX);
        xS.add(txtX);
        
        yS = new JPanel();
        yS.setLayout(new FlowLayout());
        
        lblY = new JLabel("Y: ");
        lblY.setPreferredSize(new Dimension(20,25));
        txtY = new JTextField();
        txtY.setPreferredSize(new Dimension(20,25));

        
        yS.add(lblY);
        yS.add(txtY);
        
        JButton boton = new JButton("OK");
        boton.setPreferredSize(new Dimension(25,25));
        //falta implementar el listener para este boton 
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(txtX.getText());
                int y = Integer.parseInt(txtY.getText());
                listener.onBtnClick(n,x, y); //To change body of generated methods, choose Tools | Templates.
                
            }
        });
   /*            
        JPanel coor = new JPanel();
        coor.setLayout(new FlowLayout());
        coor.setPreferredSize(new Dimension(200,30));
        coor.add(xS);
        coor.add(yS);
   */     
        super.add(xS);
        super.add(yS);
     //   super.add(coor);
        super.add(boton);
        
    }
    
    
    public void setCoordenadasListener(CoordenadasListener listener){
        this.listener = listener;
    }
    
    public void setUneditable(){
        this.txtX.setEditable(false);
        this.txtY.setEditable(false);
    }
}
