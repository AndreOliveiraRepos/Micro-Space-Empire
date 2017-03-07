/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Cartas.Carta;
import Cartas.Sistema;
import Estado.Fase1;
import Estado.IEstado;
import Jogo.Jogo;
import Technologies.Technology;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.Set;


/**
 *
 * @author red_f
 */
public class ModeloJogo extends Observable {
    private Jogo jogo;
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
    public ModeloJogo() {
        jogo = new Jogo();
        
    }
    
    public void Iniciar(){
        
        this.jogo.Iniciar();
        this.jogo.ActivaGodMode();
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
        
        
        return jogo.getEstado();
    }
    
    public String getNomeEstado(){
        String s;
        s = this.jogo.getEstado().toString();
        return s;
    }
    
    public int getAno(){
        return jogo.getAno();
    }
    public int getTurno(){
        return jogo.getTurno();
    }
    
    public void setMensagemSistema(String s){
        jogo.setMensagemSistema(s);
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    public void setEstado(IEstado e){//ou proximo estado
        this.jogo.setEstado(e);
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    
    public String getMensagemSistema(){
        return jogo.getMensagemSistema();
    }
    public String getRelatorioCombate(){
        return jogo.getRelatorioCombate();
    }
    
    public void PassarFase(){
        jogo.Pass();
        
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    public void CompraProximo(){
        
        setCartaDestacada(imagens.get(jogo.getProximos().get(0).getNome()));
    //jogo.setEstado(new Fase1(jogo));//debug
        this.setEstado(jogo.getEstado().DrawClose());
        System.out.println(jogo.getMensagemSistema());
        setMensagemSistema(jogo.getMensagemSistema());
            
       
    }
    
    public void CompraDistante(){
        
        
        setCartaDestacada(imagens.get(jogo.getLonginquos().get(0).getNome()));
        this.setEstado(jogo.getEstado().DrawDistant());
        setMensagemSistema(jogo.getMensagemSistema());
        /*else
        {
            this.setMensagemSistema("[SISTEMA]Não possui a tecnologia\nnecessária");
        }*/
    }
    
    public ArrayList<Sistema> getConquistados(){
        return this.jogo.getPlayer().getConquistados();
    }
     public ArrayList<Sistema> getDesalinhados(){
        return this.jogo.getDesalinhas();
    }
    public int getTamanhoConquistados(){
        return jogo.getPlayer().getConquistados().size();
    }
    
    public int getPoints(){
        return jogo.CountPoints();
    }
   
    public int getTamanhoProximos(){
        return jogo.getProximos().size();
    }
    public int getTamanhoDistantes(){
        return jogo.getLonginquos().size();
    }
    
    public int getTamanhoDesalinhados(){
        return jogo.getDesalinhas().size();
    }
    
    public String getImagem(String nome){
        return imagens.get(nome);
    }
    
    public Technology getTechs(int x, int y){ return this.jogo.getTechs(x, y);}
    
    public int getTotMilitar(){
        return this.jogo.getPlayer().getTotMilitar();
    }
    
    public int getTotMetal(){
        return this.jogo.getPlayer().getTotMetal();
    }
    
    public int getTotWealth(){
        return this.jogo.getPlayer().getTotWealth();
    }
    
    public void Recruta(){
        
        this.jogo.BuildRecruit();
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    public void Research(int x, int y){
        this.jogo.Research(x,y);
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    public ArrayList<Carta> getEventos(){return this.jogo.getEventos();}
    public void CompraEvento(){
        
        setCartaDestacada(imagens.get(jogo.getEventos().get(0).getNome()));
        //jogo.setEstado(new Fase1(jogo));//debug
        this.setEstado(jogo.getEstado().DrawEvent());
        //this.setMensagemSistema(this.jogo.getEventos().get(0).EscreveCarta());
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    public void Commerce(int v){
        this.jogo.Commerce(v);
        setChanged(); // o modelo sofreu alterações
        notifyObservers();
    }
    
    public void Conquer(int v){
        this.setEstado(jogo.getEstado().Conquer(v));
        
    }
}
