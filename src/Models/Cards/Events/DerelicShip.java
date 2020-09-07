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
public class DerelicShip extends Card {
    
    private String year1;
    private String year2;
    public DerelicShip(){
        this.setNome("Derelic Ship");
        this.year1 = "Gain 1 Metal";
        this.year2 = "Gain 1 Metal";
    }
    
    
    @Override
    public void doEffect(GameWrapper j){
        if(j.getPlayer().getTotMetal() < 5)
            j.getPlayer().setMetal(1);
        else
            j.setSystemMessage("[SISTEMA] Armazenamento cheio");
        
    }
    
    public String getYear1(){return this.year1;}
    public String getYear2(){return this.year2;}
      
    


    @Override
    public String EscreveCarta() {
        String s;
        s = "Derelic Ship-> 1:" + this.getYear1() + " 2:" +this.getYear2();
        return s;
    }
    
}
