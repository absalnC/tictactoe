/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import States.State;
import tictactoe.Board;

/**
 *
 * @author absa
 */
public class Terminado implements State{
    
    Board board ;
    
    public Terminado(Board board){
        this.board=board;
    }
    
    @Override
    public void inicia() {
        System.out.println("Primero debes reiniciar el juego");
    }

    @Override
    public void tira() {
        System.out.println("El juego ha terminado, no se pueden hacer mas movimientos");
    }

    @Override
    public void reinicia() {
        System.out.println("Reiniciando juego");
        board.setHasWinner(false);
        board.clear();
        board.draw();
        board.setState(board.getInicio());
    }    
}
