/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Cards.Events;

import Models.Cards.Card;
import Game.GameWrapper;

/**
 *
 * @author André Oliveira
 */
public class PaO extends Card {

    
    
    private String year1;
    private String year2;
    public PaO(){
        this.setNome("Peace and Order");
        this.year1 = "No Event";
        this.year2 = "No Event";
    }
    
    
    public String getYear1(){return this.year1;}
    public String getYear2(){return this.year2;}
    
     @Override
    public void doEffect(GameWrapper j){
        
        
    }


    @Override
    public String EscreveCarta() {
        String s;
        s = "Peace & Order-> 1:" + this.getYear1() + " 2:" +this.getYear2();
        return s;
    }
    
}
