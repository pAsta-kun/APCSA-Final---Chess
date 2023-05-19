import rip.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessV2 extends JFrame implements ActionListener, MouseListener
{
    //Instance variables
    Container window;
    private JPanel a1 = new JPanel();
    private JPanel a2 = new JPanel();
    private JPanel a3 = new JPanel();
    private JPanel a4 = new JPanel();
    private JPanel a5 = new JPanel();
    private JPanel a6 = new JPanel();
    private JPanel a7 = new JPanel();
    private JPanel a8 = new JPanel();
    private JPanel b1 = new JPanel();
    private JPanel b2 = new JPanel();
    private JPanel b3 = new JPanel();
    private JPanel b4 = new JPanel();
    private JPanel b5 = new JPanel();
    private JPanel b6 = new JPanel();
    private JPanel b7 = new JPanel();
    private JPanel b8 = new JPanel();
    private JPanel c1 = new JPanel();
    private JPanel c2 = new JPanel();
    private JPanel c3 = new JPanel();
    private JPanel c4 = new JPanel();
    private JPanel c5 = new JPanel();
    private JPanel c6 = new JPanel();
    private JPanel c7 = new JPanel();
    private JPanel c8 = new JPanel();
    private JPanel d1 = new JPanel();
    private JPanel d2 = new JPanel();
    private JPanel d3 = new JPanel();
    private JPanel d4 = new JPanel();
    private JPanel d5 = new JPanel();
    private JPanel d6 = new JPanel();
    private JPanel d7 = new JPanel();
    private JPanel d8 = new JPanel();
    private JPanel e1 = new JPanel();
    private JPanel e2 = new JPanel();
    private JPanel e3 = new JPanel();
    private JPanel e4 = new JPanel();
    private JPanel e5 = new JPanel();
    private JPanel e6 = new JPanel();
    private JPanel e7 = new JPanel();
    private JPanel e8 = new JPanel();
    private JPanel f1 = new JPanel();
    private JPanel f2 = new JPanel();
    private JPanel f3 = new JPanel();
    private JPanel f4 = new JPanel();
    private JPanel f5 = new JPanel();
    private JPanel f6 = new JPanel();
    private JPanel f7 = new JPanel();
    private JPanel f8 = new JPanel();
    private JPanel g1 = new JPanel();
    private JPanel g2 = new JPanel();
    private JPanel g3 = new JPanel();
    private JPanel g4 = new JPanel();
    private JPanel g5 = new JPanel();
    private JPanel g6 = new JPanel();
    private JPanel g7 = new JPanel();
    private JPanel g8 = new JPanel();
    private JPanel h1 = new JPanel();
    private JPanel h2 = new JPanel();
    private JPanel h3 = new JPanel();
    private JPanel h4 = new JPanel();
    private JPanel h5 = new JPanel();
    private JPanel h6 = new JPanel();
    private JPanel h7 = new JPanel();
    private JPanel h8 = new JPanel();

    JPanel board[][] = {

            {a8, b8, c8, d8, e8, f8, g8, h8 },
            {a7, b7, c7, d7, e7, f7, g7, h7},
            {a6, b6, c6, d6, e6, f6, g6, h6},
            {a5, b5, c5, d5, e5, f5, g5, h5},
            {a4, b4, c4, d4, e4, f4, g4, h4},
            {a3, b3, c3, d3, e3, f3, g3, h3},
            {a2, b2, c2, d2, e2, f2, g2, h2},
            {a1, b1, c1, d1, e1, f1, g1, h1},};

    private int x;
    private int y;

    PawnV2 PA2 = new PawnV2();
    PawnV2 PB2 = new PawnV2();
    PawnV2 PC2 = new PawnV2();
    PawnV2 PD2 = new PawnV2();
    PawnV2 PE2 = new PawnV2();
    PawnV2 PF2 = new PawnV2();
    PawnV2 PG2 = new PawnV2();
    PawnV2 PH2 = new PawnV2();
    PawnV2 PA7 = new PawnV2();
    PawnV2 PB7 = new PawnV2();
    PawnV2 PC7 = new PawnV2();
    PawnV2 PD7 = new PawnV2();
    PawnV2 PE7 = new PawnV2();
    PawnV2 PF7 = new PawnV2();
    PawnV2 PG7 = new PawnV2();
    PawnV2 PH7 = new PawnV2();
    PawnV2[] wPawns = {PA2, PB2, PC2, PD2, PE2, PF2, PG2, PH2};
    PawnV2[] bPawns = {PA7, PB7, PC7, PD7, PE7, PF7, PG7, PH7};

    private Piece selectedPiece;

    public ChessV2()
    {
        setUpWindow();
        setUpBoard();
        setUpPieces();
    }

    public void setUpWindow()
    {
        window = getContentPane();
        window.setLayout(null);
        setSize(1015, 1037);
        setTitle("rip.Chess");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setUpBoard()
    {
        //Loops the every row
        for (int letters = 0; letters < board.length; letters++)
        {
            x = 0; //variable for x location
            //Loops through the cols
            for (int numbers = 0; numbers < board[letters].length; numbers++)
            {
                //sets up board colors
                if(numbers%2 == 0 && letters%2 == 0 || numbers%2 != 0 && letters%2 != 0)
                    board[letters][numbers].setBackground(Color.decode("#B58863"));
                else board[letters][numbers].setBackground(Color.decode("#F0D9B5"));

                //sets up the jpanels size + location
                board[letters][numbers].setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                board[letters][numbers].setSize(125, 125);
                board[letters][numbers].setLocation(x,y);
                board[letters][numbers].addMouseListener(this);
                window.add(board[letters][numbers]);

                x+=125; //increments x over by 125
            }
            y+=125; //increments y so new row starts
        }

    }

    public void setUpPieces()
    {
        x = 0;
        y = 125;

        for (int row = 0; row < board[0].length; row++)
        {
            // Create a final variable to capture the current row value
            final int finalRow = row;

            bPawns[row] = new PawnV2(x, y, "black", board, window);
            board[y/125][row].add(bPawns[row].getPiece());

            if (row % 2 == 0) {
                bPawns[row].setBackgroundColor("#F0D9B5");
            }

            x += 125;
        }

        y = 750;
        for (int row = 0; row < board[0].length; row++) {
            // Create a final variable to capture the current row value
            final int finalRow = row;

            wPawns[row] = new PawnV2(x - 875, y, "white", board, window);
            board[y/125][row].add(wPawns[row].getPiece());

            if (row % 2 != 0) {
                wPawns[row].setBackgroundColor("#F0D9B5");
            }
            x += 125;

            // Add ActionListener to each white pawn
            wPawns[row].getPiece().addActionListener(e -> {
                selectedPiece = wPawns[finalRow];
            });
        }
    }

    private void movePiece(int newX, int newY, Color background)
    {
        if (selectedPiece != null)
        {
            selectedPiece.pieceMove(newX/125, newY/125, background);
            selectedPiece = null;
        }
    }





    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public static void main(String[] args)
    {
        ChessV2 gui = new ChessV2();
        gui.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getComponent() instanceof JPanel)
        {
            JPanel clickedPanel = (JPanel) e.getComponent();
            movePiece(clickedPanel.getX(), clickedPanel.getY(), clickedPanel.getBackground());
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
