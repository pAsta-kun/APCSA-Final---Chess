import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece
{
    private String color;
    private JPanel[][] board;
    private ArrayList<JPanel> legalMoves = new ArrayList<>();
    private Container window;
    private int x;
    private int y;

    public Knight()
    {
        super();
    }

    public Knight(int x, int y, String color, JPanel[][] board, Container window)
    {
        super(x, y, "bn", color, board, window);
        this.x = x;
        this.y = y;
        this.color = color;
        this.board = board;
        this.window = window;
    }

    public void calculateLegalMoves(int x, int y)
    {

        // these are all the possible moves for a knight
        int[][] moves = {
                {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}
        };

        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];

            // check if new position is within board boundaries
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[newX].length) {
                legalMoves.add(board[newX][newY]);
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
            System.out.println("x1: " + legalMoves.get(i).getX()/125);
            System.out.println(newX);
            System.out.println("y1: " + legalMoves.get(i).getY()/125);
            System.out.println(newY);

            //checks to see if the newX and newY are valid moves
            if(legalMoves.get(i).getX()/125 == newX && legalMoves.get(i).getY()/125 == newY)
            {
                board[newY][newX].add(getPiece());
                board[y/125][x/125].remove(getPiece());
                window.repaint();
                moving.setX(newX*125);
                moving.setY(newY*125);
            }


        }

        //Clears legal move arraylist
        legalMoves.clear();
    }
}
