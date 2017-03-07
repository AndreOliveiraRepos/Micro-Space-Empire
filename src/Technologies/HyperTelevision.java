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
    public void doEffect(Jogo j) {
        if(this.getLearn()){
            Sistema s;
            s   =  j.getPlayer().getConquistados().get(0);
            for (int i = 0; i < j.getPlayer().getConquistados().size(); i++) {
                if (j.getPlayer().getConquistados().get(i).getResist() >= s.getResist()) {
                    s = j.getPlayer().getConquistados().get(i);
                }
            }
            s.setResist(1);
        }
        else{
            this.setLearn(true);
        }
        
    }

    
    
}
