/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Game;

import java.awt.Dimension;
import java.awt.LayoutManager;

/**
 *
 * @author André Oliveira
 */
public class Card extends Panel {
    
    public Card(LayoutManager l, boolean opaco, Game m){
        super(l,opaco, m);
        
    }
    
    public Card(LayoutManager l, boolean opaco, int w, int h, Game m) {
        super(l, opaco, w, h, m);
        
        
        Dimension d = new Dimension(248,348);
        this.setMaximumSize(d);
        d = new Dimension(w,h);
        this.setPreferredSize(d);
        //d = new Dimension(124,);
        //this.setMinimumSize(d);
        
    }
    
    public Card(LayoutManager l, boolean opaco, int w, int h, Game m, String img) {
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
