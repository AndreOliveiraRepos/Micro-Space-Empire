/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Game.GameWrapper;

/**
 *
 * @author André Oliveira
 */
public class IE extends StateAdapter {
    
    public IE(GameWrapper j) {
        super(j);
    }
    
    @Override
    public IState Commerce(int v){
        if (v == 1) {
            if (this.game.getPlayer().getTotMetal() >= 2 && this.game.getPlayer().getTotWealth() <= 4 ) {
                this.game.getPlayer().setMetal(-2);
                this.game.getPlayer().setWealth(1);
                this.game.setSystemMessage("[Sistema] Trocou 2 de metal\npor 1 de Wealth");
            }
        }
        else if(v == 2){
            if (this.game.getPlayer().getTotMetal() <= 4 && this.game.getPlayer().getTotWealth() >= 2 ) {
                this.game.getPlayer().setMetal(1);
                this.game.getPlayer().setWealth(-2);
                this.game.setSystemMessage("[Sistema] Trocou 2 de Wealth\npor 1 de Metal");
            }
        }
        return new Phase3(this.game);
    }
    
    @Override
    public IState Pass(){
        this.game.setSystemMessage("[Sistema] Passou!");
        return new Phase3(this.game);
    }
}
