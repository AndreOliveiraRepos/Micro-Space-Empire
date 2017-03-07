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
public class InterstellarDiplomacy extends Technology{
    private String description;
    public InterstellarDiplomacy(int c) {
        super(c);
        this.description ="Next planet is conquered for free";
        this.setNome("Interstellar Diplomacy");
    }
    
    public void doEffect(Sistema s, Jogador j){
        j.AddSistema(s);
    }
    
    public String getDescription(){return this.description;}

    @Override
    public String toString() {
        String s;
        s = "Interstellar Diplomacy->Custo " + this.getCost()+ " " + this.getDescription();
        return s;
    }

    /*@Override
    public boolean doEffect(Jogo j) {
        j.setDiplomacy(true);
        return true;
    }*/
    @Override
    public void doEffect(Jogo j) {
        j.setDiplomacy(true); 
        this.setLearn(true);
        
    }
}
