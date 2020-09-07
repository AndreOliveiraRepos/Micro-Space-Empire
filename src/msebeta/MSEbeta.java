/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msebeta;

import Models.Game;
import Views.Table;

/**
 *
 * @author André Oliveira
 */
public class MSEbeta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*iuTexto ui = new iuTexto(new Jogo());
        ui.run();*/
        
        
            /*Baralhos b = new Baralhos();
            ModeloCartas m = new ModeloCartas(b);
            VistaJogo v = new VistaJogo(m);*/
            //ModeloJogo m;
            new Table(new Game());
        
       
    }
    
}
