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
public class LInvasion extends Card {

    
    private String year1;
    private String year2;
    public LInvasion(){
        this.setName("Large Invasion");
        this.year1 = "Force +2";
        this.year2 = "Force +3";
    }
    
    
     @Override
    public void doEffect(GameWrapper j){
        
        if (j.getPlayer().getConqueredSystems().size() == 1 && j.getYear() == 2) {
            j.getPlayer().getConqueredSystems().remove(0);
            j.setSystemMessage("O HomeWorld foi invadido e perdeu o jogo!\n");
           
           //j.getEstado().End();
           
        }
        /*rola dado*/
        int r = j.RollDice();
        
        /*Planetary Defenses*/
        if(j.getTechs(1,1).getLearn())
            j.getTechs(1,1).doEffect(j);
            
        /*condiçoes de combate*/
        if (j.getYear()==1 && j.getPlayer().getConqueredSystems().size() > 1 ) {
            if((r + 2)> j.getPlayer().getConqueredSystems().get(j.getPlayer().getConqueredSystems().size()-1).getResist())
            {
                /*remover da lista, criar relatório
                */
                
                j.setCombatReport(false, j.getPlayer().getConqueredSystems().get(j.getPlayer().getConqueredSystems().size()-1), r);
                j.getUnaligned().add(j.getPlayer().getConqueredSystems().get(j.getPlayer().getConqueredSystems().size()-1));
                j.getPlayer().getConqueredSystems().remove(j.getPlayer().getConqueredSystems().size()-1);
                
            }
            else
            {  
                j.setCombatReport(true, j.getPlayer().getConqueredSystems().get(j.getPlayer().getConqueredSystems().size()-1), r);
                
            
            }
        }
        else if(j.getYear()==2 && j.getPlayer().getConqueredSystems().size()>1){
            if((r + 3)> j.getPlayer().getConqueredSystems().get(j.getPlayer().getConqueredSystems().size()-1).getResist())
            {
                j.setCombatReport(false, j.getPlayer().getConqueredSystems().get(j.getPlayer().getConqueredSystems().size()-1), r);
                j.getUnaligned().add(j.getPlayer().getConqueredSystems().get(j.getPlayer().getConqueredSystems().size()-1));
                j.getPlayer().getConqueredSystems().remove(j.getPlayer().getConqueredSystems().size()-1);
                
            }
            else
            {
                j.setCombatReport(true, j.getPlayer().getConqueredSystems().get(j.getPlayer().getConqueredSystems().size()-1), r);
                
            }
                
        }
        
        
        
    }
    
    public String getYear1(){return this.year1;}
    public String getYear2(){return this.year2;}
    


    @Override
    public String WriteCard() {
        String s;
        s = "Large Invasion-> 1:" + this.getYear1() + " 2:" +this.getYear2();
        return s;
    }
    
}
