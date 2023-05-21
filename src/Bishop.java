import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece
{

    private String color;
    private JPanel[][] board;
    private ArrayList<JPanel> legalMoves = new ArrayList<>();
    private Container window;
    private int x;
    private int y;

    public Bishop(int x, int y, String color, JPanel[][] board, Container window)
    {
        super(x, y, "b", color, board, window);

        this.x = x;
        this.y = y;
        this.color = color;
        this.board = board;
        this.window = window;
    }

    @Override
    public void calculateLegalMoves(int x, int y)
    {
        // bishop can move any number of squares diagonally

    }
}
