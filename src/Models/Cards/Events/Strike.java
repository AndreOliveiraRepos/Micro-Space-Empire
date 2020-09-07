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
public class Strike extends Card {

       
  
     
    private String year1;
    private String year2;
    public Strike(){
        this.setName("Strike");
        this.year1 = "No Resources next turn";
        this.year2 = "No Resources next turn";
    }
    
    
     @Override
    public void doEffect(GameWrapper j){
        j.setStrike(true);
        
    }
    
    public String getYear1(){return this.year1;}
    public String getYear2(){return this.year2;}



    @Override
    public String WriteCard() {
        String s;
        s = "Strike-> 1:" + this.getYear1() + " 2:" +this.getYear2();
        return s;
    }
    
}
