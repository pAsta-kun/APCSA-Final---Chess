package rip;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class Pieces extends JFrame implements ActionListener
{
    private JButton icon;
    ImageIcon pieceIcon;
    private int x;
    private int y;
    private String color;
    private JPanel[][] board;
    private ArrayList<JPanel> legalMoves = new ArrayList<>();
    private Container window;

    public Pieces()
    {
    }

    public Pieces(int x, int y, String color, Container window, JPanel[][] board, String path) {
        this.x = x;
        this.y = y;
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

    public void setUpIcon(String iconPath)
    {
        System.out.println("setup");

    }

    public void setBackgroundColor(String color)
    {
        if(icon != null)
        {
            System.out.println("test1");
            icon.setBackground(Color.decode(color));
        }
    }

    public void setLocation(int x, int y) {
        icon.setLocation(x, y);
        window.repaint();
    }

    public void calculateLegalMoves(int currC, int currR) {

    }

    public void pieceMove()
    {

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Handle the button click event here
        // You can add your desired logic or method calls
        if(e.getSource() instanceof JButton)
        {
            JButton clickedButton = (JButton) e.getSource();
            //Calculates legal moves based on current position
            calculateLegalMoves(clickedButton.getX()/125, clickedButton.getY()/125);
            System.out.println("test");
        }

    }

}
