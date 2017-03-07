/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technologies;

import Cartas.Sistema;
import Jogo.Jogador;
import Jogo.Jogo;

/**
 *
 * @author red_f
 */
public class PlanetaryDefenses extends Technology{
    private String description;
    public PlanetaryDefenses(int c) {
        super(c);
        this.description ="+1 to resistance during invasion";
        this.setNome("Planetary Defenses");
    }
    public int doEffect(Sistema s) {
        int n;
        n = s.getResist()+1;
        return n;
    }
    public String getDescription(){return this.description;}

    @Override
    public String toString() {
        String s;
        s = "Planetary Defenses->Custo " + this.getCost()+ " " +  this.getDescription();
        return s;
    }

    /*@Override
    public boolean doEffect(Jogo j) {
        j.getPlayer().getConquistados().get(0).setResist(1);
        return true;
    }*/
    
    @Override
    public void doEffect(Jogo j) {
        if(this.getLearn()){
            j.getPlayer().getConquistados().get(0).setResist(1);
        }
        else{
            this.setLearn(true);
        }
        
        
    }
}
