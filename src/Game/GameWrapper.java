/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Models.Cards.Card;
import Models.Cards.Events.*;
import Models.Cards.System;
import Models.Player;
import State.*;
import Technologies.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author André Oliveira
 */
public class GameWrapper {
    private ArrayList<System> proximos;
    private ArrayList<System> longinquos;
    private ArrayList<System> desalinhados;
    
    private ArrayList<Card> eventos;
    
    
    private Models.Player Player;
    private IEstado estado;
    private boolean strike;
    private boolean diplomacy;
   // private boolean interspecies;
    private Technology[][] Technologies = {
        {new CapitalShips(3),new FowardStarbases(4)},
        {new RobotWorkers(2),new PlanetaryDefenses(4)},
        {new HyperTelevision(3),new InterstellarDiplomacy(5)},
        {new InterspeciesCommerce(2),new InterstellarBanking(3)}
    };
    private static int Ano = 0;
    private static int Turno = 0;
    private static int pontos = 0;
    private String RelatorioCombate;
    private String MensagemSistema = "";
    
    public GameWrapper(){
        /*this.proximos = new ArrayList();*/
        /*burn card*/
        this.desalinhados = new ArrayList();
        this.eventos = new ArrayList();
        
        this.proximos = System.Proximos();
        this.strike = false;
        this.diplomacy = false;
        this.longinquos = System.Longinquos();
        
        Ano = 1;
        estado = null;
        Player = new Player();
        /* a ver*/
        
    }
    
    /*funções do jogo*/
    public void ProximoAno(){
        this.Ano++;
    } 
    public void ProximoTurno(){this.Turno++;}
   
    public void Pass(){
        this.setEstado(this.getEstado().Pass());
    }
    public void DrawClose(){
         this.setEstado(this.getEstado().DrawClose());
    }
    public void DrawDistant(){
        this.setEstado(this.getEstado().DrawDistant());
    }
    
    public void BuildRecruit(){
        this.setEstado(this.getEstado().BuildRecruit());
        
    }
    public void Research(int x,int y){
        this.setEstado(this.getEstado().Research(x, y));
    }
    public void DrawEvent(){
        this.setEstado(this.getEstado().DrawEvent());
    }
    
    public void Commerce(int v){
        this.setEstado(this.getEstado().Commerce(v));
    
    }
    
    public void Conquer(int v){
        this.setEstado(this.getEstado().Conquer(v));
    }
    //fim
    
    public void Iniciar(){ 
        int r;
        Collections.shuffle(this.longinquos);
        Collections.shuffle(this.proximos);
        /*cria baralho eventos*/ 
        this.eventos.add(new Asteroid());
        this.eventos.add(new DerelicShip());
        this.eventos.add(new LInvasion());
        this.eventos.add(new PaO());
        this.eventos.add(new Revolt1());
        this.eventos.add(new Revolt2());
        this.eventos.add(new SInvasion());
        this.eventos.add(new Strike());
        Collections.shuffle(this.eventos);
        r = ThreadLocalRandom.current().nextInt(0, this.eventos.size());
        this.eventos.remove(r);
        Collections.shuffle(this.eventos);
        
        this.Turno = 1;
        this.setEstado(new Fase1(this));
    }

    /*gets*/
    public boolean getDiplomacy(){return this.diplomacy;}
    public boolean getStrike(){return this.strike;}
   // public boolean getInterSpeciesCommerce(){ return this.interspecies;}
    public int getPontos(){return this.pontos;}
    public int getAno(){ return Ano;}
    public ArrayList<System> getProximos(){
        return this.proximos;
    }
    public ArrayList<System> getLonginquos(){
        return this.longinquos;
    }   
    public ArrayList<Card> getEventos(){return this.eventos;}
    public ArrayList<System> getDesalinhas(){return this.desalinhados;}
    public Models.Player getPlayer(){return this.Player;}
    public IEstado getEstado(){ return this.estado;}
    public int getTurno(){return Turno;}
    public String getRelatorioCombate(){return this.RelatorioCombate;}
    public Technology getTechs(int x, int y){ return this.Technologies[x][y];}
    public String getMensagemSistema(){return this.MensagemSistema;}
    
