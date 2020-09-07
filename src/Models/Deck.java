/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Cards.Card;
import Models.Cards.System;

import java.util.ArrayList;

/**
 *
 * @author André Oliveira
 */
public class Deck {
    private ArrayList<System> distantSystems;
    private ArrayList<System> nearSystems;
    private ArrayList<Card> events;
    private ArrayList<Card> discard;
    private ArrayList<System> conquered;
    
    public Deck(){
        inicialize();
    }
    
    public void inicialize(){
        this.distantSystems = Card.distantSystems();
        this.nearSystems = Card.nearbySystems();
        this.events = Card.events();
        this.conquered = new ArrayList();
        this.conquered.add(new System("Homeworld",1,1,0,0));
    }
    
    
    public ArrayList<System> getNearSystems(){return this.nearSystems;}
    public ArrayList<System> getDistantSystems(){return this.distantSystems;}
    public ArrayList<Card> getEvents(){return this.events;}
    public ArrayList<System> getConquered(){return this.conquered;}
    
    public void setNearSystems(ArrayList<System> l){ this.nearSystems = l;}
    public void setDistantSystems(ArrayList<System> l){ this.distantSystems = l;}
    public void setConquered(ArrayList<System> l){ this.conquered = l;}
    public void setEvents(ArrayList<Card> l){ this.events = l;}
    //place listeners
    public void setConquered(System s){
        this.conquered.add(s);
    }
    public void setDiscard(Card c){
        this.discard.add(c);
    }
    
    
    //getProximo, getLong, getEvent
    public System getNearbySystem(){
    System s;
    s = this.nearSystems.get(0);
    return s;
    }
    
    public System getDistantSystem(){
    System s;
    s = this.distantSystems.get(0);
    return s;
    }
    
    public System getLastConqueredSystem(){
        System s;
        s = this.conquered.get(this.conquered.size());
        return s;
    }
    
}

