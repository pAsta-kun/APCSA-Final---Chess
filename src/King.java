import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class King extends Piece {

    private String color;
    private JPanel[][] board;
    private ArrayList<JPanel> legalMoves = new ArrayList<>();
    private Container window;
    private int x;
    private int y;

    public King(int x, int y, String color, JPanel[][] board, Container window)
    {
        super(x, y, "king", color, board, window);

        this.x = x;
        this.y = y;
        this.color = color;
        this.board = board;
        this.window = window;
    }

    @Override
    public void calculateLegalMoves(int x, int y) {
        // King can move in all eight directions but only one step
        if (x > 0) {
            legalMoves.add(board[y][x - 1]); // left
            if (y > 0) legalMoves.add(board[y - 1][x - 1]); // up left
            if (y < 7) legalMoves.add(board[y + 1][x - 1]); // down left
        }
        if (x < 7) {
            legalMoves.add(board[y][x + 1]); // right
            if (y > 0) legalMoves.add(board[y - 1][x + 1]); // up right
            if (y < 7) legalMoves.add(board[y + 1][x + 1]); // down right
        }
        if (y > 0) legalMoves.add(board[y - 1][x]); // up
        if (y < 7) legalMoves.add(board[y + 1][x]); // down

    }
}