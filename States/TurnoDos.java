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
public class TurnoDos extends Turno{
    
    
    
    public TurnoDos(Board board,Player player){
        super(board,player);
    }        
    
    @Override
    public char getIdentifier() {
        return 'O';
    }

    @Override
    public char getRival() {
        return 'X';
    }
    
    public State getNext() {
        return board.getTurnoUno();
    }
    
}
