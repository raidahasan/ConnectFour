import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private BufferedImage background;
    private BufferedImage c4board;

    private Player player1;
    private Player player2;
    private boolean p1Turn;
    private boolean p2Turn;
    private boolean draw = false;
    private WhiteCircle wC;
    private RedCircle rC;
    private BufferedImage redCircle;
    private BufferedImage whiteCircle;
    private boolean[] pressedKeys;
    private Timer timer;
    private int time;
    private JButton row1;
    private JButton row2;
    private JButton row3;
    private JButton row4;
    private JButton row5;
    private JButton row6;
    private JButton row7;

    private int[][] board = new int[6][7];

    public GraphicsPanel(String name, String name2) {
        for(int i = 0; i < 6; i++){
            for(int j = 0; j<7; j++){
                board[i][j] = 0;
            }
        }
        try {
            background = ImageIO.read(new File("src/background.png"));
            c4board = ImageIO.read(new File("src/board.png"));
            redCircle = ImageIO.read(new File("src/redCircle.png"));
            whiteCircle = ImageIO.read(new File("src/whiteCircle.png"));
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
        p1Turn =  false;
        p2Turn = true;
        row1 = new JButton("Row 1");
        row2 = new JButton("Row 2");
        row3 = new JButton("Row 3");
        row4 = new JButton("Row 4");
        row5 = new JButton("Row 5");
        row6 = new JButton("Row 6");
        row7 = new JButton("Row 7");

        row1.setFocusable(false);
        add(row1);
        row1.addActionListener(this);

        row2.setFocusable(false);
        add(row2);
        row2.addActionListener(this);

        row3.setFocusable(false);
        add(row3);
        row3.addActionListener(this);

        row4.setFocusable(false);
        add(row4);
        row4.addActionListener(this);

        row5.setFocusable(false);
        add(row5);
        row5.addActionListener(this);

        row6.setFocusable(false);
        add(row6);
        row6.addActionListener(this);

        row7.setFocusable(false);
        add(row7);
        row7.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        for(int i = 1; i <= 6; i++){
            for(int j = 1; j<=7; j++){
                if(board[i-1][j-1]==1){
                    int x = (j*113)+35;
                    int y = (i*110)+205;
                    g.drawImage(whiteCircle, x, y, null);
                }
            }
        }
//        g.drawImage(redCircle, 205, 35, null);
//        g.drawImage(redCircle, 318, 145, null);
//        g.drawImage(redCircle, 431, 255, null);
//        g.drawImage(redCircle, 205, 35, null);
        // x dif == 113
        // y diff == 110
        row1.setLocation(230, 0);
        row2.setLocation(343, 0);
        row3.setLocation(456, 0);
        row4.setLocation(569, 0);
        row5.setLocation(682, 0);
        row6.setLocation(795, 0);
        row7.setLocation(908, 0);
        if(draw && p1Turn){
            g.drawImage(wC.getWhiteCircle(), wC.getX(), wC.getY(), null);
            wC.moveDown();
            if(wC.getY() >= 590){
                draw = false;
                board[0][5] = 1;
            }
        }
        g.drawImage(c4board, 200, 20, null);
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
        if(e.getSource() instanceof JButton){
            JButton jb = (JButton) e.getSource();
            if(jb == row1){
                if(p1Turn){
                    draw = true;
                    wC = new WhiteCircle("src/whiteCircle.png", 205, 0);
                }
            }else if(jb == row2){

            }else if(jb == row3){

            }else if(jb == row4){

            }else if(jb == row5){

            }else if(jb == row6){

            }else if(jb == row7){

            }
            if(p1Turn){
                p2Turn = true;
                p1Turn = false;
            }else{
                p2Turn = false;
                p1Turn = true;
            }
        }
    }
}
