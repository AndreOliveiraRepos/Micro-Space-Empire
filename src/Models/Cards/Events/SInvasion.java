/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Cards.Events;

import Models.Cards.Card;
//import Estados.End;
import Game.GameWrapper;

/**
 *
 * @author André Oliveira
 */
public class SInvasion extends Card {

   
     
    private String year1;
    private String year2;
    public SInvasion(){
        this.setNome("Small Invasion");
        this.year1 = "Force +1";
        this.year2 = "Force +2";
    }
    

    
    @Override
    public void doEffect(GameWrapper j){
        /*rola dado*/
       
        if (j.getPlayer().getConquistados().size() == 1 && j.getAno() == 2) {
            
           j.getPlayer().getConquistados().remove(0);
           /*j.getEstado().End();
            return true;*/
           j.setSystemMessage("O HomeWorld foi invadido e perdeu o jogo!\n");
        }
        int r = j.RolaDado();
        /*Planetary Defenses*/
        if(j.getTechs(1,1).getLearn())
            j.getTechs(1,1).doEffect(j);
        /*condiçoes de combate*/
        if (j.getAno()==1 && j.getPlayer().getConquistados().size() > 1) {
            if((r + 1)> j.getPlayer().getConquistados().get(j.getPlayer().getConquistados().size()-1).getResist())
            {
                j.setRelatorioCombat(false, j.getPlayer().getConquistados().get(j.getPlayer().getConquistados().size()-1), r);
                j.getDesalinhas().add(j.getPlayer().getConquistados().get(j.getPlayer().getConquistados().size()-1));
                j.getPlayer().getConquistados().remove(j.getPlayer().getConquistados().size()-1);
               
            }
            else
            {  
                j.setRelatorioCombat(true, j.getPlayer().getConquistados().get(j.getPlayer().getConquistados().size()-1), r);
                
            
            }
        }
        else if(j.getAno()==2 && j.getPlayer().getConquistados().size()>1){
            if((r + 2)> j.getPlayer().getConquistados().get(j.getPlayer().getConquistados().size()-1).getResist())
            {
                j.setRelatorioCombat(false, j.getPlayer().getConquistados().get(j.getPlayer().getConquistados().size()-1), r);
                j.getDesalinhas().add(j.getPlayer().getConquistados().get(j.getPlayer().getConquistados().size()-1));
                j.getPlayer().getConquistados().remove(j.getPlayer().getConquistados().size()-1);
                
            }
            else
            {
                j.setRelatorioCombat(true, j.getPlayer().getConquistados().get(j.getPlayer().getConquistados().size()-1), r);
                
            }
                
        }
     
        
    }
    
    public String getYear1(){return this.year1;}
    public String getYear2(){return this.year2;}
      
    


    @Override
    public String EscreveCarta() {
        String s;
        s = "Small Invasion-> 1:" + this.getYear1() + " 2:" +this.getYear2();
        return s;
    }
    
}
