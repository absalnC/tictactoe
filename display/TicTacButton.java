/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import javax.swing.JButton;

/**
 *
 * @author absa
 */
public class TicTacButton extends JButton{
    private int row;
    private int column;
    public TicTacButton(int row, int col){
        this.row=row;
        this.column= col;
        setSize(300,150);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
    
}
