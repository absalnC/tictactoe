/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies;

import strategies.Player;
import States.Turno;
import java.util.Random;
import tictactoe.Board;
import tictactoe.Movement;

/**
 *
 * @author absa
 */

//Every auto player should be capable to get board information somehow
public abstract class AutoPlayer implements Player{
    Random random = new Random();
    private Turno turno;
    private Board board;
    public AutoPlayer(Turno turno,Board board){
        this.turno = turno;
        this.board=board;
    }
    
    
    
    @Override
    public void play() {
        Movement movement=choseMovement();
        int row= movement.x;
        int cell = movement.y;
        System.out.println("Selected: "+row+", "+cell);
        if(!board.isOccupied(row, cell)){
            board.board[row][cell]=turno.getIdentifier();
            board.draw();
            if(board.isWinner(turno.getIdentifier())){
                System.out.println("Juego terminado,ganó jugador"+ turno.getIdentifier());
                
                board.setHasWinner(true);
                board.tellOver();
                board.setState(board.getTerminado());
            }
            else{     
                if(board.isOver()){
                    System.out.println("Juego terminado, no hay ganador");
                    board.tellOver();
                    board.setState(board.getTerminado());    
                }
                    else{
                        System.out.println("Turno jugador "+turno.getRival());
                        board.setState(turno.getNext());    
                    }
                
            }
        }
        else{
            System.out.println("La celda está ocupada, tira otra vez");
            board.tira();
        }        
    }
    public abstract Movement choseMovement();
    public char[][] requestBoardInfo(){
        board.getBoardInfo();
        return new char[3][3];
    }
}
