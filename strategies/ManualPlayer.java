/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies;

import display.TicTacButton;
import States.Turno;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import tictactoe.Board;

/**
 *
 * @author absa
 */
public class ManualPlayer implements MouseListener,Player{
    private Turno turno;    
    private Board board;
    
    public ManualPlayer(Turno turno,Board board){
        this.turno = turno;
        this.board=board;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {    
        if(board.getCurrentState()==turno){ 
            if(e.getSource() instanceof TicTacButton){
            System.out.println("It is an instance");
        }
            TicTacButton source = (TicTacButton)e.getSource();        
            System.out.println("X coord: "+source.getRow());
            System.out.println("Y coord: "+source.getColumn());
            moveManually(source.getRow(), source.getColumn());
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void play() {  
        System.out.println("Should stay quiet");
    }
    
    public void moveManually(int row, int cell){                        
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
                        board.tira();
                    }
                
            }
        }
        else{
            System.out.println("La celda está ocupada, tira otra vez");
        }   
        
    }
}
