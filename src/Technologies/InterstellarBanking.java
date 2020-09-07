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
public class InterstellarBanking extends Technology{
    private String description;
    public InterstellarBanking(int c) {
        super(c);
        this.description ="Advance beyond Storage value 3";
        this.setNome("Interstellar Banking");
    }
    public String getDescription(){return this.description;}

    @Override
    public String toString() {
       String s;
        s = "Interstellar Banking->Custo " + this.getCost()+ " " +  this.getDescription();
        return s;
    }

   @Override
    public void doEffect(GameWrapper j) {
        this.setLearn(true);
        
    }
}
