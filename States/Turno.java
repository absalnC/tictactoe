/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import States.State;
import tictactoe.Board;
import tictactoe.Movement;
import strategies.Player;

/**
 *
 * @author absa
 */
public abstract class Turno implements State{
    Board board;
    public Player player;
    public Turno(Board board,Player player){
        this.board=board;        
        this.player=player;
    }
    public void setPlayer(Player player){    
        this.player=player;
    }
    @Override
    public void inicia() {
        System.out.println("La partida ya esta en curso");
    }
    
    @Override
    public  void tira(){
        player.play();             
    }

    @Override
    public void reinicia() {
        System.out.println("El juego debe terminar primero");
    }
    
    public abstract char getIdentifier();    
    public abstract char getRival();    
    public abstract State getNext();
}
