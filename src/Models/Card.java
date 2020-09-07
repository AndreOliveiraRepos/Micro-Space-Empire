/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Cards.System;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author André Oliveira
 */
public class Card extends Observable {
    private Deck decks;
    
    public Card(Deck b){
        this.decks = b;
    
    }
    
    //gets
    public ArrayList<System> getProximos(){return this.decks.getProximos();}
    public ArrayList<System> getLonginquos(){return this.decks.getLonginquos();}
    public ArrayList<Models.Cards.Card> getEventos(){return this.decks.getEventos();}
    public ArrayList<System> getConquistados(){return this.decks.getConquistados();}
    public System getProximo(){
        return this.decks.getProximo();
    }
    
    
    public void setProximos(ArrayList<System> l){
        this.decks.setProximos(l);
        setChanged();
        notifyObservers();
    }
    public void setLonginquos(ArrayList<System> l){
        this.decks.setLonginquos(l);
        setChanged();
        notifyObservers();
    }
    public void setConquistados(ArrayList<System> l){
        this.decks.setConquistados(l);
        setChanged();
        notifyObservers();
    }
    public void setEventos(ArrayList<Models.Cards.Card> l){
        this.decks.setEventos(l);
        setChanged();
        notifyObservers();
    }
    
    
    public void setConquistado(System s){
        this.decks.setConquistado(s);
        setChanged();
        notifyObservers();
    }
    public void setDescarte(Models.Cards.Card c){
        this.decks.setDescarte(c);
        setChanged();
        notifyObservers();
    }
    
   
    
}
