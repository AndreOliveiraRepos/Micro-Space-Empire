/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas.Eventos;

import Cartas.Carta;
import Jogo.Jogador;
import Jogo.Jogo;

/**
 *
 * @author red_f
 */
public class DerelicShip extends Carta{
    
    private String year1;
    private String year2;
    public DerelicShip(){
        this.setNome("Derelic Ship");
        this.year1 = "Gain 1 Metal";
        this.year2 = "Gain 1 Metal";
    }
    
    
    @Override
    public void doEffect(Jogo j){
        if(j.getPlayer().getTotMetal() < 5)
            j.getPlayer().setMetal(1);
        else
            j.setMensagemSistema("[SISTEMA] Armazenamento cheio");
        
    }
    
    public String getYear1(){return this.year1;}
    public String getYear2(){return this.year2;}
      
    


    @Override
    public String EscreveCarta() {
        String s;
        s = "Derelic Ship-> 1:" + this.getYear1() + " 2:" +this.getYear2();
        return s;
    }
    
}
