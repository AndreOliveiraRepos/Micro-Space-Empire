/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technologies;

import Jogo.Jogador;
import Jogo.Jogo;

/**
 *
 * @author red_f
 */
public class RobotWorkers extends Technology{
    private String description;
    public RobotWorkers(int c) {
        super(c);
        this.setNome("Robot Workers");
        this.description = "Receive 1/2 production during strike";
    }
    
    
    public String getDescription(){return this.description;}

    @Override
    public String toString() {
        String s;
        s = "Robot Workers->Custo " + this.getCost()+ " " +  this.getDescription();
        return s;
    }

    /*@Override
    public boolean doEffect(Jogo j) {
        j.getPlayer().setMetal(j.getPlayer().getProdMetal()/2);
        j.getPlayer().setWealth(j.getPlayer().getProdWealth()/2);
        
        return true;
    }*/
    @Override
    public void doEffect(Jogo j) {
        if(this.getLearn()){
            j.getPlayer().setMetal(j.getPlayer().getProdMetal()/2);
            j.getPlayer().setWealth(j.getPlayer().getProdWealth()/2);
        }
        else{
            this.setLearn(true);
        }
        
        
    }
}
