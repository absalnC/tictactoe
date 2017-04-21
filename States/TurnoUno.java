/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import States.Turno;
import States.State;
import tictactoe.Board;
import strategies.Player;

/**
 *
 * @author absa
 */
public class TurnoUno extends Turno{
    
   
    public TurnoUno(Board board,Player player){
        super(board,player);    
    }           

    @Override
    public char getIdentifier() {
        return 'X';
    }

    @Override
    public char getRival() {
        return 'O';
    }

    @Override
    public State getNext() {
        return board.getTurnoDos();
    }
    
}
