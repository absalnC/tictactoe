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
public class Inicio implements State{
    
    Board board;
    
    public Inicio(Board board){ 
        System.out.println("Inicializando INICIO");
        this.board=board;
    }
    @Override
    public void inicia() {
        System.out.println("Iniciando juego");        
        board.draw();
        board.setState(board.getTurnoUno());
    }

    @Override
    public void tira() {
        System.out.println("No se puede tirar hasta que sea turno de uno de los jugadores");
    }

    @Override
    public void reinicia() {
        System.out.println("Solo se puede reiniciar hasta que termine el juego");
    }
    
}
