/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Cards.Card;
import Models.Cards.System;
import State.IState;
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
    private String highlightedCard;
    private static Map<String,String> images;
    static{
        images = new HashMap<>();
        
        //sistemas
        images.put("Canopus","img/sistems/canopus.png");
        images.put("Cygnus","img/sistems/cygnus.png");
        images.put("Galaxy's Edge","img/sistems/edge.png");
        images.put("Epsilon Erida","img/sistems/epsilon.png");
        images.put("Homeworld","img/sistems/home.png");
        images.put("Polaris","img/sistems/polaris.png");
        images.put("Procyon","img/sistems/procyon.png");
        images.put("Proxima","img/sistems/proxima.png");
        images.put("Sirius","img/sistems/sirius.png");
        images.put("Tau Ceti","img/sistems/tau.png");
        images.put("Wolf 359","img/sistems/wolf.png");
        
        
        
        //eventos
        
        images.put("Asteroid","img/events/asteroid.png");//
        images.put("Large Invasion","img/events/linvasion.png");//
        images.put("Peace and Order","img/events/pao.png");//
        images.put("Revolt 1","img/events/revolt.png");//
        images.put("Revolt 2","img/events/revolt2.png");
        images.put("Derelic Ship","img/events/ship.png");//
        images.put("Small Invasion","img/events/sinvasion.png");//
        images.put("Strike","img/events/strike.png");
        
        
    }
    public Game() {
        game = new GameWrapper();
        
    }
    
    public void initialize(){
        
        this.game.begin();
        this.game.ActivateGodMode();
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
        //this.setMensagemSistema("[SISTEMA]A iniciar");
        
        //System.out.println(jogo.getMensagemSistema());
    }
    public void setHighlightedCard(String s){
    //chama setCartaDestacada do ModeloCarta
        highlightedCard = s;
        
    }
    public String getHighlightedCard(){return this.highlightedCard;}
    
    
    public IState getState(){
        
        
        return game.getState();
    }
    
    public String getStateName(){
        String s;
        s = this.game.getState().toString();
        return s;
    }
    
    public int getYear(){
        return game.getYear();
    }
    public int getTurn(){
        return game.getTurn();
    }
    
    public void setSystemMessage(String s){
        game.setSystemMessage(s);
        setChanged();
        notifyObservers();
    }
    
    public void setState(IState e){
        this.game.setState(e);
        setChanged();
        notifyObservers();
    }
    
    
    public String getSystemMessage(){
        return game.getSystemMessage();
    }
    public String getCombatReport(){
        return game.getCombatReport();
    }
    
    public void nextPhase(){
        game.Pass();
        
        setChanged();
        notifyObservers();
    }
    public void drawNearSystem(){
        
        setHighlightedCard(images.get(game.getNearSystems().get(0).getName()));
        this.setState(game.getState().DrawClose());
        java.lang.System.out.println(game.getSystemMessage());
        setSystemMessage(game.getSystemMessage());
            
       
    }
    
    public void drawDistantSystem(){
        
        
        setHighlightedCard(images.get(game.getDistantSystems().get(0).getName()));
        this.setState(game.getState().DrawDistant());
        setSystemMessage(game.getSystemMessage());
    }
    
    public ArrayList<System> getConqueredSystems(){
        return this.game.getPlayer().getConqueredSystems();
    }
    public ArrayList<System> getUnaligned(){
        return this.game.getUnaligned();
    }
    public int getConqueredSize(){
        return game.getPlayer().getConqueredSystems().size();
    }
    
    public int getPoints(){
        return game.CountPoints();
    }
   
    public int getNearSystemsSize(){
        return game.getNearSystems().size();
    }
    public int getDistantSystemsSize(){
        return game.getDistantSystems().size();
    }
    
    public int getUnalignedSize(){
        return game.getUnaligned().size();
    }
    
    public String getImage(String name){
        return images.get(name);
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
    
    public void buildRecruit(){
        
        this.game.BuildRecruit();
        setChanged();
        notifyObservers();
    }
    
    public void Research(int x, int y){
        this.game.Research(x,y);
        setChanged();
        notifyObservers();
    }
    
    public ArrayList<Card> getEvents(){return this.game.getEvents();}
    public void drawEvent(){
        
        setHighlightedCard(images.get(game.getEvents().get(0).getName()));
        this.setState(game.getState().DrawEvent());
        setChanged();
        notifyObservers();
    }
    
    public void Commerce(int v){
        this.game.Commerce(v);
        setChanged();
        notifyObservers();
    }
    
    public void Conquer(int v){
        this.setState(game.getState().Conquer(v));
    }
}
