/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Jogo.Jogo;

/**
 *
 * @author red_f
 */
public class IE extends EstadoAdapter {
    
    public IE(Jogo j) {
        super(j);
    }
    
    @Override
    public IEstado Commerce(int v){
        if (v == 1) {
            if (this.jogo.getPlayer().getTotMetal() >= 2 && this.jogo.getPlayer().getTotWealth() <= 4 ) {
                this.jogo.getPlayer().setMetal(-2);
                this.jogo.getPlayer().setWealth(1);
                this.jogo.setMensagemSistema("[Sistema] Trocou 2 de metal\npor 1 de Wealth");
            }
        }
        else if(v == 2){
            if (this.jogo.getPlayer().getTotMetal() <= 4 && this.jogo.getPlayer().getTotWealth() >= 2 ) {
                this.jogo.getPlayer().setMetal(1);
                this.jogo.getPlayer().setWealth(-2);
                this.jogo.setMensagemSistema("[Sistema] Trocou 2 de Wealth\npor 1 de Metal");
            }
        }
        return new Fase3(this.jogo);
    }
    
    @Override
    public IEstado Pass(){
        this.jogo.setMensagemSistema("[Sistema] Passou!");
        return new Fase3(this.jogo);
    }
}
