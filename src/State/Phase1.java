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
public class Phase1 extends StateAdapter {
    public Phase1(GameWrapper j)
    {
        super(j);
        this.game.setSystemMessage("[SISTEMA] Phase 1");
    }
    @Override
    public IState Begin(){ 
        return this;
    
    }
    
    @Override
    public IState DrawClose(){
        
        int r = this.game.RollDice();
        if(this.game.getDiplomacy()){
            this.game.getPlayer().AddSystem(this.game.getNearSystems().get(0));
            this.game.getNearSystems().get(0).doEffect(this.game);
            this.game.getNearSystems().remove(0);
            this.game.setDiplomacy(false);
            this.game.setSystemMessage("[SISTEMA]Sistema Conquistado por Diplomacia");
            if(this.game.getTechs(3,0).getLearn()){
                    if(this.game.getPlayer().getTotMetal() < 5)
                        this.game.getPlayer().setMetal(1);
                    if(this.game.getPlayer().getTotWealth() < 5)
                        this.game.getPlayer().setWealth(1);
                    return new IE(this.game);
            }
            else{
                if(this.game.getPlayer().getTotMetal() < 5)
                    this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                return new Phase3(this.game);
            }
        }
        
        if(this.game.getPlayer().attack(this.game.getNearSystems().get(0), r))
        {
            this.game.setCombatReport(this.game.getPlayer().attack(this.game.getNearSystems().get(0),r ), this.game.getNearSystems().get(0), r);//true,primeirolista,dado
            this.game.getPlayer().AddSystem(this.game.getNearSystems().get(0));
            this.game.getNearSystems().get(0).doEffect(this.game);
            this.game.getNearSystems().remove(0);
            if(this.game.getTechs(3,0).getLearn()){
                if(this.game.getPlayer().getTotMetal() < 5)
                        this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                return new IE(this.game);
            }
            else{
                /*recursos*/
                if(this.game.getPlayer().getTotMetal() < 5)
                    this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                return new Phase3(this.game);
            }
        }
        else
        {
            this.game.setCombatReport(this.game.getPlayer().attack(this.game.getNearSystems().get(0), r), this.game.getNearSystems().get(0), r);//false,primeirolista,dado
            this.game.getUnaligned().add(this.game.getNearSystems().get(0));
            this.game.getNearSystems().remove(0);
            if(this.game.getTechs(3,0).getLearn()){
                return new IE(this.game);
            }
            else{
                /*recursos*/
                if(this.game.getPlayer().getTotMetal() < 5)
                    this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                return new Phase3(this.game);
            }
        }
    }
    
