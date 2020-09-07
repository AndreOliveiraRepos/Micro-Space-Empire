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
public class Asteroid extends Card {
    
    private String year1;
    private String year2;
    public Asteroid(){
        this.year1 = "Gain 1 Wealth";
        this.year2 = "Gain 1 Wealth";
        this.setNome("Asteroid");
    }

    
    @Override
    public void doEffect(GameWrapper j){
        if(j.getPlayer().getTotWealth() < 5)
            j.getPlayer().setWealth(1);
        else
            j.setSystemMessage("[SISTEMA] Armazenamento cheio");
    }
    
    
    public String getYear1(){return this.year1;}
    public String getYear2(){return this.year2;}
      
    
  

    @Override
    public String EscreveCarta() {
        String s;
        s = "Asteroid-> 1:" + this.getYear1() + " 2:" +this.getYear2();
        return s;
    }

    
    
    
}
