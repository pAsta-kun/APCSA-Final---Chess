import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Piece
{

    private String color;
    private JPanel[][] board;
    private ArrayList<JPanel> legalMoves = new ArrayList<>();
    private Container window;
    private int x;
    private int y;
    public Pawn()
    {
        super();
    }

    public Pawn(int x, int y, String color, JPanel[][] board, Container window)
    {
        super(x, y, "bp", color, board, window);
        this.x = x;
        this.y = y;
        this.color = color;
        this.board = board;
        this.window = window;
    }

    public void calculateLegalMoves(int x, int y)
    {
        System.out.println(y);
        if (color.equals("white")) {
            //checks if pawn on starting square
            if (y == 6) {
                legalMoves.add(board[y - 2][x-1]);
                legalMoves.add(board[y-1][x-1]);
            }
            else legalMoves.add(board[y-1][x]);
        }
        else {
            legalMoves.add(board[y + 1][x]);
            //checks if pawn on starting square
            if (y == 1) {
                legalMoves.add(board[y + 2][x]);
            }
        }

        for (int i = 0; i < legalMoves.size(); i++)
        {
            legalMoves.get(i).setBackground(Color.orange);
            window.repaint();
        }
    }

    public void pieceMove(int newX, int newY, Color background, Piece moving)
    {
        for (int i = 0; i < legalMoves.size(); i++)
        {

            //checks to see if the newX and newY are valid moves
            if(legalMoves.get(i).getX()/125 == newX && legalMoves.get(i).getY()/125 == newY)
            {
                if(x == 125)
                {
                    board[y/125][7].remove(getPiece());
                }
                board[newY][newX].add(getPiece());

                getPiece().setBackground(background);
                window.repaint();

                moving.setX(newX*125);
                moving.setY(newY*125);
            }

        }

        //Clears legal move arraylist
        legalMoves.clear();
    }

}
