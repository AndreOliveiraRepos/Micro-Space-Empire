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
    private ArrayList<System> nearSystems;
    private ArrayList<System> distantSystems;
    private ArrayList<System> unaligned;
    
    private ArrayList<Card> events;
    
    
    private Models.Player Player;
    private IState state;
    private boolean strike;
    private boolean diplomacy;
   // private boolean interspecies;
    private Technology[][] Technologies = {
        {new CapitalShips(3),new FowardStarbases(4)},
        {new RobotWorkers(2),new PlanetaryDefenses(4)},
        {new HyperTelevision(3),new InterstellarDiplomacy(5)},
        {new InterspeciesCommerce(2),new InterstellarBanking(3)}
    };
    private static int year = 0;
    private static int turn = 0;
    private static int points = 0;
    private String combatReport;
    private String systemMessage = "";
    
    public GameWrapper(){
        /*this.proximos = new ArrayList();*/
        /*burn card*/
        this.unaligned = new ArrayList();
        this.events = new ArrayList();
        
        this.nearSystems = System.nearbySystems();
        this.strike = false;
        this.diplomacy = false;
        this.distantSystems = System.distantSystems();
        
        year = 1;
        state = null;
        Player = new Player();
        /* a ver*/
        
    }
    
    /*funções do jogo*/
    public void nextYear(){
        this.year++;
    } 
    public void nextTurn(){this.turn++;}
   
    public void Pass(){
        this.setState(this.getState().Pass());
    }
    public void DrawClose(){
         this.setState(this.getState().DrawClose());
    }
    public void DrawDistant(){
        this.setState(this.getState().DrawDistant());
    }
    
    public void BuildRecruit(){
        this.setState(this.getState().BuildRecruit());
        
    }
    public void Research(int x,int y){
        this.setState(this.getState().Research(x, y));
    }
    public void DrawEvent(){
        this.setState(this.getState().DrawEvent());
    }
    
    public void Commerce(int v){
        this.setState(this.getState().Commerce(v));
    
    }
    
    public void Conquer(int v){
        this.setState(this.getState().Conquer(v));
    }
    //fim
    
    public void begin(){
        int r;
        Collections.shuffle(this.distantSystems);
        Collections.shuffle(this.nearSystems);
        /*create event deck*/
        this.events.add(new Asteroid());
        this.events.add(new DerelicShip());
        this.events.add(new LInvasion());
        this.events.add(new PaO());
        this.events.add(new Revolt1());
        this.events.add(new Revolt2());
        this.events.add(new SInvasion());
        this.events.add(new Strike());
        Collections.shuffle(this.events);
        r = ThreadLocalRandom.current().nextInt(0, this.events.size());
        this.events.remove(r);
        Collections.shuffle(this.events);
        
        this.turn = 1;
        this.setState(new Phase1(this));
    }

    /*gets*/
    public boolean getDiplomacy(){return this.diplomacy;}
    public boolean getStrike(){return this.strike;}
   // public boolean getInterSpeciesCommerce(){ return this.interspecies;}
    public int getPoints(){return this.points;}
    public int getYear(){ return year;}
    public ArrayList<System> getNearSystems(){
        return this.nearSystems;
    }
    public ArrayList<System> getDistantSystems(){
        return this.distantSystems;
    }   
    public ArrayList<Card> getEvents(){return this.events;}
    public ArrayList<System> getUnaligned(){return this.unaligned;}
    public Models.Player getPlayer(){return this.Player;}
    public IState getState(){ return this.state;}
    public int getTurn(){return turn;}
    public String getCombatReport(){return this.combatReport;}
    public Technology getTechs(int x, int y){ return this.Technologies[x][y];}
    public String getSystemMessage(){return this.systemMessage;}
    
    /*sets*/
    public void setDiplomacy(boolean d){ this.diplomacy = d;}
    public void setStrike(boolean s){this.strike = s;}
    //public void setInterSpecies(boolean s){this.interspecies = s;}
    public void setNearSystems(ArrayList<System> l){ this.nearSystems = l;}
    public void setDistantSystems(ArrayList<System> l){this.distantSystems = l;}
    public void setState(IState e){ this.state = e;}
    public void setPoints(int v){this.points = v;}
    public void setCombatReport(boolean r, System s, int n){
        if(!r){
            this.combatReport = "Rolou o numero " + n +"\n";
            this.combatReport += "Total do ataque-> " + (n+this.getPlayer().getTotMilitar()) + "\n";
            this.combatReport += "Resistência do Sistema " + s.getName() +"-> " + s.getResist() + "\n";
            this.combatReport += "Perdeu este combate!";
            
            
        }
        else{
            this.combatReport = "Rolou o numero " + n +"\n";
            this.combatReport += "Total do ataque-> " + (n+this.getPlayer().getTotMilitar()) + "\n";
            this.combatReport += "Resistência do Sistema " + s.getName() +"-> " + s.getResist() + "\n";
            this.combatReport += "Ganhou este combate!";
            
            
        }
        
        
    }
    public void setSystemMessage(String s){this.systemMessage += s + "\n";}
    
    
    public String LearnableTechnologies(){
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
        s = "Ano: " + this.getYear() + " Turno: " + this.getTurn()+ "\n";
        s += "Sistemas controlados:\n";
        for(int i = 0; i < this.getPlayer().getConqueredSystems().size(); i++ ) {
            s+= this.getPlayer().getConqueredSystems().get(i).WriteCard() + "\n";
        } 
        
        s+= "Sistemas desalinhados\n";
        for(int i = 0; i < this.unaligned.size(); i++ ) {
            s+= this.unaligned.get(i).WriteCard()+ "\n";
        } 
        s+= "Armazenamento de metal:"+ this.getPlayer().getTotMetal() + "\nArmazenamento de Wealth:" + this.getPlayer().getTotWealth() + "\nForça Militar:" + this.getPlayer().getTotMilitar();
        s+= "\nProdução de metal:"+ this.getPlayer().getProdMetal() + "\nProdução de Wealth:" + this.getPlayer().getProdWealth() ;
        s+= "\nTem " + this.getEvents().size() + " Eventos";
        return s;
                
    }
    
   
    
    
    
    public void clearCombatReport(){this.combatReport = null;}
    public int RollDice(){
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
                
        this.setState(this.getState().Pass());
    }
    
    public boolean CheckForEndGame(){
        if (this.getPlayer().getConqueredSystems().size() == 0) {
            return true;
        }
        if (this.getEvents().size() == 0 && this.getYear() == 2) {
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
        if (this.getDistantSystems().size() == 0 && this.getNearSystems().size()== 0) {
            p++;
            if (this.getPlayer().getConqueredSystems().size() == 11) {
                p = p + 3;
            }
        }
        
        return p;
    }
    /*Testes*/
    public void ActivateGodMode(){
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

