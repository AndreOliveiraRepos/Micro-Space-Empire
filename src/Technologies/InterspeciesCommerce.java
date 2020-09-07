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
public class InterspeciesCommerce extends Technology{
    private String description;
    public InterspeciesCommerce(int c) {
        super(c);
        this.description ="Exchange 2 of one resource for 1 of the other";
        this.setNome("Interspecies Commerce");
    }
    /*public void doEffect(Jogador j, int m, int w){
        if(m > w){
            j.setWealth(w);
            j.setMetal(-m);
        }
        else{
            j.setWealth(m);
            j.setMetal(-w);
        }
        
    }*/
    public String getDescription(){return this.description;}

    @Override
    public String toString() {
        String s;
        s = "Interspecies Commerce->Custo " + this.getCost()+ " " +  this.getDescription();
        return s;
    }

    /*@Override
    public boolean doEffect(Jogo j) {
        j.setInterSpecies(true);
        return j.getInterSpeciesCommerce();
    }*/
    
    @Override
    public void doEffect(GameWrapper j) {
        this.setLearn(true);
        
    }
}
