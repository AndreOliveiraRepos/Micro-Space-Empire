/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technologies;

import Cartas.Sistema;
import Jogo.Jogador;
import Jogo.Jogo;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author red_f
 */
public abstract class Technology implements Serializable{
    
    
    private int cost;
    private boolean learn;
    private String nome;
    
    
    public Technology(int c){
        this.nome = "";
        this.cost = c;
        this.learn = false;
        
    }
    
    /*gets*/
    public int getCost(){ return this.cost;} 
    public boolean getLearn(){ return this.learn;}
    public String getNome(){return this.nome;}
    
    /*sets*/
    public void setLearn(boolean v){ this.learn = v;}
    public void setNome(String s){this.nome = s;};
    public abstract void doEffect(Jogo j);
    
    @Override
    public abstract String toString();
        
   
    
}
