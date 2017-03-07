/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Cartas.Carta;
import Cartas.Sistema;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author red_f
 */
public class Baralhos {
    private ArrayList<Sistema> longinquos;
    private ArrayList<Sistema> proximos;
    private ArrayList<Carta> eventos;
    private ArrayList<Carta> descarte;
    private ArrayList<Sistema> conquistados;
    
    public Baralhos(){
        inicializar();
    }
    
    public void inicializar(){
        this.longinquos = Carta.Longinquos();
        this.proximos = Carta.Proximos();
        this.eventos = Carta.Eventos();
        this.conquistados = new ArrayList();
        this.conquistados.add(new Sistema("Homeworld",1,1,0,0));
    }
    
    
    public ArrayList<Sistema> getProximos(){return this.proximos;}
    public ArrayList<Sistema> getLonginquos(){return this.longinquos;}
    public ArrayList<Carta> getEventos(){return this.eventos;}
    public ArrayList<Sistema> getConquistados(){return this.conquistados;}
    
    public void setProximos(ArrayList<Sistema> l){ this.proximos = l;}
    public void setLonginquos(ArrayList<Sistema> l){ this.longinquos = l;}
    public void setConquistados(ArrayList<Sistema> l){ this.conquistados = l;}
    public void setEventos(ArrayList<Carta> l){ this.eventos = l;}
    //place listeners
    public void setConquistado(Sistema s){
        this.conquistados.add(s);
    }
    public void setDescarte(Carta c){
        this.descarte.add(c);
    }
    
    
    //getProximo, getLong, getEvent
    public Sistema getProximo(){
    Sistema s;
    s = this.proximos.get(0);
    return s;
    }
    
    public Sistema getLonginquo(){
    Sistema s;
    s = this.longinquos.get(0);
    return s;
    }
    
    public Sistema getUltimoConquistado(){
        Sistema s;
        s = this.conquistados.get(this.conquistados.size());
        return s;
    }
    
}

