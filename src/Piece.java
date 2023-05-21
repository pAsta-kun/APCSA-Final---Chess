import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Piece extends JButton implements ActionListener {

    private int x;
    private int y;
    private String type;
    private String color;
    private JPanel[][] board;
    private JButton piece;
    private Container window;
    ImageIcon icon;
    ArrayList<JPanel> legalMoves = new ArrayList<>();

    public Piece() {

    }

    public Piece(int x, int y, String type, String color, JPanel board[][], Container window) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.color = color;
        this.board = board;
        this.window = window;
        setUpPiece(type, color);
    }

    public void setUpPiece(String type, String color) {
        if (color.equals("white")) {
            if (type.equals("bp"))
                icon = new ImageIcon("src/pieces/wp.png");
            else if (type.equals("br"))
                icon = new ImageIcon("src/pieces/wr.png");
        }

        else
            icon = new ImageIcon("src/pieces/" + type + ".png");
        piece = new JButton(icon);

        piece.setPreferredSize(new Dimension(125, 125));
        piece.setBackground(Color.decode("#B58863"));
        piece.addActionListener(this);
        window.repaint();
    }

    public void setBackgroundColor(String color) {
        piece.setBackground(Color.decode(color));
    }

    public JButton getPiece() {
        return piece;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void calculateLegalMoves(int x, int y) {

    }

    public void pieceMove(int newX, int newY, Color background, Piece moving) {
        for (int i = 0; i < legalMoves.size(); i++) {
            System.out.println("x1: " + legalMoves.get(i).getX() / 125);
            System.out.println(newX);
            System.out.println("y1: " + legalMoves.get(i).getY() / 125);
            System.out.println(newY);

            // checks to see if the newX and newY are valid moves
            if (legalMoves.get(i).getX() / 125 == newX && legalMoves.get(i).getY() / 125 == newY) {
                board[newY][newX].add(getPiece());
                board[y / 125][x / 125].remove(getPiece());
            }

            x = newX;
            y = newY;
        }

        // Clears legal move arraylist
        for (int i = 0; i < legalMoves.size(); i++) {
            legalMoves.remove(i);
        }

        System.out.println(getPiece());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            // Calculates legal moves based on current position
            // System.out.println(x);
            legalMoves.clear();
            calculateLegalMoves(x / 125, y / 125);
            // pieceMove(3,4);
        }
    }
}
