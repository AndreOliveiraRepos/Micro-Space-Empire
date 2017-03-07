/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;
import Jogo.Jogo;
/**
 *
 * @author red_f
 */
public class Fase1 extends EstadoAdapter {
    public Fase1(Jogo j)
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
        
        int r = this.jogo.RolaDado();
        if(this.jogo.getDiplomacy()){
            this.jogo.getPlayer().AddSistema(this.jogo.getProximos().get(0));
            this.jogo.getProximos().get(0).doEffect(this.jogo);
            this.jogo.getProximos().remove(0);
            this.jogo.setDiplomacy(false);
            this.jogo.setMensagemSistema("[SISTEMA]Sistema Conquistado por Diplomacia");
            if(this.jogo.getTechs(3,0).getLearn()){
                    if(this.jogo.getPlayer().getTotMetal() < 5)
                        this.jogo.getPlayer().setMetal(1);
                    if(this.jogo.getPlayer().getTotWealth() < 5)
                        this.jogo.getPlayer().setWealth(1);
                    return new IE(this.jogo);
            }
            else{
                if(this.jogo.getPlayer().getTotMetal() < 5)
                    this.jogo.getPlayer().setMetal(1);
                if(this.jogo.getPlayer().getTotWealth() < 5)
                    this.jogo.getPlayer().setWealth(1);
                return new Fase3(this.jogo);
            }
        }
        