    @Override
    public IState DrawDistant(){//codigo acima mas a validar a tech
        if(this.game.getDiplomacy() && this.game.getTechs(0,1).getLearn()){
            this.game.getPlayer().AddSystem(this.game.getDistantSystems().get(0));
            this.game.getDistantSystems().get(0).doEffect(this.game);
            this.game.getDistantSystems().remove(0);
            this.game.setDiplomacy(false);
            this.game.setSystemMessage("[SISTEMA]Sistema Conquistado por Diplomacia");
            if(this.game.getTechs(3,0).getLearn()){
                    if(this.game.getPlayer().getTotMetal() < 5)
                        this.game.getPlayer().setMetal(1);
                    if(this.game.getPlayer().getTotWealth() < 5)
                        this.game.getPlayer().setWealth(1);
                    return new IE(this.game);
            }
            else{
                if(this.game.getPlayer().getTotMetal() < 5)
                    this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                return new Phase3(this.game);
            }
        }
        if (this.game.getTechs(0,1).getLearn()) {
            
        
            int r = this.game.RollDice();
            if(this.game.getPlayer().attack(this.game.getDistantSystems().get(0), r))
            {
                this.game.setCombatReport(this.game.getPlayer().attack(this.game.getDistantSystems().get(0),r ), this.game.getDistantSystems().get(0), r);//true,primeirolista,dado
                this.game.getPlayer().AddSystem(this.game.getDistantSystems().get(0));
                this.game.getDistantSystems().get(0).doEffect(this.game);
                this.game.getDistantSystems().remove(0);
                if(this.game.getTechs(3,0).getLearn()){
                    if(this.game.getPlayer().getTotMetal() < 5)
                        this.game.getPlayer().setMetal(1);
                    if(this.game.getPlayer().getTotWealth() < 5)
                        this.game.getPlayer().setWealth(1);
                    return new IE(this.game);
                }
                else{
                    if(this.game.getPlayer().getTotMetal() < 5)
                        this.game.getPlayer().setMetal(1);
                    if(this.game.getPlayer().getTotWealth() < 5)
                        this.game.getPlayer().setWealth(1);
                    return new Phase3(this.game);
                }
            }
            else
            {
                this.game.setCombatReport(this.game.getPlayer().attack(this.game.getDistantSystems().get(0), r), this.game.getDistantSystems().get(0), r);//false,primeirolista,dado
                this.game.getUnaligned().add(this.game.getDistantSystems().get(0));
                this.game.getDistantSystems().remove(0);
                if(this.game.getTechs(3,0).getLearn()){
                    if(this.game.getPlayer().getTotMetal() < 5)
                        this.game.getPlayer().setMetal(1);
                    if(this.game.getPlayer().getTotWealth() < 5)
                        this.game.getPlayer().setWealth(1);
                    return new IE(this.game);
                }
                else{
                    if(this.game.getPlayer().getTotMetal() < 5)
                        this.game.getPlayer().setMetal(1);
                    if(this.game.getPlayer().getTotWealth() < 5)
                        this.game.getPlayer().setWealth(1);
                    return new Phase3(this.game);
                }
            }
        }
        else{
            return this;
        }
    }
    
    @Override
    public IState Conquer(int v){
        int r = this.game.RollDice();
        if(this.game.getPlayer().attack(this.game.getUnaligned().get(v), r))
        {
            this.game.setCombatReport(this.game.getPlayer().attack(this.game.getUnaligned().get(v),r ), this.game.getUnaligned().get(v), r);//true,primeirolista,dado
            this.game.getPlayer().AddSystem(this.game.getUnaligned().get(v));
            this.game.getUnaligned().get(v).doEffect(this.game);
            this.game.getUnaligned().remove(0);
            if(this.game.getTechs(3,0).getLearn()){
                if(this.game.getPlayer().getTotMetal() < 5)
                        this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                return new IE(this.game);
            }
            else{
                if(this.game.getPlayer().getTotMetal() < 5)
                    this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                return new Phase3(this.game);
            }
        }
        else
        {
            this.game.setCombatReport(this.game.getPlayer().attack(this.game.getUnaligned().get(v), r), this.game.getUnaligned().get(v), r);//false,primeirolista,dado
            if(this.game.getTechs(3,0).getLearn()){
                if(this.game.getPlayer().getTotMetal() < 5)
                        this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                return new IE(this.game);
            }
            else{
                if(this.game.getPlayer().getTotMetal() < 5)
                    this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                return new Phase3(this.game);
            }
        }
    }
    
    
    @Override
    public IState Pass(){
        if(this.game.getTechs(3,0).getLearn()){
                if(this.game.getPlayer().getTotMetal() < 5)
                    this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                this.game.setSystemMessage("[SISTEMA] Passou!Adicionados Recursos\nao Império!");
                return new IE(this.game);
        }
        else{
            if(this.game.getPlayer().getTotMetal() < 5)
                this.game.getPlayer().setMetal(1);
            if(this.game.getPlayer().getTotWealth() < 5)
                this.game.getPlayer().setWealth(1);
            this.game.setSystemMessage("[SISTEMA] Passou! Adicionados Recursos\nao Império!");
            return new Phase3(this.game);
        }
        
    }
    
}
