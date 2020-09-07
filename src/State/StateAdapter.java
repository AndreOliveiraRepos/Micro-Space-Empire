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
public abstract class StateAdapter implements IState, Serializable {
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
    public IState DrawClose(){ return this;}
    @Override
    public IState DrawDistant(){ return this;}
    
    @Override
    public IState Conquer(int v){ return this;}
    
    @Override
    public IState Pass() {
        return this;
    }
    
    @Override
    public IState Research(int x, int y){ return this;}
    
    @Override
    public IState BuildRecruit(){ return this;}
    @Override
    public IState DrawEvent(){ return this;}
    @Override
    public IState Commerce(int v){ return this;}
    
    @Override
    public IState Begin(){ return this;}
    @Override
    public IState End(){ return this;}
    
}
