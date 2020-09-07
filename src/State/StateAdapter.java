/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Game.GameWrapper;

import java.io.Serializable;


/**
 *
 * @author André Oliveira
 */
public abstract class StateAdapter implements IEstado, Serializable {
    public GameWrapper game;
    
    public StateAdapter(GameWrapper j){
        this.game = j;
    }
    
    /*gets*/
    public GameWrapper getGame(){
        return this.game;
    }
    
    /*sets*/
    public void setGame(GameWrapper j){
        this.game = j;
    }
    
    @Override
    public IEstado DrawClose(){ return this;}
    @Override
    public IEstado DrawDistant(){ return this;}
    
    @Override
    public IEstado Conquer(int v){ return this;}
    
    @Override
    public IEstado Pass() {
        return this;
    }
    
    @Override
    public IEstado Research(int x, int y){ return this;}
    
    @Override
    public IEstado BuildRecruit(){ return this;}
    @Override
    public IEstado DrawEvent(){ return this;} 
    @Override
    public IEstado Commerce(int v){ return this;}
    
    @Override
    public IEstado Begin(){ return this;}
    @Override
    public IEstado End(){ return this;}
    
}
