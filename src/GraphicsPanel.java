import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private BufferedImage background;
    private Player player1;
    private Player player2;
    private boolean[] pressedKeys;
    private Timer timer;
    private int time;
    private int[][] board = new int[6][7];

    public GraphicsPanel(String name, String name2) {
        try {
            background = ImageIO.read(new File("src/background.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
        pressedKeys = new boolean[128];
        timer = new Timer(1000, this);
        player1 = new Player("src/c4.png", name);
        player2 = new Player("src/c4.png", name2);
        }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    // key stuff
    public void keyTyped(KeyEvent e) { } // unimplemented

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

    //mouse stuff
    public void mouseClicked(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }




    public void actionPerformed(ActionEvent e) {
    }
}
