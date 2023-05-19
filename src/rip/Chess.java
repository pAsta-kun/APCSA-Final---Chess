package rip;//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Chess extends JFrame implements ActionListener
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

    JPanel squares[][] = {

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

    Pawn PA2 = new Pawn();
    Pawn PB2 = new Pawn();
    Pawn PC2 = new Pawn();
    Pawn PD2 = new Pawn();
    Pawn PE2 = new Pawn();
    Pawn PF2 = new Pawn();
    Pawn PG2 = new Pawn();
    Pawn PH2 = new Pawn();
    Pawn PA7 = new Pawn();
    Pawn PB7 = new Pawn();
    Pawn PC7 = new Pawn();
    Pawn PD7 = new Pawn();
    Pawn PE7 = new Pawn();
    Pawn PF7 = new Pawn();
    Pawn PG7 = new Pawn();
    Pawn PH7 = new Pawn();

    Pawn[] wPawns = {PA2, PB2, PC2, PD2, PE2, PF2, PG2, PH2};
    Pawn[] bPawns = {PA7, PB7, PC7, PD7, PE7, PF7, PG7, PH7};

    //All other pieces
    Rook   RA1 = new Rook  ();
    Knight NB1 = new Knight();
    Bishop BC1 = new Bishop();
    Queen  QD1 = new Queen ();
    King   KE1 = new King  ();
    Knight NF1 = new Knight();
    Bishop BG1 = new Bishop();
    Rook   RH1 = new Rook  ();

    Rook   RA8 = new Rook  ();
    Knight NB8 = new Knight();
    Bishop BC8 = new Bishop();
    Queen  QD8 = new Queen ();
    King   KE8 = new King  ();
    Knight NF8 = new Knight();
    Bishop BG8 = new Bishop();
    Rook   RH8 = new Rook  ();

    Pieces[] whitePieces = {RA1, NB1, BC1, QD1, KE1, NF1, BG1, RH1 };

    Pieces[] blackPieces = {RA8, NB8, BC8, QD8, KE8, NF8, BG8, RH8 };

    public Chess()
    {
        setUpWindow();
        setUpPieces();
        settingUpBoard();

    }



    public void setUpWindow()
    {
        window = getContentPane();
        window.setLayout(null);
        setSize(1015, 1037);
        setTitle("♔");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setUpPieces()
    {
        Rook   RA1 = new Rook  (0, 125, "white", window, squares  , "pieces/bp.png");
        Knight NB1 = new Knight(125, 125, "white", window, squares, "pieces/bp.png");
        Bishop BC1 = new Bishop(250, 125, "white", window, squares, "pieces/bp.png");
        Queen  QD1 = new Queen (375, 125, "white", window, squares, "pieces/bp.png");
        King   KE1 = new King  (500, 125, "white", window, squares, "pieces/bp.png");
        Knight NF1 = new Knight(625, 125, "white", window, squares, "pieces/bp.png");
        Bishop BG1 = new Bishop(750, 125, "white", window, squares, "pieces/bp.png");
        Rook   RH1 = new Rook  (875, 125, "white", window, squares, "pieces/bp.png");

        Rook   RA8 = new Rook  (0, 125, "white", window, squares  , "pieces/bp.png");
        Knight NB8 = new Knight(125, 125, "white", window, squares, "pieces/bp.png");
        Bishop BC8 = new Bishop(250, 125, "white", window, squares, "pieces/bp.png");
        Queen  QD8 = new Queen (375, 125, "white", window, squares, "pieces/bp.png");
        King   KE8 = new King  (500, 125, "white", window, squares, "pieces/bp.png");
        Knight NF8 = new Knight(625, 125, "white", window, squares, "pieces/bp.png");
        Bishop BG8 = new Bishop(750, 125, "white", window, squares, "pieces/bp.png");
        Rook   RH8 = new Rook  (875, 125, "white", window, squares, "pieces/bp.png");
    }

    public void settingUpBoard()
    {
        x= 0;
        y = 0;
        int i = 0;

        //Setting up board
        for (int c = 0; c < squares[0].length; c++)
        {

            for (int r = 0; r < squares.length; r++)
            {
                //Setts up squares
                if(c%2 == 0 && r%2 == 0 || c%2 != 0 && r%2 != 0)
                    squares[r][c].setBackground(Color.decode("#B58863"));
                else squares[r][c].setBackground(Color.decode("#F0D9B5"));

                squares[r][c].setSize(125, 125);
                squares[r][c].setLocation(x,y);
                window.add(squares[r][c]);

                //Setting up pieces
                if(y == 0 && i == 0)
                {
                    int temp = x;
                    for (int j = 0; j < whitePieces.length; j++)
                    {
                        if(j%2 != 0)
                            blackPieces[j].setBackgroundColor("#F0D9B5");
                    }
                    i++;

                }
                y+=125;
                if(y == 125 && i == 1)
                {
                    int temp = x;
                    for (int j = 0; j < bPawns.length; j++)
                    {
                        System.out.println(j);
                        bPawns[j] = new Pawn(temp, y, "black", window, squares, "pieces/bp.png");
//                        if(j%2 == 0)
//                            bPawns[j].setBackgroundColor("#F0D9B5");
                        temp+=125;
                    }
                    //System.out.println(i + "test1");
                    i++;
                }
                if(y == 750 && i == 2)
                {
                    int temp = x;
                    for (int j = 0; j < wPawns.length; j++)
                    {
                        wPawns[j] = new Pawn(temp, y, "white", window, squares, "pieces/wp.png");
//                        if (j % 2 != 0)
//                            wPawns[j].setBackgroundColor("#F0D9B5");
                        temp+=125;
                    }
                    i++;
                }

                if(y == 875 && i == 3)
                {
                    for (int j = 0; j < whitePieces.length; j++)
                    {
//                        if(j%2 == 0)
//                            whitePieces[j].setBackgroundColor("#F0D9B5");
                    }
                    i++;

                }
            }

            y=0;
            x+=125;
        }

    }

    public static void main(String[] args)
    {
        Chess gui = new Chess();
        gui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e);
//        if (e.getSource() instanceof rip.Pawn)
//        {
//            System.out.println("test");
//        }
    }
}