    /*sets*/
    public void setDiplomacy(boolean d){ this.diplomacy = d;}
    public void setStrike(boolean s){this.strike = s;}
    //public void setInterSpecies(boolean s){this.interspecies = s;}
    public void setProximos(ArrayList<System> l){ this.proximos = l;}
    public void setLonginquos(ArrayList<System> l){this.longinquos = l;}
    public void setEstado(IEstado e){ this.estado = e;}
    public void setPontos(int v){this.pontos = v;}
    public void setRelatorioCombat(boolean r, System s, int n){
        if(!r){
            this.RelatorioCombate = "Rolou o numero " + n +"\n";
            this.RelatorioCombate += "Total do ataque-> " + (n+this.getPlayer().getTotMilitar()) + "\n";
            this.RelatorioCombate += "Resistência do Sistema " + s.getNome() +"-> " + s.getResist() + "\n";
            this.RelatorioCombate += "Perdeu este combate!";
            
            
        }
        else{
            this.RelatorioCombate = "Rolou o numero " + n +"\n";
            this.RelatorioCombate += "Total do ataque-> " + (n+this.getPlayer().getTotMilitar()) + "\n";
            this.RelatorioCombate += "Resistência do Sistema " + s.getNome() +"-> " + s.getResist() + "\n";
            this.RelatorioCombate += "Ganhou este combate!";
            
            
        }
        
        
    }
    public void setSystemMessage(String s){this.MensagemSistema += s + "\n";}
    
    
    public String TechsPorAprender(){
        String s = "\n";
        
        for (int i = 0; i < 4; i++) {
            
            if(!this.Technologies[i][0].getLearn()){
               s+=(i+1) + " - " + this.Technologies[i][0].toString() + "\n";
            }
            
        }
        for (int i = 0; i < 4; i++) {
            
            if(!this.Technologies[i][1].getLearn()){
               s+=(i+5) + " - " + this.Technologies[i][1].toString() + "\n";
            }
            
        }
        
        return s;        
    }
    
    
    @Override
    public String toString(){
        String s;
        s = "Ano: " + this.getAno() + " Turno: " + this.getTurno()+ "\n";
        s += "Sistemas controlados:\n";
        for(int i = 0; i < this.getPlayer().getConquistados().size(); i++ ) {
            s+= this.getPlayer().getConquistados().get(i).EscreveCarta() + "\n";
        } 
        
        s+= "Sistemas desalinhados\n";
        for(int i = 0; i < this.desalinhados.size(); i++ ) {
            s+= this.desalinhados.get(i).EscreveCarta()+ "\n";
        } 
        s+= "Armazenamento de metal:"+ this.getPlayer().getTotMetal() + "\nArmazenamento de Wealth:" + this.getPlayer().getTotWealth() + "\nForça Militar:" + this.getPlayer().getTotMilitar();
        s+= "\nProdução de metal:"+ this.getPlayer().getProdMetal() + "\nProdução de Wealth:" + this.getPlayer().getProdWealth() ;
        s+= "\nTem " + this.getEventos().size() + " Eventos";
        return s;
                
    }
    
   
    
    
    
    public void clearRelatorioCombat(){this.RelatorioCombate = null;}    
    public int RolaDado(){
        int i;
        i = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        //i = 6;
        return i;
    }   
    public void saveGame() throws IOException {
        try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("savegame.bin"))) {
            oout.writeObject(this);
        }
    }
    
    public void EndTurn(){
                
        this.setEstado(this.getEstado().Pass());
    }
    
    public boolean CheckForEndGame(){
        if (this.getPlayer().getConquistados().size() == 0) {
            return true;
        }
        if (this.getEventos().size() == 0 && this.getAno() == 2) {
            return true;
        }
        else{
            return false;
        }
    }
    public int CountPoints(){
        int p = this.getPlayer().getVP(), i = 0, totTechs = 0;
        for(i = 0; i < 4; i++){
            if (this.getTechs(i, 0).getLearn()) {
                totTechs++;
                p++;
                if (this.getTechs(i, 1).getLearn()){
                    totTechs++;
                    p++;
                }
            }
        }
        if (totTechs == 8) {
            p++;
        }
        if (this.getLonginquos().size() == 0 && this.getProximos().size()== 0) {
            p++;
            if (this.getPlayer().getConquistados().size() == 11) {
                p = p + 3;
            }
        }
        
        return p;
    }
    /*Testes*/
    public void ActivaGodMode(){
        /*this.getPlayer().setMilitar(5);
        this.getPlayer().setMetal(3);
        this.getPlayer().setWealth(3);*/
        
        
        //dar eventos especificos
        /*this.eventos.removeAll(eventos);
        this.eventos.add(new PaO());*/
        
        //testa diplomacy
        //this.diplomacy = true;
        
        //testa Forward Bases
        //this.getTechs(0,1).setLearn(true);

        //testa Interspecies
        //this.getTechs(3,0).setLearn(true);
        
        //define ano 2
        //this.Ano = 2;
        
        
        //Dar todos os sistemas proximos
        
        /*for (int i = 0; i < this.proximos.size(); i++) {
            this.Player.AddSistema(this.proximos.get(i));
            this.proximos.get(i).doEffect(this);
        }*/
        
        
        
        //Desalinhar x planetas
        //this.getDesalinhas().add(this.getProximos().get(0));
        //this.getDesalinhas().add(this.getProximos().get(1));
        
        
        //set fase 3
        //this.setEstado(new Fase3(this));
        
        //set ineterspecies
        //this.setEstado(new IE(this));
        
        //set end
        //this.setEstado(new End(this).End());
        
        
        
    }

   

}

