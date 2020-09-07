/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Cards;

import Game.GameWrapper;

/**
 *
 * @author André Oliveira
 */
public class System extends Card {
    private String Nome;
    private int Resist;
    private int Wealth;
    private int Metal;
    private int VictoryP;
    
    public System(String n, int w, int m, int r, int vp){
        this.Nome = n;
        this.Metal = m;
        this.Wealth = w;
        this.Resist = r;
        this.VictoryP = vp;
    }

    
    public String getNome(){
        return this.Nome;
    }
    public int getWealth(){
        return this.Wealth;
    }
    public int getMetal(){
        return this.Metal;
    }
    public int getResist(){
        return this.Resist;
    }
    public int getVP(){
        return this.VictoryP;
    }
    public void setResist(int n){
        this.Resist = this.Resist + n;
    }
    
  
    @Override
    public String EscreveCarta() {
        String Description = "Planeta próximo "  + this.getNome() + " R:" + this.getResist() + "W:"+ this.getWealth() +" M:" + this.getMetal() + " VP:" + this.getVP();
        
        return Description;
        
    }

 

    @Override
    public void doEffect(GameWrapper j) {
        j.getPlayer().setProdMetal(this.getMetal());
        j.getPlayer().setProdWealth(this.getWealth());
        j.getPlayer().setVP(this.getVP());
        
        
    }
    
}
