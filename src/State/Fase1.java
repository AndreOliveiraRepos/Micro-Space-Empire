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
public class Fase1 extends StateAdapter {
    public Fase1(GameWrapper j)
    {
        super(j);
    }
    
    /*Aqui pode:
    Explora
    Conquista
    Pass
    */
    
    @Override
    public IEstado DrawClose(){
        
        int r = this.game.RolaDado();
        if(this.game.getDiplomacy()){
            this.game.getPlayer().AddSistema(this.game.getProximos().get(0));
            this.game.getProximos().get(0).doEffect(this.game);
            this.game.getProximos().remove(0);
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
                return new Fase3(this.game);
            }
        }
        
        if(this.game.getPlayer().Ataque(this.game.getProximos().get(0), r))
        {
            this.game.setRelatorioCombat(this.game.getPlayer().Ataque(this.game.getProximos().get(0),r ), this.game.getProximos().get(0), r);//true,primeirolista,dado
            this.game.getPlayer().AddSistema(this.game.getProximos().get(0));
            this.game.getProximos().get(0).doEffect(this.game);
            this.game.getProximos().remove(0);
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
                return new Fase3(this.game);
            }
        }
        else
        {
            this.game.setRelatorioCombat(this.game.getPlayer().Ataque(this.game.getProximos().get(0), r), this.game.getProximos().get(0), r);//false,primeirolista,dado
            this.game.getDesalinhas().add(this.game.getProximos().get(0));
            this.game.getProximos().remove(0);
            if(this.game.getTechs(3,0).getLearn()){
                return new IE(this.game);
            }
            else{
                /*recursos*/
                if(this.game.getPlayer().getTotMetal() < 5)
                    this.game.getPlayer().setMetal(1);
                if(this.game.getPlayer().getTotWealth() < 5)
                    this.game.getPlayer().setWealth(1);
                return new Fase3(this.game);
            }
        }
    }
    
    @Override
    public IEstado DrawDistant(){//codigo acima mas a validar a tech
        if(this.game.getDiplomacy() && this.game.getTechs(0,1).getLearn()){
            this.game.getPlayer().AddSistema(this.game.getLonginquos().get(0));
            this.game.getLonginquos().get(0).doEffect(this.game);
            this.game.getLonginquos().remove(0);
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
                return new Fase3(this.game);
            }
        }
        if (this.game.getTechs(0,1).getLearn()) {
            
        
            int r = this.game.RolaDado();
            if(this.game.getPlayer().Ataque(this.game.getLonginquos().get(0), r))
            {
                this.game.setRelatorioCombat(this.game.getPlayer().Ataque(this.game.getLonginquos().get(0),r ), this.game.getLonginquos().get(0), r);//true,primeirolista,dado
                this.game.getPlayer().AddSistema(this.game.getLonginquos().get(0));
                this.game.getLonginquos().get(0).doEffect(this.game);
                this.game.getLonginquos().remove(0);
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
                    return new Fase3(this.game);
                }
            }
            else
            {
                this.game.setRelatorioCombat(this.game.getPlayer().Ataque(this.game.getLonginquos().get(0), r), this.game.getLonginquos().get(0), r);//false,primeirolista,dado
                this.game.getDesalinhas().add(this.game.getLonginquos().get(0));
                this.game.getLonginquos().remove(0);
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
                    return new Fase3(this.game);
                }
            }
        }
        else{
            return this;
        }
    }
    
    @Override
    public IEstado Conquer(int v){
        int r = this.game.RolaDado();
        if(this.game.getPlayer().Ataque(this.game.getDesalinhas().get(v), r))
        {
            this.game.setRelatorioCombat(this.game.getPlayer().Ataque(this.game.getDesalinhas().get(v),r ), this.game.getDesalinhas().get(v), r);//true,primeirolista,dado
            this.game.getPlayer().AddSistema(this.game.getDesalinhas().get(v));
            this.game.getDesalinhas().get(v).doEffect(this.game);
            this.game.getDesalinhas().remove(0);
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
                return new Fase3(this.game);
            }
        }
        else
        {
            this.game.setRelatorioCombat(this.game.getPlayer().Ataque(this.game.getDesalinhas().get(v), r), this.game.getDesalinhas().get(v), r);//false,primeirolista,dado
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
                return new Fase3(this.game);
            }
        }
    }
    
    
    @Override
    public IEstado Pass(){
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
            return new Fase3(this.game);
        }
        
    }
    
}
