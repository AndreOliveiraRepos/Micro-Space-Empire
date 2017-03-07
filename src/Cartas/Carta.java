/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas;
import Jogo.Jogo;

import Cartas.Eventos.*;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author red_f
 */
public abstract class Carta implements Serializable {
    private String nome;
    public Carta(){}
    
    public abstract void doEffect(Jogo j);
    
    public abstract String EscreveCarta();
    
    //public abstract String toString();
    
    public static ArrayList<Sistema> Proximos(){
     ArrayList p = new ArrayList();
     p.add(new Sistema("Cygnus", 1 , 0, 5, 1));
     p.add(new Sistema("Tau Ceti",0,0,4,1));
     p.add(new Sistema("Procyon",1,0,7,1));
     p.add(new Sistema("Wolf 359",0,1,5,1));
     p.add(new Sistema("Epsilon Erida",0,0,8,1));
     p.add(new Sistema("Canopus",1,0,9,2));
     p.add(new Sistema("Proxima",0,1,6,1));
     return p;
    }
    
    public static ArrayList<Sistema> Longinquos(){
     ArrayList l = new ArrayList();
     l.add(new Sistema("Galaxy's Edge",0,0,10,3));
     l.add(new Sistema("Polaris",0,1,9,2));
     l.add(new Sistema("Sirius",0,0,6,1));
     return l;
    }
    
    /* baralho de eventos */
    
    public static ArrayList<Carta> Eventos(){
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

