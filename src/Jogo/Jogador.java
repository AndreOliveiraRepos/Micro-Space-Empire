/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import Cartas.Carta;
import Cartas.Sistema;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author red_f
 */
public class Jogador implements Serializable{
    private String nome;
    private ArrayList<Sistema> conquistados;
   // private ArrayList<Technology> upgraded;
    private static int totMetal = 0;
    private static int totWealth = 0;
    private static int totMilitar = 0;
    private static int prodMetal = 1;
    private static int prodWealth = 1;
    private static int prodMili = 0;
    private static int VictoryPoints = 0;
    /*techs*/
    
    public Jogador(){
        this.nome = "";
        this.conquistados = new ArrayList();
        this.conquistados.add(new Sistema("Homeworld",1,1,0,0));
        
        
    }

    public boolean Ataque(Sistema s,int n){
        if(s.getResist() > this.getTotMilitar()+ n)
        {
            if(totMilitar > 0)
                totMilitar = totMilitar - 1;
            
            return false;
        }
        else if(s.getResist() < this.getTotMilitar()+n)
        {    
            
            return true;
        }
        else
            return false;
    }
    
    public void AddSistema(Sistema s){
        /*draw de uma carta*/
        
        /*tira o primeiro elemento do indice, evento, se conquista adiciona ao conquistados, senao aos desalinhados*/
        this.conquistados.add(s);
    }  
   /* public void AprendeTech(Technology t){
        this.upgraded.add(t);
    }*/
    
    /*sets*/
    public void setMetal(int n){
        totMetal = totMetal + n;
    }
    public void setMilitar(int n){
        totMilitar = totMilitar + n;
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
    public int getTotMilitar(){ return totMilitar;}
    public int getTotWealth(){ return totWealth;}
    public int getTotMetal(){
        return totMetal;
    }
    public String getNome(){
        return nome;
    }
    public int getProdMili(){return prodMili;}
    public int getProdMetal(){return prodMetal;}
    public int getProdWealth(){return prodWealth;}
    public int getVP(){return VictoryPoints;}
    public ArrayList<Sistema> getConquistados(){
        return this.conquistados;
    }
}
