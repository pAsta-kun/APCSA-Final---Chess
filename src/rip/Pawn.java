package rip;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

public class Pawn extends Pieces
{
    private JButton icon;
    private String color;
    private JPanel[][] board;
    private ArrayList<JPanel> legalMoves = new ArrayList<>();
    private Container window;

    public Pawn() {}

    public Pawn(int x, int y, String color, Container window, JPanel[][] board, String path) {
        super(x, y, color, window, board, path);
        this.color = color;
        this.board = board;
        this.window = window;
        setUpIcon(path);
    }

    public void calculateLegalMoves(int currC, int currR) {
        System.out.println("pawn");
        // checks color
        if (color.equals("white")) {
            legalMoves.add(board[currR - 1][currC]);
            //checks if pawn on starting square
            if (currR == 6) {
                legalMoves.add(board[currR - 2][currC]);
            }
        }
        else {
            legalMoves.add(board[currR + 1][currC]);
            //checks if pawn on starting square
            if (currR == 1) {
                legalMoves.add(board[currR + 2][currC]);
            }
        }

        //displays legal moves
        for (int i = 0; i < legalMoves.size(); i++)
        {
            legalMoves.get(i).setBackground(Color.orange);
            window.repaint();
        }

    }

}
