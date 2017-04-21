/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);        
        Board nuevoTablero = new Board();                     
         nuevoTablero.inicia();                          
    }    
}
