/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Cartas.Sistema;
import Jogo.Jogador;
import Jogo.Jogo;
import Technologies.Technology;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author red_f
 */
public abstract class EstadoAdapter implements IEstado, Serializable {
    public Jogo jogo;
    
    public EstadoAdapter(Jogo j){
        this.jogo = j;
    }
    
    /*gets*/
    public Jogo getJogo(){
        return this.jogo;
    }
    
    /*sets*/
    public void setJogo(Jogo j){
        this.jogo = j;
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
