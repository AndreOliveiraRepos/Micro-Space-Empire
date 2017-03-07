/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Cartas.Carta;
import Cartas.Sistema;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author red_f
 */
public class ModeloCartas extends Observable {
    private Baralhos baralhos;
    
    public ModeloCartas(Baralhos b){
        this.baralhos = b;
    
    }
    
    //gets
    public ArrayList<Sistema> getProximos(){return this.baralhos.getProximos();}
    public ArrayList<Sistema> getLonginquos(){return this.baralhos.getLonginquos();}
    public ArrayList<Carta> getEventos(){return this.baralhos.getEventos();}
    public ArrayList<Sistema> getConquistados(){return this.baralhos.getConquistados();}
    public Sistema getProximo(){
        return this.baralhos.getProximo();
    }
    
    
    public void setProximos(ArrayList<Sistema> l){ 
        this.baralhos.setProximos(l);
        setChanged();
        notifyObservers();
    }
    public void setLonginquos(ArrayList<Sistema> l){ 
        this.baralhos.setLonginquos(l);
        setChanged();
        notifyObservers();
    }
    public void setConquistados(ArrayList<Sistema> l){ 
        this.baralhos.setConquistados(l);
        setChanged();
        notifyObservers();
    }
    public void setEventos(ArrayList<Carta> l){ 
        this.baralhos.setEventos(l);
        setChanged();
        notifyObservers();
    }
    
    
    public void setConquistado(Sistema s){
        this.baralhos.setConquistado(s);
        setChanged();
        notifyObservers();
    }
    public void setDescarte(Carta c){
        this.baralhos.setDescarte(c);
        setChanged();
        notifyObservers();
    }
    
   
    
}
