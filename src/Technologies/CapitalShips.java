/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technologies;

import Game.GameWrapper;

/**
 *
 * @author André Oliveira
 */
public class CapitalShips extends Technology{
    private String description;
    
    public CapitalShips(int c) {
        super(c);
        
        this.description = "Advance beyond military strength of 3";
        this.setNome("Capital Ships");
    }

    
    public String getDescription(){return this.description;}

    @Override
    public String toString() {
        String s;
        s = "Capital Ships->Custo " + this.getCost()+ " " + this.getDescription();
        return s;
    
    }

    @Override
    public void doEffect(GameWrapper j) {
        this.setLearn(true);
        
    }
    
    
}
