/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies;

import States.Turno;
import java.util.Random;
import tictactoe.Board;
import tictactoe.Movement;

/**
 *
 * @author absa
 */
public class RandomPlayer extends AutoPlayer{
    Random random = new Random();

    public RandomPlayer(Turno turno, Board board) {
        super(turno, board);
    }
    

    @Override
    public Movement choseMovement() {
       return new Movement(random.nextInt(3),random.nextInt(3));        
    }
    
}
