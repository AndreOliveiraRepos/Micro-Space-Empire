/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextUI;

import Game.GameWrapper;
import State.*;
import java.util.Scanner;

/**
 *
 * @author André Oliveira
 */
public class iuTexto {
    private GameWrapper gameWrapper;
    private Scanner s;
    
    public iuTexto(GameWrapper game){
        this.gameWrapper = game;
        s=new Scanner(System.in);
    }
    
    public void Show(){
        System.out.print(this.gameWrapper.toString());
    }
    
    
    
    public void Begin(){
        int opcao;
        System.out.println("Micro Space Empires\n\n");
        System.out.println("1-Iniciar");
        System.out.println("2-Load");
        System.out.println("3-Quit");
        System.out.print("> ");
        
        while(!s.hasNextInt()) s.next();
            
        opcao=s.nextInt();

        if(opcao==1)
            this.gameWrapper.begin();
            //this.jogo.setEstado(new Fase1(this.jogo));
            /**/
        if (opcao == 2) {
            System.out.print("Por Implementar");
            /*this.jogo = loadgame();
            this.jogo.Iniciar();*/
            
        }
        if(opcao==3)
            System.exit(0);
            //return is;
            //this.jogo.Encerrar();
    
            
    }
    
    public void Fase1(){
        int opcao;
        this.Show();
        System.out.println("Escolha uma opção\n\n");
        System.out.println("1-Explorar proximos");
        System.out.println("2-Explorar longinquos");
        System.out.println("3-Conquistar");
        System.out.println("4-Passar");
        System.out.print("> ");
        
        while(!s.hasNextInt()) s.next();
            
        opcao=s.nextInt();

        if(opcao==1){    
            this.gameWrapper.DrawClose();
            System.out.println(this.gameWrapper.getCombatReport());
            
            
        }   
        if (opcao == 2) {
            System.out.println("Não implementado!");
            System.out.println(this.gameWrapper.getCombatReport());
        }
        if (opcao == 3) {
            
            if(this.gameWrapper.getUnaligned().isEmpty()){
                System.out.println("Não existem Planetas desalinhados!");
            }
            else{
                for (int i = 0; i < this.gameWrapper.getUnaligned().size(); i++) {
                    System.out.println(i + " - " + this.gameWrapper.getUnaligned().get(i).WriteCard());
                }
                System.out.print("> ");
                while(!s.hasNextInt()) s.next();
            
                opcao=s.nextInt();
                this.gameWrapper.Conquer(opcao);
                System.out.println(this.gameWrapper.getCombatReport());
            }
        }
        if(opcao==4){    
            System.out.println("Passou!");
            this.gameWrapper.Pass();
        }
        
    }
    
    public void Fase3(){
        int opcao;
        this.Show();
        System.out.println("Escolha uma opção\n\n");
        System.out.println("1-Construir força militar");
        System.out.println("2-Descobrir tecnologias");
        System.out.println("3-Comprar evento");
        System.out.println("4 - Passar");
        
        System.out.print("> ");
        
        while(!s.hasNextInt()) s.next();
            
        opcao=s.nextInt();

        if(opcao==1){   
            System.out.println("[SISTEMA]A adicionar +1 a Força Militar");
            this.gameWrapper.BuildRecruit();
            
            
        }   
        if (opcao == 2) {
            
            System.out.println("Escolha uma das opções");
            System.out.println(this.gameWrapper.LearnableTechnologies());
            System.out.print("> ");
            while(!s.hasNextInt()) s.next();
            opcao=s.nextInt();
            switch(opcao)
            {
                case 1:
                    this.gameWrapper.Research(0, 0);
                    break;
                case 2:
                    this.gameWrapper.Research(1, 0);
                    break;
                case 3:
                    this.gameWrapper.Research(2, 0);
                    break;
                case 4:
                    this.gameWrapper.Research(3, 0);
                    break;
                case 5:
                    this.gameWrapper.Research(0, 1);
                    
                    break;
                case 6:
                    this.gameWrapper.Research(1, 1);
                    break;
                case 7:
                    this.gameWrapper.Research(2, 1);
                    break;
                case 8:
                    this.gameWrapper.Research(3, 1);
                    
                    break;
                default:
                    System.out.println("[SISTEMA]Escolha invalida");
                    break;
            }
        }
        if(opcao==3){   
            System.out.println("[SISTEMA]Comprou um evento");
            System.out.println(this.gameWrapper.getEvents().get(0).toString());
            this.gameWrapper.DrawEvent();
            
            
        }   
        if(opcao==4){    
            System.out.println("Passou!");//fim de turno
            this.gameWrapper.EndTurn();
            //this.jogo.setEstado(new Fase1(this.jogo));
            
        }
          
    }
    
    public void run(){
        Begin();
        //while(true){
        while(! (gameWrapper.getState() instanceof End)){

            if(gameWrapper.getState() instanceof Phase1){
                Fase1();
            }
                    
            else if(gameWrapper.getState() instanceof Phase3)
            {
                Fase3();
            }
        }
        System.out.println(this.gameWrapper.getSystemMessage());
        System.out.println("Pontuação neste jogo: " + this.gameWrapper.CountPoints());
        /*System.out.println();*/
        System.out.println("************** Fim do jogo *****************");
        //mostraJogo();
    
    }
}
