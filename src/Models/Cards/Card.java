/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Cards;
import Game.GameWrapper;

import Models.Cards.Events.*;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author André Oliveira
 */
public abstract class Card implements Serializable {
    private String name;
    public Card(){}
    
    public abstract void doEffect(GameWrapper j);
    
    public abstract String WriteCard();
    
    //public abstract String toString();
    
    public static ArrayList<System> nearbySystems(){
     ArrayList p = new ArrayList();
     p.add(new System("Cygnus", 1 , 0, 5, 1));
     p.add(new System("Tau Ceti",0,0,4,1));
     p.add(new System("Procyon",1,0,7,1));
     p.add(new System("Wolf 359",0,1,5,1));
     p.add(new System("Epsilon Erida",0,0,8,1));
     p.add(new System("Canopus",1,0,9,2));
     p.add(new System("Proxima",0,1,6,1));
     return p;
    }
    
    public static ArrayList<System> distantSystems(){
     ArrayList l = new ArrayList();
     l.add(new System("Galaxy's Edge",0,0,10,3));
     l.add(new System("Polaris",0,1,9,2));
     l.add(new System("Sirius",0,0,6,1));
     return l;
    }
    
    /* baralho de eventos */
    
    public static ArrayList<Card> events(){
        ArrayList events = new ArrayList();
        events.add(new Asteroid());
        events.add(new DerelicShip());
        events.add(new LInvasion());
        events.add(new PaO());
        events.add(new Revolt1());
        events.add(new Revolt2());
        events.add(new SInvasion());
        events.add(new Strike());
        return events;
    }
    
    public String getName(){return this.name;}
    public void setName(String s){this.name = s;}
}

