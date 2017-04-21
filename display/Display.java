/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import States.Turno;
import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import tictactoe.Board;
import strategies.ManualPlayer;
import strategies.Player;

/**
 *
 * @author absa
 */
public class Display extends JFrame{
    
    private final int  WIDTH=900;
    private final int  HEIGHT=800;
    private Board board;
    private ArrayList<ArrayList<TicTacButton>> list = new ArrayList<ArrayList<TicTacButton>>();   
    JPanel north;
    JPanel south ;
    JButton nextPlay;
    public Display(Board board){
        super("Tic tac toe");
        north= new JPanel();
        south = new JPanel();
        north.setSize(900,700);        
        south.setSize(900,100);
        setLayout(new GridLayout(2,1));
        north.setLayout(new GridLayout(3, 3));        
        add(north);   
        add(south);
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.board=board;     
        nextPlay = new JButton("Next");
    }
    
    public Player assignPlayer(Turno turno){
        ManualPlayer temp= new ManualPlayer(turno,board);
        for (int row = 0; row < 3; row++) {            
            list.add(new ArrayList<TicTacButton>());
            for (int column = 0; column < 3; column++) {
                list.get(row).add(new TicTacButton(row,column));
                north.add((TicTacButton)list.get(row).get(column));
                ((TicTacButton)list.get(row).get(column)).addMouseListener(temp);
            }
        } 
        return temp;
    }
    public void initDisplay(){              
        for (int row = 0; row < 3; row++) {            
            list.add(new ArrayList<TicTacButton>());
            for (int column = 0; column < 3; column++) {
                list.get(row).add(new TicTacButton(row,column));
                add((TicTacButton)list.get(row).get(column));                
            }
        }      
        nextPlay.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Should do next play");
                board.tira();
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
        });
        south.add(nextPlay);
    }
    
    public void draw(){             
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                ((JButton)list.get(row).get(column)).setText(String.valueOf(board.getCell(row, column)));
            }
        }
        
    }
    //Mejorar para identificar ganador
    public void tellOver(){
        JOptionPane.showMessageDialog(rootPane, "GameIsOver");
    }
    
    
}
