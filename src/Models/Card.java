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
    public ArrayList<System> getNearSystems(){return this.decks.getNearSystems();}
    public ArrayList<System> getDistantSystems(){return this.decks.getDistantSystems();}
    public ArrayList<Models.Cards.Card> getEvents(){return this.decks.getEvents();}
    public ArrayList<System> getConquered(){return this.decks.getConquered();}
    public System getNearbySystem(){
        return this.decks.getNearbySystem();
    }
    
    
    public void setNearSystems(ArrayList<System> l){
        this.decks.setNearSystems(l);
        setChanged();
        notifyObservers();
    }
    public void setDistantSystems(ArrayList<System> l){
        this.decks.setDistantSystems(l);
        setChanged();
        notifyObservers();
    }
    public void setConquered(ArrayList<System> l){
        this.decks.setConquered(l);
        setChanged();
        notifyObservers();
    }
    public void setEvents(ArrayList<Models.Cards.Card> l){
        this.decks.setEvents(l);
        setChanged();
        notifyObservers();
    }
    
    
    public void setConquered(System s){
        this.decks.setConquered(s);
        setChanged();
        notifyObservers();
    }
    public void setDiscard(Models.Cards.Card c){
        this.decks.setDiscard(c);
        setChanged();
        notifyObservers();
    }
    
   
    
}
