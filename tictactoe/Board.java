/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import strategies.RandomPlayer;
import strategies.Player;
import display.Display;
import States.TurnoUno;
import States.TurnoDos;
import States.Terminado;
import States.Inicio;
import States.Turno;
import States.State;



/**
 *
 * @author absa
 */
public class Board {
    State inicio;
    State turnoUno;
    State turnoDos;
    State terminado;
    State currentState;
    Player player1;
    Player player2;    
    boolean hasWinner=false;
    public char[][] board= new char[3][3];    
    Display display;
    
    public Board(){
        display=new Display(this);
        display.initDisplay();
        inicio = new Inicio(this);
        turnoUno  =new TurnoUno(this,null);
        turnoDos = new TurnoDos(this,null);
        terminado = new Terminado(this); 
        player1= display.assignPlayer((Turno)turnoUno);
        //La instanciación del jugador no debería preocuparse por la 
        //configuración del jugador
        player2=new RandomPlayer((Turno)turnoDos,this);
        ((Turno)turnoUno).setPlayer(player1);
        ((Turno)turnoDos).setPlayer(player2);
        clear();
        currentState=inicio;
    }
    
    public void inicia(){
        currentState.inicia();
    }
    public void tira(){
        currentState.tira();
        //aqui deberia llamarse la siguiente jugada del siguiente jugador
    }
    public void reinicia(){
        currentState.reinicia();
    }
    public void draw(){
        display.draw();       
    }
    public char getCell(int row, int col){
        return board[row][col];
    }
    public void setState(State state){
        this.currentState=state;
    }

    public State getInicio() {
        return inicio;
    }

    public State getTurnoUno() {
        return turnoUno;
    }

    public State getTurnoDos() {
        return turnoDos;
    }

    public State getTerminado() {
        return terminado;
    }
    public State getCurrentState(){
        return currentState;
    }
    public boolean isWinner(char c){
        int[] LineScore=getScore(c);
            for (int score : LineScore) {
                if(score==3)
                    return true;
        }
            return false;
    }
    
    private int[] getScore(char c){
        int []LineScore={0,0,0,0,0,0,0,0,0};
        for(int row=0 ; row<3 ; row++){
            for (int cell = 0; cell < 3; cell++) {
                if (board[row][cell]==c){                    
                    LineScore[row]++;
                    LineScore[cell+3]++;
                    if (isRightDiagonal(row,cell))
                        LineScore[6]++;
                     if(isLeftDiagonal(row,cell))
                         LineScore[7]++;                    
                }
            }
        }
        return LineScore;
    }
    
    private boolean isLeftDiagonal(int x, int y){
        if (x+y==2) 
            return true;
        return false;
    }
    private boolean isRightDiagonal(int x, int y){
        if (x==y) 
            return true;
        return false;
    }
    public boolean isOccupied(int row, int cell){
        if(board[row][cell]!='-')
            return true;
        return false;
            
    }
    public boolean isOver(){        
        if(!hasWinner)
        for (int row = 0; row < 3; row++) {
            for (int cell = 0; cell < 3; cell++) {
                    if(board[row][cell]=='-')
                        return false;
                }            
        }
        return true;
        
    }

    public void setHasWinner(boolean hasWinner) {
        this.hasWinner = hasWinner;
    }
    public void tellOver(){
        display.tellOver();
    }
    
    public final void clear(){
        for (int row = 0; row < 3; row++) {
            for (int cell = 0; cell < 3; cell++) {
                    board[row][cell]='-';
                }            
        }
    }

    public void getBoardInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

