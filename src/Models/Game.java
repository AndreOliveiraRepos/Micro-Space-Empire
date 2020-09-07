/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Cards.Card;
import Models.Cards.System;
import State.IEstado;
import Game.GameWrapper;
import Technologies.Technology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;


/**
 *
 * @author André Oliveira
 */
public class Game extends Observable {
    private GameWrapper game;
    private String cartaDestacada;
    private static Map<String,String>imagens;
    static{
        imagens = new HashMap<>();
        
        //sistemas
        imagens.put("Canopus","img/sistemas/canopus.png");
        imagens.put("Cygnus","img/sistemas/cygnus.png");
        imagens.put("Galaxy's Edge","img/sistemas/edge.png");
        imagens.put("Epsilon Erida","img/sistemas/epsilon.png");
        imagens.put("Homeworld","img/sistemas/home.png");
        imagens.put("Polaris","img/sistemas/polaris.png");
        imagens.put("Procyon","img/sistemas/procyon.png");
        imagens.put("Proxima","img/sistemas/proxima.png");
        imagens.put("Sirius","img/sistemas/sirius.png");
        imagens.put("Tau Ceti","img/sistemas/tau.png");
        imagens.put("Wolf 359","img/sistemas/wolf.png");
        
        
        
        //eventos
        
        imagens.put("Asteroid","img/eventos/asteroid.png");//
        imagens.put("Large Invasion","img/eventos/linvasion.png");//
        imagens.put("Peace and Order","img/eventos/pao.png");//
        imagens.put("Revolt 1","img/eventos/revolt.png");//
        imagens.put("Revolt 2","img/eventos/revolt2.png");
        imagens.put("Derelic Ship","img/eventos/ship.png");//
        imagens.put("Small Invasion","img/eventos/sinvasion.png");//
        imagens.put("Strike","img/eventos/strike.png");
        
        
    }
    public Game() {
        game = new GameWrapper();
        
    }
    
    public void Iniciar(){
        
        this.game.Iniciar();
        this.game.ActivaGodMode();
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
        //this.setMensagemSistema("[SISTEMA]A iniciar");
        
        //System.out.println(jogo.getMensagemSistema());
    }
    public void setCartaDestacada(String s){
    //chama setCartaDestacada do ModeloCarta
        cartaDestacada = s;
        
    }
    public String getCartaDestacada(){return this.cartaDestacada;}
    
    
    public IEstado getEstado(){
        
        
        return game.getEstado();
    }
    
    public String getNomeEstado(){
        String s;
        s = this.game.getEstado().toString();
        return s;
    }
    
    public int getAno(){
        return game.getAno();
    }
    public int getTurno(){
        return game.getTurno();
    }
    
    public void setMensagemSistema(String s){
        game.setSystemMessage(s);
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    public void setEstado(IEstado e){//ou proximo estado
        this.game.setEstado(e);
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    
    public String getMensagemSistema(){
        return game.getMensagemSistema();
    }
    public String getRelatorioCombate(){
        return game.getRelatorioCombate();
    }
    
    public void PassarFase(){
        game.Pass();
        
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    public void CompraProximo(){
        
        setCartaDestacada(imagens.get(game.getProximos().get(0).getNome()));
    //jogo.setEstado(new Fase1(jogo));//debug
        this.setEstado(game.getEstado().DrawClose());
        java.lang.System.out.println(game.getMensagemSistema());
        setMensagemSistema(game.getMensagemSistema());
            
       
    }
    
    public void CompraDistante(){
        
        
        setCartaDestacada(imagens.get(game.getLonginquos().get(0).getNome()));
        this.setEstado(game.getEstado().DrawDistant());
        setMensagemSistema(game.getMensagemSistema());
        /*else
        {
            this.setMensagemSistema("[SISTEMA]Não possui a tecnologia\nnecessária");
        }*/
    }
    
    public ArrayList<System> getConquistados(){
        return this.game.getPlayer().getConquistados();
    }
     public ArrayList<System> getDesalinhados(){
        return this.game.getDesalinhas();
    }
    public int getTamanhoConquistados(){
        return game.getPlayer().getConquistados().size();
    }
    
    public int getPoints(){
        return game.CountPoints();
    }
   
    public int getTamanhoProximos(){
        return game.getProximos().size();
    }
    public int getTamanhoDistantes(){
        return game.getLonginquos().size();
    }
    
    public int getTamanhoDesalinhados(){
        return game.getDesalinhas().size();
    }
    
    public String getImagem(String nome){
        return imagens.get(nome);
    }
    
    public Technology getTechs(int x, int y){ return this.game.getTechs(x, y);}
    
    public int getTotMilitar(){
        return this.game.getPlayer().getTotMilitar();
    }
    
    public int getTotMetal(){
        return this.game.getPlayer().getTotMetal();
    }
    
    public int getTotWealth(){
        return this.game.getPlayer().getTotWealth();
    }
    
    public void Recruta(){
        
        this.game.BuildRecruit();
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    public void Research(int x, int y){
        this.game.Research(x,y);
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    public ArrayList<Card> getEventos(){return this.game.getEventos();}
    public void CompraEvento(){
        
        setCartaDestacada(imagens.get(game.getEventos().get(0).getNome()));
        //jogo.setEstado(new Fase1(jogo));//debug
        this.setEstado(game.getEstado().DrawEvent());
        //this.setMensagemSistema(this.jogo.getEventos().get(0).EscreveCarta());
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    public void Commerce(int v){
        this.game.Commerce(v);
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    public void Conquer(int v){
        this.setEstado(game.getEstado().Conquer(v));
        
    }
}
