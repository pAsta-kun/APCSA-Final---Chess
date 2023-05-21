import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Chess extends JFrame implements ActionListener, MouseListener
{
    //Instance variables
    private Container window;
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

    private JPanel board[][] = {

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

    private Pawn PA2 = new Pawn();
    private Pawn PB2 = new Pawn();
    private Pawn PC2 = new Pawn();
    private Pawn PD2 = new Pawn();
    private Pawn PE2 = new Pawn();
    private Pawn PF2 = new Pawn();
    private Pawn PG2 = new Pawn();
    private Pawn PH2 = new Pawn();
    private Pawn PA7 = new Pawn();
    private Pawn PB7 = new Pawn();
    private Pawn PC7 = new Pawn();
    private Pawn PD7 = new Pawn();
    private Pawn PE7 = new Pawn();
    private Pawn PF7 = new Pawn();
    private Pawn PG7 = new Pawn();
    private Pawn PH7 = new Pawn();
    private Pawn[] wPawns = {PA2, PB2, PC2, PD2, PE2, PF2, PG2, PH2};
    private Pawn[] bPawns = {PA7, PB7, PC7, PD7, PE7, PF7, PG7, PH7};

    private Piece selectedPiece;
    private Rook RA1 = new Rook();
    private Rook RA8 = new Rook();
    private Rook RH1 = new Rook();
    private Rook RH8 = new Rook();

    private  Knight NB8 = new Knight();
    private  Knight NG8 = new Knight();
    private  Knight NB1 = new Knight();
    private  Knight NG1 = new Knight();


    public Chess()
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
        setTitle("Chess");
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
                    board[letters][numbers].setBackground(Color.decode("#F0D9B5"));
                else board[letters][numbers].setBackground(Color.decode("#B58863"));

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
        //setting up pawns
        x = 0;
        y = 125;

        for (int row = 0; row < board[0].length; row++)
        {
            // Create a final variable to capture the current row value
            final int finalRow = row;

            bPawns[row] = new Pawn(x, y, "black", board, window);
            board[y/125][row].add(bPawns[row].getPiece());

            if (row % 2 != 0) {
                bPawns[row].setBackgroundColor("#F0D9B5");
            }

            x += 125;
        }

        y = 750;
        for (int row = 0; row < board[0].length; row++) {
            // Create a final variable to capture the current row value
            final int finalRow = row;

            wPawns[row] = new Pawn(x - 875, y, "white", board, window);
            board[y/125][row].add(wPawns[row].getPiece());

            if (row % 2 == 0) {
                wPawns[row].setBackgroundColor("#F0D9B5");
            }
            x += 125;

            // Add ActionListener to each white pawn
            wPawns[row].getPiece().addActionListener(e -> {
                selectedPiece = wPawns[finalRow];
            });
        }

        //setting up rooks
        RA8 = new Rook(0, 0, "black", board, window);
        board[0][0].add(RA8.getPiece());
        RA8.setBackgroundColor("#F0D9B5");
        RA8.getPiece().addActionListener(e -> {
            selectedPiece = RA8;
        });
        RH8 = new Rook(7*125, 0, "black", board, window);
        board[0][7].add(RH8.getPiece());
        RH8.getPiece().addActionListener(e -> {
            selectedPiece = RH8;
        });
        RA1 = new Rook(0, 7*125, "white", board, window);
        board[7][0].add(RA1.getPiece());
        RA1.getPiece().addActionListener(e -> {
            selectedPiece = RA1;
        });
        RH1 = new Rook(7*125, 7*125, "white", board, window);
        board[7][7].add(RH1.getPiece());
        RH1.setBackgroundColor("#F0D9B5");
        RH1.getPiece().addActionListener(e -> {
            selectedPiece = RH1;
        });

        //Setting up knights
        NB8 = new Knight(125, 0, "black", board, window);
        board[0][1].add(NB8.getPiece());
        NB8.getPiece().addActionListener(e -> {
            selectedPiece = NB8;
        });

        NG8 = new Knight(6*125, 0, "black", board, window);
        board[0][6].add(NG8.getPiece());
        NG8.setBackgroundColor("#F0D9B5");
        NG8.getPiece().addActionListener(e -> {
            selectedPiece = NG8;
        });

        NB1 = new Knight(125, 7*125, "white", board, window);
        board[7][1].add(NB1.getPiece());
        NB1.setBackgroundColor("#F0D9B5");
        NB1.getPiece().addActionListener(e -> {
            selectedPiece = NB1;
        });

        NG1 = new Knight(6*125, 7*125, "white", board, window);
        board[7][6].add(NG1.getPiece());
        NG1.getPiece().addActionListener(e -> {
            selectedPiece = NG1;
        });
    }
    public void repaintBoard()
    {
        //Loops the every row
        for (int letters = 0; letters < board.length; letters++)
        {
            for (int numbers = 0; numbers < board[letters].length; numbers++)
            {
                //sets up board colors
                if(numbers%2 == 0 && letters%2 == 0 || numbers%2 != 0 && letters%2 != 0)
                    board[letters][numbers].setBackground(Color.decode("#F0D9B5"));
                else board[letters][numbers].setBackground(Color.decode("#B58863"));
            }
        }
    }
    private void movePiece(int newX, int newY, Color background)
    {
        if (selectedPiece != null)
        {
            selectedPiece.pieceMove(newX/125, newY/125, background, selectedPiece);
            selectedPiece = null;
            repaintBoard();
        }
    }





    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public static void main(String[] args)
    {
        Chess gui = new Chess();
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
