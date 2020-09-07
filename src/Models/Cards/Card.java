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
    private String nome;
    public Card(){}
    
    public abstract void doEffect(GameWrapper j);
    
    public abstract String EscreveCarta();
    
    //public abstract String toString();
    
    public static ArrayList<System> Proximos(){
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
    
    public static ArrayList<System> Longinquos(){
     ArrayList l = new ArrayList();
     l.add(new System("Galaxy's Edge",0,0,10,3));
     l.add(new System("Polaris",0,1,9,2));
     l.add(new System("Sirius",0,0,6,1));
     return l;
    }
    
    /* baralho de eventos */
    
    public static ArrayList<Card> Eventos(){
        ArrayList eventos = new ArrayList();
        eventos.add(new Asteroid());
        eventos.add(new DerelicShip());
        eventos.add(new LInvasion());
        eventos.add(new PaO());
        eventos.add(new Revolt1());
        eventos.add(new Revolt2());
        eventos.add(new SInvasion());
        eventos.add(new Strike());
        return eventos;
    }
    
    public String getNome(){return this.nome;}
    public void setNome(String s){this.nome = s;}
}

