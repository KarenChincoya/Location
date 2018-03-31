/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Listeners.LadosListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class PanelLados extends JPanel{
    //este debe tener
    private JLabel lblLados;
    private JTextField txtLados;
    private JButton boton;
    private Integer lados;
    
    LadosListener listener;
    
    PanelPointReader pp;
    JLabel texto;
    
    public PanelLados(){
        this.setLayout(new FlowLayout());
        //this.setPreferredSize(new Dimension(500,100));
        //datos.setSize(500, 100);
        lblLados = new JLabel("Ingrese los lados del poligono: ");
        lblLados.setBounds(10, 10, 100, 30);
        
        txtLados = new JTextField();
        txtLados.setPreferredSize(new Dimension(50,20));
        //txtLados.setBounds(120, 10, 100, 30);
        
        boton = new JButton("OK");
        boton.setBounds(240, 10, 30, 10);
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onBtnClick(Integer.parseInt(txtLados.getText())); //transformamos la cadena leida en un entero
            }
//            public void calcular(){};
        });
        
        
        this.add(lblLados);
        this.add(txtLados);
        this.add(boton);
        
               
    }
    
    public void setLadosListener(LadosListener listener){
        this.listener = listener;
    }
    
    public Integer getLados(){
        return lados;
    }
 
    public void setEditableFalse(){
        this.txtLados.setEditable(false);
    }
    public void setPanelPoint(PanelPointReader pp){
        this.pp = pp;
        
    }
    
    public void setTexto(String texto){
        this.texto.setText(texto);
    }
}
