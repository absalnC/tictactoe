/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies;

import States.Turno;
import tictactoe.Board;
import tictactoe.Movement;

/**
 *
 * @author absa
 */
public class NaivePlayer extends AutoPlayer{

    public NaivePlayer(Turno turno, Board board) {
        super(turno, board);
    }

    @Override
    public Movement choseMovement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
