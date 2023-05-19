import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PawnV2 extends Piece
{

    private String color;
    private JPanel[][] board;
    private ArrayList<JPanel> legalMoves = new ArrayList<>();
    private Container window;
    private int x;
    private int y;
    public PawnV2()
    {
        super();
    }

    public PawnV2(int x, int y, String color, JPanel[][] board, Container window)
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
        if (color.equals("white")) {
            legalMoves.add(board[y-1][x-1]);
            //checks if pawn on starting square
            if (y == 6) {
                legalMoves.add(board[y - 2][x-1]);
            }
        }
        else {
            legalMoves.add(board[y + 1][x]);
            //checks if pawn on starting square
            if (y == 1) {
                legalMoves.add(board[y + 2][x]);
            }
        }
    }

    public void pieceMove(int newX, int newY, Color background)
    {
        for (int i = 0; i < legalMoves.size(); i++)
        {
            System.out.println("x1: " + legalMoves.get(i).getX()/125);
            System.out.println(newX);
            System.out.println("y1: " + legalMoves.get(i).getY()/125);
            System.out.println(newY);

            //checks to see if the newX and newY are valid moves
            if(legalMoves.get(i).getX()/125 == newX && legalMoves.get(i).getY()/125 == newY)
            {
                board[newY][newX].add(getPiece());
                board[y/125][x/125].remove(getPiece());
                getPiece().setBackground(background);
                window.repaint();
            }

            x = newX;
            y = newY;
        }

        //Clears legal move arraylist
        legalMoves.clear();
    }

}
