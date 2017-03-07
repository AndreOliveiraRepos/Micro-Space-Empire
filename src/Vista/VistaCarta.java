/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Cartas.Carta;
import Modelo.ModeloJogo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author red_f
 */
public class VistaCarta extends Painel{
    
    public VistaCarta(LayoutManager l, boolean opaco, ModeloJogo m){
        super(l,opaco, m);
        
    }
    
    public VistaCarta(LayoutManager l, boolean opaco, int w, int h, ModeloJogo m) {
        super(l, opaco, w, h, m);
        
        
        Dimension d = new Dimension(248,348);
        this.setMaximumSize(d);
        d = new Dimension(w,h);
        this.setPreferredSize(d);
        //d = new Dimension(124,);
        //this.setMinimumSize(d);
        
    }
    
    public VistaCarta(LayoutManager l, boolean opaco, int w, int h, ModeloJogo m, String img) {
        super(l, opaco, w, h, m);
        
        
        Dimension d = new Dimension(248,348);
        this.setMaximumSize(d);
        d = new Dimension(w,h);
        this.setPreferredSize(d);
        //d = new Dimension(124,);
        //this.setMinimumSize(d);
        this.setImage(img);
        
    }
    
    
    
}
