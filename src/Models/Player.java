/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Cards.System;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author André Oliveira
 */
public class Player implements Serializable{
    private String name;
    private ArrayList<System> conqueredSystems;
   // private ArrayList<Technology> upgraded;
    private static int totMetal = 0;
    private static int totWealth = 0;
    private static int totMilitary = 0;
    private static int prodMetal = 1;
    private static int prodWealth = 1;
    private static int prodMili = 0;
    private static int VictoryPoints = 0;
    /*techs*/
    
    public Player(){
        this.name = "";
        this.conqueredSystems = new ArrayList();
        this.conqueredSystems.add(new System("Homeworld",1,1,0,0));
        
        
    }

    public boolean attack(System s, int n){
        if(s.getResist() > this.getTotMilitar()+ n)
        {
            if(totMilitary > 0)
                totMilitary = totMilitary - 1;
            
            return false;
        }
        else if(s.getResist() < this.getTotMilitar()+n)
        {    
            
            return true;
        }
        else
            return false;
    }
    
    public void AddSystem(System s){
        this.conqueredSystems.add(s);
    }
    
    /*sets*/
    public void setMetal(int n){
        totMetal = totMetal + n;
    }
    public void setMilitar(int n){
        totMilitary = totMilitary + n;
    }
    public void setWealth(int n){
        totWealth = totWealth + n;
    }
    public void setProdWealth(int n){
        prodWealth = prodWealth + n;
    }
    public void setVP(int n){
        VictoryPoints = VictoryPoints + n;
    }
    
    public void setProdMetal(int n){}
    /*gets*/
    public int getTotMilitar(){ return totMilitary;}
    public int getTotWealth(){ return totWealth;}
    public int getTotMetal(){
        return totMetal;
    }
    public String getName(){
        return name;
    }
    public int getProdMili(){return prodMili;}
    public int getProdMetal(){return prodMetal;}
    public int getProdWealth(){return prodWealth;}
    public int getVP(){return VictoryPoints;}
    public ArrayList<System> getConqueredSystems(){
        return this.conqueredSystems;
    }
}
