/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Cartas.Eventos.Asteroid;
import Cartas.Eventos.DerelicShip;
import Cartas.Eventos.LInvasion;
import Cartas.Eventos.PaO;
import Cartas.Eventos.Revolt1;
import Cartas.Eventos.Revolt2;
import Cartas.Eventos.SInvasion;
import Cartas.Eventos.Strike;
import Jogo.Jogador;
import Jogo.Jogo;
import Technologies.Technology;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author red_f
 */
public class Fase3 extends EstadoAdapter{

    public Fase3(Jogo j) {
        super (j);
    }
    
    /*Compra evento, Recruit e Tech*/
    
    @Override
    public IEstado Research(int x, int y){ 
        if (this.jogo.getTechs(x, y).getLearn()) {
            this.jogo.setMensagemSistema("[SISTEMA] Já aprendeste esta tecnologia!");
            return this;
        }
        if (this.jogo.getPlayer().getTotWealth() < this.jogo.getTechs(x, y).getCost()) {
            this.jogo.setMensagemSistema("[SISTEMA] Não possui recursos que chegue!");
            return this;
        }
        this.jogo.getPlayer().setWealth(-this.jogo.getTechs(x, y).getCost());
        this.jogo.getTechs(x, y).doEffect(this.jogo);
        this.jogo.getTechs(x, y).setLearn(true);
        this.jogo.setMensagemSistema("[SISTEMA] Aprendeu "+ this.jogo.getTechs(x, y).getNome() +"!");
        return this;
    }
    
    @Override
    public IEstado BuildRecruit(){ 
        if(this.jogo.getPlayer().getTotMetal() == 0){
            this.jogo.setMensagemSistema("[SISTEMA] Não possui metal que chegue!");
            return this;
        }
        else{
            this.jogo.getPlayer().setMetal(-1);
        }
        if(this.jogo.getPlayer().getTotMilitar() == 3)
        {
            if (this.jogo.getTechs(0, 0).getLearn()) {
                this.jogo.getPlayer().setMilitar(1);
                this.jogo.setMensagemSistema("[SISTEMA] Adicionou +1 de força militar!");
                return this;
            }
            else{
                return this;
            }
        }
        else
        {    
            if (this.jogo.getPlayer().getTotMilitar() == 5) {
                return this;
            }
            else
            {   
                this.jogo.getPlayer().setMilitar(1);
                this.jogo.setMensagemSistema("[SISTEMA] Adicionou +1 de força militar!");
                return this;
            }
        }
    }
    @Override
    public IEstado DrawEvent(){ 
        if(this.jogo.getEventos().size()> 0){
            this.jogo.getEventos().get(0).doEffect(this.jogo);
            this.jogo.getEventos().remove(0);
            //condiçoes de victoria aqui
            if (this.jogo.CheckForEndGame()) {
                jogo.setMensagemSistema("Conseguiu " + jogo.CountPoints() + " Victory Points neste jogo!");
                return new End(this.jogo);
            }
            else{

                this.jogo.EndTurn();
                return new Fase1(this.jogo);
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
