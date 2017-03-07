/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technologies;

import Jogo.Jogo;

/**
 *
 * @author red_f
 */
public class FowardStarbases extends Technology{
    private String description;
    public FowardStarbases(int c) {
        super(c);
        this.description = "Required to explore distant systems";
        this.setNome("Foward Starbases");
    }

    
    public String getDescription(){return this.description;}

    @Override
    public String toString() {
        String s;
        s = "Forward Starbases->Custo " + this.getCost()+ " " +  this.getDescription();
        return s;
    }

    @Override
    public void doEffect(Jogo j) {
        this.setLearn(true);
        
    }
}
