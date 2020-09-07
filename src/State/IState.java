/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;


/**
 *
 * @author André Oliveira
 */
public interface IState {
    IState DrawClose();
    IState DrawDistant();
    IState Conquer(int v);
    IState Pass();
    IState Research(int x, int y);
    IState BuildRecruit();
    IState DrawEvent();
    IState Commerce(int v);
    IState Begin();
    IState End();
}

