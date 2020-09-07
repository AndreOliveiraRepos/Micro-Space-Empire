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
    private ArrayList<System> longinquos;
    private ArrayList<System> proximos;
    private ArrayList<Card> eventos;
    private ArrayList<Card> descarte;
    private ArrayList<System> conquistados;
    
    public Deck(){
        inicializar();
    }
    
    public void inicializar(){
        this.longinquos = Card.Longinquos();
        this.proximos = Card.Proximos();
        this.eventos = Card.Eventos();
        this.conquistados = new ArrayList();
        this.conquistados.add(new System("Homeworld",1,1,0,0));
    }
    
    
    public ArrayList<System> getProximos(){return this.proximos;}
    public ArrayList<System> getLonginquos(){return this.longinquos;}
    public ArrayList<Card> getEventos(){return this.eventos;}
    public ArrayList<System> getConquistados(){return this.conquistados;}
    
    public void setProximos(ArrayList<System> l){ this.proximos = l;}
    public void setLonginquos(ArrayList<System> l){ this.longinquos = l;}
    public void setConquistados(ArrayList<System> l){ this.conquistados = l;}
    public void setEventos(ArrayList<Card> l){ this.eventos = l;}
    //place listeners
    public void setConquistado(System s){
        this.conquistados.add(s);
    }
    public void setDescarte(Card c){
        this.descarte.add(c);
    }
    
    
    //getProximo, getLong, getEvent
    public System getProximo(){
    System s;
    s = this.proximos.get(0);
    return s;
    }
    
    public System getLonginquo(){
    System s;
    s = this.longinquos.get(0);
    return s;
    }
    
    public System getUltimoConquistado(){
        System s;
        s = this.conquistados.get(this.conquistados.size());
        return s;
    }
    
}

