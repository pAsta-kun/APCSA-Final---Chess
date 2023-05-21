import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece
{
    private String color;
    private JPanel[][] board;
    private ArrayList<JPanel> legalMoves = new ArrayList<>();
    private Container window;
    private int x;
    private int y;

    public Queen(int x, int y, String color, JPanel[][] board, Container window)
    {
        super(x, y, "q", color, board, window);

        this.x = x;
        this.y = y;
        this.color = color;
        this.board = board;
        this.window = window;
    }

    @Override
    public void calculateLegalMoves(int x, int y)
    {
        // queen can move any number of squares along rank, file, or diagonal
        for(int i = 0; i < 8; i++) {
            if(i != y) {
                legalMoves.add(board[i][x]);
            }
            if(i != x) {
                legalMoves.add(board[y][i]);
            }
        }
    }
}