        if(this.jogo.getPlayer().Ataque(this.jogo.getProximos().get(0), r))
        {
            this.jogo.setRelatorioCombat(this.jogo.getPlayer().Ataque(this.jogo.getProximos().get(0),r ), this.jogo.getProximos().get(0), r);//true,primeirolista,dado
            this.jogo.getPlayer().AddSistema(this.jogo.getProximos().get(0));
            this.jogo.getProximos().get(0).doEffect(this.jogo);
            this.jogo.getProximos().remove(0);
            if(this.jogo.getTechs(3,0).getLearn()){
                if(this.jogo.getPlayer().getTotMetal() < 5)
                        this.jogo.getPlayer().setMetal(1);
                if(this.jogo.getPlayer().getTotWealth() < 5)
                    this.jogo.getPlayer().setWealth(1);
                return new IE(this.jogo);
            }
            else{
                /*recursos*/
                if(this.jogo.getPlayer().getTotMetal() < 5)
                    this.jogo.getPlayer().setMetal(1);
                if(this.jogo.getPlayer().getTotWealth() < 5)
                    this.jogo.getPlayer().setWealth(1);
                return new Fase3(this.jogo);
            }
        }
        else
        {
            this.jogo.setRelatorioCombat(this.jogo.getPlayer().Ataque(this.jogo.getProximos().get(0), r), this.jogo.getProximos().get(0), r);//false,primeirolista,dado
            this.jogo.getDesalinhas().add(this.jogo.getProximos().get(0));
            this.jogo.getProximos().remove(0);
            if(this.jogo.getTechs(3,0).getLearn()){
                return new IE(this.jogo);
            }
            else{
                /*recursos*/
                if(this.jogo.getPlayer().getTotMetal() < 5)
                    this.jogo.getPlayer().setMetal(1);
                if(this.jogo.getPlayer().getTotWealth() < 5)
                    this.jogo.getPlayer().setWealth(1);
                return new Fase3(this.jogo);
            }
        }
    }
    
    @Override
    public IEstado DrawDistant(){//codigo acima mas a validar a tech
        if(this.jogo.getDiplomacy() && this.jogo.getTechs(0,1).getLearn()){
            this.jogo.getPlayer().AddSistema(this.jogo.getLonginquos().get(0));
            this.jogo.getLonginquos().get(0).doEffect(this.jogo);
            this.jogo.getLonginquos().remove(0);
            this.jogo.setDiplomacy(false);
            this.jogo.setMensagemSistema("[SISTEMA]Sistema Conquistado por Diplomacia");
            if(this.jogo.getTechs(3,0).getLearn()){
                    if(this.jogo.getPlayer().getTotMetal() < 5)
                        this.jogo.getPlayer().setMetal(1);
                    if(this.jogo.getPlayer().getTotWealth() < 5)
                        this.jogo.getPlayer().setWealth(1);
                    return new IE(this.jogo);
            }
            else{
                if(this.jogo.getPlayer().getTotMetal() < 5)
                    this.jogo.getPlayer().setMetal(1);
                if(this.jogo.getPlayer().getTotWealth() < 5)
                    this.jogo.getPlayer().setWealth(1);
                return new Fase3(this.jogo);
            }
        }
        if (this.jogo.getTechs(0,1).getLearn()) {
            
        
            int r = this.jogo.RolaDado();
            if(this.jogo.getPlayer().Ataque(this.jogo.getLonginquos().get(0), r))
            {
                this.jogo.setRelatorioCombat(this.jogo.getPlayer().Ataque(this.jogo.getLonginquos().get(0),r ), this.jogo.getLonginquos().get(0), r);//true,primeirolista,dado
                this.jogo.getPlayer().AddSistema(this.jogo.getLonginquos().get(0));
                this.jogo.getLonginquos().get(0).doEffect(this.jogo);
                this.jogo.getLonginquos().remove(0);
                if(this.jogo.getTechs(3,0).getLearn()){
                    if(this.jogo.getPlayer().getTotMetal() < 5)
                        this.jogo.getPlayer().setMetal(1);
                    if(this.jogo.getPlayer().getTotWealth() < 5)
                        this.jogo.getPlayer().setWealth(1);
                    return new IE(this.jogo);
                }
                else{
                    if(this.jogo.getPlayer().getTotMetal() < 5)
                        this.jogo.getPlayer().setMetal(1);
                    if(this.jogo.getPlayer().getTotWealth() < 5)
                        this.jogo.getPlayer().setWealth(1);
                    return new Fase3(this.jogo);
                }
            }
            else
            {
                this.jogo.setRelatorioCombat(this.jogo.getPlayer().Ataque(this.jogo.getLonginquos().get(0), r), this.jogo.getLonginquos().get(0), r);//false,primeirolista,dado
                this.jogo.getDesalinhas().add(this.jogo.getLonginquos().get(0));
                this.jogo.getLonginquos().remove(0);
                if(this.jogo.getTechs(3,0).getLearn()){
                    if(this.jogo.getPlayer().getTotMetal() < 5)
                        this.jogo.getPlayer().setMetal(1);
                    if(this.jogo.getPlayer().getTotWealth() < 5)
                        this.jogo.getPlayer().setWealth(1);
                    return new IE(this.jogo);
                }
                else{
                    if(this.jogo.getPlayer().getTotMetal() < 5)
                        this.jogo.getPlayer().setMetal(1);
                    if(this.jogo.getPlayer().getTotWealth() < 5)
                        this.jogo.getPlayer().setWealth(1);
                    return new Fase3(this.jogo);
                }
            }
        }
        else{
            return this;
        }
    }
    
    @Override
    public IEstado Conquer(int v){
        int r = this.jogo.RolaDado();
        if(this.jogo.getPlayer().Ataque(this.jogo.getDesalinhas().get(v), r))
        {
            this.jogo.setRelatorioCombat(this.jogo.getPlayer().Ataque(this.jogo.getDesalinhas().get(v),r ), this.jogo.getDesalinhas().get(v), r);//true,primeirolista,dado
            this.jogo.getPlayer().AddSistema(this.jogo.getDesalinhas().get(v));
            this.jogo.getDesalinhas().get(v).doEffect(this.jogo);
            this.jogo.getDesalinhas().remove(0);
            if(this.jogo.getTechs(3,0).getLearn()){
                if(this.jogo.getPlayer().getTotMetal() < 5)
                        this.jogo.getPlayer().setMetal(1);
                if(this.jogo.getPlayer().getTotWealth() < 5)
                    this.jogo.getPlayer().setWealth(1);
                return new IE(this.jogo);
            }
            else{
                if(this.jogo.getPlayer().getTotMetal() < 5)
                    this.jogo.getPlayer().setMetal(1);
                if(this.jogo.getPlayer().getTotWealth() < 5)
                    this.jogo.getPlayer().setWealth(1);
                return new Fase3(this.jogo);
            }
        }
        else
        {
            this.jogo.setRelatorioCombat(this.jogo.getPlayer().Ataque(this.jogo.getDesalinhas().get(v), r), this.jogo.getDesalinhas().get(v), r);//false,primeirolista,dado
            if(this.jogo.getTechs(3,0).getLearn()){
                if(this.jogo.getPlayer().getTotMetal() < 5)
                        this.jogo.getPlayer().setMetal(1);
                if(this.jogo.getPlayer().getTotWealth() < 5)
                    this.jogo.getPlayer().setWealth(1);
                return new IE(this.jogo);
            }
            else{
                if(this.jogo.getPlayer().getTotMetal() < 5)
                    this.jogo.getPlayer().setMetal(1);
                if(this.jogo.getPlayer().getTotWealth() < 5)
                    this.jogo.getPlayer().setWealth(1);
                return new Fase3(this.jogo);
            }
        }
    }
    
    
    @Override
    public IEstado Pass(){
        if(this.jogo.getTechs(3,0).getLearn()){
                if(this.jogo.getPlayer().getTotMetal() < 5)
                    this.jogo.getPlayer().setMetal(1);
                if(this.jogo.getPlayer().getTotWealth() < 5)
                    this.jogo.getPlayer().setWealth(1);
                this.jogo.setMensagemSistema("[SISTEMA] Passou!Adicionados Recursos\nao Império!");
                return new IE(this.jogo);
        }
        else{
            if(this.jogo.getPlayer().getTotMetal() < 5)
                this.jogo.getPlayer().setMetal(1);
            if(this.jogo.getPlayer().getTotWealth() < 5)
                this.jogo.getPlayer().setWealth(1);
            this.jogo.setMensagemSistema("[SISTEMA] Passou! Adicionados Recursos\nao Império!");
            return new Fase3(this.jogo);
        }
        
    }
    
}
