/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas.Eventos;

import Cartas.Carta;
import Cartas.Sistema;
import Estado.End;
//import Estados.End;
import Jogo.Jogador;
import Jogo.Jogo;

/**
 *
 * @author red_f
 */
public class Revolt1 extends Carta{

    

    
    private String year1;
    private String year2;
    public Revolt1(){
        this.setNome("Revolt 1");
        this.year1 = "Force +1";
        this.year2 = "Force +3";
    }
   
    
   @Override
    public void doEffect(Jogo j){
        
        /*rola dado*/
        
        if (j.getPlayer().getConquistados().size() == 1 && j.getAno() == 2) {
            
           j.getPlayer().getConquistados().remove(0);
           /*j.getEstado().End();
           return true;*/
           j.setMensagemSistema("O HomeWorld revoltou-se e perdeu o jogo!\n");
        }
        else if(j.getPlayer().getConquistados().size() > 1){
            Sistema s;
            int i = 0,r = j.RolaDado(),p = 0;
            s = j.getPlayer().getConquistados().get(1);
            if(j.getPlayer().getConquistados().size() > 1){
                for (i = 1; i < j.getPlayer().getConquistados().size(); i++) {
                    if(s.getResist() >= j.getPlayer().getConquistados().get(i).getResist() )
                    {
                        s = j.getPlayer().getConquistados().get(i);
                        p = i;
                    }

                }
            }

            /*Hyper Television*/
            if(j.getTechs(2,0).getLearn())
                s.setResist(1);

            if (j.getAno()==1 && j.getPlayer().getConquistados().size() > 1) {
                if((r + 1)>= s.getResist())
                {
                    j.setRelatorioCombat(false, j.getPlayer().getConquistados().get(p), r);
                    j.getDesalinhas().add(j.getPlayer().getConquistados().get(p));
                    j.getPlayer().getConquistados().remove(p);

                }
                else
                {  
                    j.setRelatorioCombat(true, j.getPlayer().getConquistados().get(p), r);


                }
            }
            else if(j.getAno()==2){
                if((r + 3)>= s.getResist())
                {
                    j.setRelatorioCombat(false, j.getPlayer().getConquistados().get(p), r);
                    j.getDesalinhas().add(j.getPlayer().getConquistados().get(p));
                    j.getPlayer().getConquistados().remove(p);

                }
                else
                {  
                    j.setRelatorioCombat(true, j.getPlayer().getConquistados().get(p), r);


                }
            }
        }
        
        
    }
    
    public String getYear1(){return this.year1;}
    public String getYear2(){return this.year2;}
      
    

    @Override
    public String EscreveCarta() {
        String s;
        s = "Revolt-> 1:" + this.getYear1() + " 2:" +this.getYear2();
        return s;
    }
    
}
