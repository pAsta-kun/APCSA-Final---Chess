package rip;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Queen extends Pieces {

    private JButton icon;
    private String color;
    private JPanel[][] board;
    private ArrayList<JPanel> legalMoves = new ArrayList<>();
    private Container window;

    public Queen()
    {
        super();
    }

    public Queen(int x, int y, String color, Container window, JPanel[][] board, String path)
    {
        super(x, y, color, window, board, path);
        this.color = color;
        this.board = board;
        this.window = window;

        pieceIcon = new ImageIcon(path);
        icon = new JButton(pieceIcon);
        icon.setLocation(x, y);
        icon.setSize(125, 125);
        icon.setBackground(Color.decode("#B58863"));
        window.add(icon);
        window.repaint();
        icon.addActionListener(this);

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

