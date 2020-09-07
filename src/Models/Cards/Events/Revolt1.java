/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Cards.Events;

import Models.Cards.Card;
import Models.Cards.System;
//import Estados.End;
import Game.GameWrapper;

/**
 *
 * @author André Oliveira
 */
public class Revolt1 extends Card {

    

    
    private String year1;
    private String year2;
    public Revolt1(){
        this.setName("Revolt 1");
        this.year1 = "Force +1";
        this.year2 = "Force +3";
    }
   
    
   @Override
    public void doEffect(GameWrapper j){
        
        /*rola dado*/
        
        if (j.getPlayer().getConqueredSystems().size() == 1 && j.getYear() == 2) {
            
           j.getPlayer().getConqueredSystems().remove(0);
           /*j.getEstado().End();
           return true;*/
           j.setSystemMessage("O HomeWorld revoltou-se e perdeu o jogo!\n");
        }
        else if(j.getPlayer().getConqueredSystems().size() > 1){
            System s;
            int i = 0,r = j.RollDice(),p = 0;
            s = j.getPlayer().getConqueredSystems().get(1);
            if(j.getPlayer().getConqueredSystems().size() > 1){
                for (i = 1; i < j.getPlayer().getConqueredSystems().size(); i++) {
                    if(s.getResist() >= j.getPlayer().getConqueredSystems().get(i).getResist() )
                    {
                        s = j.getPlayer().getConqueredSystems().get(i);
                        p = i;
                    }

                }
            }

            /*Hyper Television*/
            if(j.getTechs(2,0).getLearn())
                s.setResist(1);

            if (j.getYear()==1 && j.getPlayer().getConqueredSystems().size() > 1) {
                if((r + 1)>= s.getResist())
                {
                    j.setCombatReport(false, j.getPlayer().getConqueredSystems().get(p), r);
                    j.getUnaligned().add(j.getPlayer().getConqueredSystems().get(p));
                    j.getPlayer().getConqueredSystems().remove(p);

                }
                else
                {  
                    j.setCombatReport(true, j.getPlayer().getConqueredSystems().get(p), r);


                }
            }
            else if(j.getYear()==2){
                if((r + 3)>= s.getResist())
                {
                    j.setCombatReport(false, j.getPlayer().getConqueredSystems().get(p), r);
                    j.getUnaligned().add(j.getPlayer().getConqueredSystems().get(p));
                    j.getPlayer().getConqueredSystems().remove(p);

                }
                else
                {  
                    j.setCombatReport(true, j.getPlayer().getConqueredSystems().get(p), r);


                }
            }
        }
        
        
    }
    
    public String getYear1(){return this.year1;}
    public String getYear2(){return this.year2;}
      
    

    @Override
    public String WriteCard() {
        String s;
        s = "Revolt-> 1:" + this.getYear1() + " 2:" +this.getYear2();
        return s;
    }
    
}
