/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ModeloJogo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javafx.beans.InvalidationListener;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author red_f
 */
public class Painel extends JPanel implements Observer{
    private Image fundo;
    private JTextField texto;
    private ModeloJogo modelo;
    //default
    public Painel(LayoutManager l, boolean opaco, ModeloJogo m){
        Dimension d = new Dimension(20,20);
        this.setLayout(l);
        this.setOpaque(opaco);
        this.modelo = m;
        this.modelo.addObserver(this);
        this.setMinimumSize(d);
        /*this.add(texto);
        this.texto.setVisible(false);*/
    }
    
    public Painel(LayoutManager l, boolean opaco,int w, int h, ModeloJogo m){
        Dimension d = new Dimension(w,h);
        this.setOpaque(opaco);
        this.setLayout(l);
        this.setPreferredSize(d);
        //this.setMinimumSize(new Dimension(248,348));
        //this.setMaximumSize(d);
       /* this.add(texto);
        this.texto.setVisible(false);*/
        
    }
    public void setTexto(String s){
        texto.setVisible(true);
        texto.setText(s);
        this.add(texto);
    }
    
    public void setImage(String s){
        
        try{
            fundo = ImageIO.read(new File(s));
            
        }
        catch(IOException ex){
            System.out.println("yep");
        }
    }
    
    public Image getImage(){return this.fundo;}
    
    /*public void setVisible(boolean visible){
        //this.setVI(visible);
    }*/
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(fundo != null)
            g.drawImage(fundo, 0, 0, this.getWidth(), this.getHeight() ,this);
            //g.drawImage(fundo, 0, 0, 248, 348 ,this);
        else
            g.setColor(Color.yellow);
    }

    @Override
    public void update(Observable o, Object o1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
