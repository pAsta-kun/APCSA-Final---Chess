package rip;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Rook extends Pieces {

    private JButton icon;
    private String color;
    private JPanel[][] board;
    private ArrayList<JPanel> legalMoves = new ArrayList<>();
    private Container window;

    public Rook()
    {
        super();
    }

    public Rook(int x, int y, String color, Container window, JPanel[][] board, String path)
    {
        super(x, y, color, window, board, path);
        this.color = color;
        this.board = board;
        this.window = window;
        setUpIcon(path);
    }

    public void calculateLegalMoves(int currC, int currR)
    {
        // adds legal moves
        for (int i = 0; i < board.length; i++)
        {
            legalMoves.add(board[i][currC]);
        }
        //displays legal moves
        for (int i = 0; i < legalMoves.size(); i++)
        {
            legalMoves.get(i).setBackground(Color.orange);
            repaint();
        }

    }

}

