/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technologies;

import Models.Cards.System;
import Game.GameWrapper;

/**
 *
 * @author André Oliveira
 */
public class HyperTelevision extends Technology{
    private String description;
    public HyperTelevision(int c) {
        super(c);
        this.description = "+1 to resistance during revolt";
        this.setNome("Hyper Television");
    }

    
    
    public String getDescription(){return this.description;}

    @Override
    public String toString() {
        String s;
        s = "Hyper Television->Custo " + this.getCost()+ " " +  this.getDescription();
        return s;
    }

   /* @Override
    public boolean doEffect(Jogo j) {
        Sistema s;
        s   =  j.getPlayer().getConquistados().get(0);
        for (int i = 0; i < j.getPlayer().getConquistados().size(); i++) {
            if (j.getPlayer().getConquistados().get(i).getResist() >= s.getResist()) {
                s = j.getPlayer().getConquistados().get(i);
            }
        }
        s.setResist(1);
        return true;
    }*/
    
    @Override
    public void doEffect(GameWrapper j) {
        if(this.getLearn()){
            System s;
            s   =  j.getPlayer().getConqueredSystems().get(0);
            for (int i = 0; i < j.getPlayer().getConqueredSystems().size(); i++) {
                if (j.getPlayer().getConqueredSystems().get(i).getResist() >= s.getResist()) {
                    s = j.getPlayer().getConqueredSystems().get(i);
                }
            }
            s.setResist(1);
        }
        else{
            this.setLearn(true);
        }
        
    }

    
    
}
