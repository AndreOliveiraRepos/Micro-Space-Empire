/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Game.GameWrapper;

/**
 *
 * @author André Oliveira
 */
public class Fase3 extends StateAdapter {

    public Fase3(GameWrapper j) {
        super (j);
    }
    
    /*Compra evento, Recruit e Tech*/
    
    @Override
    public IEstado Research(int x, int y){ 
        if (this.game.getTechs(x, y).getLearn()) {
            this.game.setSystemMessage("[SISTEMA] Já aprendeste esta tecnologia!");
            return this;
        }
        if (this.game.getPlayer().getTotWealth() < this.game.getTechs(x, y).getCost()) {
            this.game.setSystemMessage("[SISTEMA] Não possui recursos que chegue!");
            return this;
        }
        this.game.getPlayer().setWealth(-this.game.getTechs(x, y).getCost());
        this.game.getTechs(x, y).doEffect(this.game);
        this.game.getTechs(x, y).setLearn(true);
        this.game.setSystemMessage("[SISTEMA] Aprendeu "+ this.game.getTechs(x, y).getNome() +"!");
        return this;
    }
    
    @Override
    public IEstado BuildRecruit(){ 
        if(this.game.getPlayer().getTotMetal() == 0){
            this.game.setSystemMessage("[SISTEMA] Não possui metal que chegue!");
            return this;
        }
        else{
            this.game.getPlayer().setMetal(-1);
        }
        if(this.game.getPlayer().getTotMilitar() == 3)
        {
            if (this.game.getTechs(0, 0).getLearn()) {
                this.game.getPlayer().setMilitar(1);
                this.game.setSystemMessage("[SISTEMA] Adicionou +1 de força militar!");
                return this;
            }
            else{
                return this;
            }
        }
        else
        {    
            if (this.game.getPlayer().getTotMilitar() == 5) {
                return this;
            }
            else
            {   
                this.game.getPlayer().setMilitar(1);
                this.game.setSystemMessage("[SISTEMA] Adicionou +1 de força militar!");
                return this;
            }
        }
    }
    @Override
    public IEstado DrawEvent(){ 
        if(this.game.getEventos().size()> 0){
            this.game.getEventos().get(0).doEffect(this.game);
            this.game.getEventos().remove(0);
            //condiçoes de victoria aqui
            if (this.game.CheckForEndGame()) {
                game.setSystemMessage("Conseguiu " + game.CountPoints() + " Victory Points neste jogo!");
                return new End(this.game);
            }
            else{

                this.game.EndTurn();
                return new Fase1(this.game);
            }
            //return this;
        }
        else
            return this;
    } 
    
    /*@Override
    public IEstado Pass(){
        int r;
        if(this.jogo.getEventos().size() == 0 && this.jogo.getAno() == 1)
        {
            this.jogo.ProximoAno();
            this.jogo.ProximoTurno();
            this.jogo.getEventos().add(new Asteroid());
            this.jogo.getEventos().add(new DerelicShip());
            this.jogo.getEventos().add(new LInvasion());
            this.jogo.getEventos().add(new PaO());
            this.jogo.getEventos().add(new Revolt1());
            this.jogo.getEventos().add(new Revolt2());
            this.jogo.getEventos().add(new SInvasion());
            this.jogo.getEventos().add(new Strike());
            Collections.shuffle(this.jogo.getEventos());
            r = ThreadLocalRandom.current().nextInt(0, this.jogo.getEventos().size());
            jogo.getEventos().remove(r);
            r = ThreadLocalRandom.current().nextInt(0, this.jogo.getEventos().size());
            jogo.getEventos().remove(r);
            Collections.shuffle(jogo.getEventos());

        }   
        else
        {
            this.jogo.ProximoTurno();

        }
        //this.jogo.setMensagemSistema("[SISTEMA] Passou!");
        return new Fase1(this.jogo);
        
    }*/
    
}
