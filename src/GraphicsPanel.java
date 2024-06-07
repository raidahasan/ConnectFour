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
    private WhiteCircle wC = new WhiteCircle(200, 0);
    private RedCircle rC = new RedCircle(200, 0);
    private BufferedImage redCircle;
    private BufferedImage whiteCircle;
    private boolean[] pressedKeys;
    private JButton row1;
    private JButton row2;
    private JButton row3;
    private JButton row4;
    private JButton row5;
    private JButton row6;
    private JButton row7;
    private boolean r1 = false;
    private boolean r2 = false;
    private boolean r3 = false;
    private boolean r4 = false;
    private boolean r5 = false;
    private boolean r6 = false;
    private boolean r7 = false;



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
        player1 = new Player("src/c4.png", name);
        player2 = new Player("src/c4.png", name2);
        p1Turn =  true;
        p2Turn = false;
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
        for(int i = 0; i < 6; i++){
            for(int j = 0; j<7; j++){
                if(board[i][j]==1){
                    int x = 190 + (j*113); //(j*113)+35;
                    int y = 573 - ((5-i)*110); //(i*110)+205;
                    g.drawImage(whiteCircle, x, y, null);
                }else if(board[i][j]==2){
                    if(j == 6){
                        int x = 194 + (j*113); //(j*113)+35;
                        int y = 580 - ((5-i)*110); //(i*110)+205;
                        g.drawImage(redCircle, x, y, null);
                    }else {
                        int x = 200 + (j * 113); //(j*113)+35;
                        int y = 580 - ((5 - i) * 110); //(i*110)+205;
                        g.drawImage(redCircle, x, y, null);
                    }
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

        //PLAYER ONE

        if(draw && p1Turn && r1){
            wC.moveDown();
            g.drawImage(wC.getCircle(), wC.getX(), wC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][0] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(wC.getY() >= j){
                draw = false;
                r1 = false;
            }
            if(p1Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][0] == 0){
                        board[i][0] = 1;
                        r1 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p1Turn && r2){
            wC.moveDown();
            g.drawImage(wC.getCircle(), wC.getX(), wC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][1] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(wC.getY() >= j){
                draw = false;
                r2 = false;
            }
            if(p1Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][1] == 0){
                        board[i][1] = 1;
                        r2 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p1Turn && r3){
            wC.moveDown();
            g.drawImage(wC.getCircle(), wC.getX(), wC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][2] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(wC.getY() >= j){
                draw = false;
                r3 = false;
            }
            if(p1Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][2] == 0){
                        board[i][2] = 1;
                        r3 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p1Turn && r4){
            wC.moveDown();
            g.drawImage(wC.getCircle(), wC.getX(), wC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][3] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(wC.getY() >= j){
                draw = false;
                r4 = false;
            }
            if(p1Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][3] == 0){
                        board[i][3] = 1;
                        r4 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p1Turn && r5){
            wC.moveDown();
            g.drawImage(wC.getCircle(), wC.getX(), wC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][4] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(wC.getY() >= j){
                draw = false;
                r5 = false;
            }
            if(p1Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][4] == 0){
                        board[i][4] = 1;
                        r5 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p1Turn && r6){
            wC.moveDown();
            g.drawImage(wC.getCircle(), wC.getX(), wC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][5] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(wC.getY() >= j){
                draw = false;
                r6 = false;
            }
            if(p1Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][5] == 0){
                        board[i][5] = 1;
                        r6 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p1Turn && r7){
            wC.moveDown();
            g.drawImage(wC.getCircle(), wC.getX(), wC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][6] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(wC.getY() >= j){
                draw = false;
                r7 = false;
            }
            if(p1Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][6] == 0){
                        board[i][6] = 1;
                        r7 = false;
                        break;
                    }
                }
            }
        }

        //PLAYER TWO
        if(draw && p2Turn && r1){
            rC.moveDown();
            g.drawImage(rC.getCircle(), rC.getX(), rC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][0] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(rC.getY() >= j){
                draw = false;
                r1 = false;
            }
            if(p2Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][0] == 0){
                        board[i][0] = 2;
                        r1 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p2Turn && r2){
            rC.moveDown();
            g.drawImage(rC.getCircle(), rC.getX(), rC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][1] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(rC.getY() >= j){
                draw = false;
                r2 = false;
            }
            if(p2Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][1] == 0){
                        board[i][1] = 2;
                        r2 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p2Turn && r3){
            rC.moveDown();
            g.drawImage(rC.getCircle(), rC.getX(), rC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][2] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(rC.getY() >= j){
                draw = false;
                r3 = false;
            }
            if(p2Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][2] == 0){
                        board[i][2] = 2;
                        r3 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p2Turn && r4){
            rC.moveDown();
            g.drawImage(rC.getCircle(), rC.getX(), rC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][3] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(rC.getY() >= j){
                draw = false;
                r4 = false;
            }
            if(p2Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][3] == 0){
                        board[i][3] = 2;
                        r4 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p2Turn && r5){
            rC.moveDown();
            g.drawImage(rC.getCircle(), rC.getX(), rC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][4] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(rC.getY() >= j){
                draw = false;
                r5 = false;
            }
            if(p2Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][4] == 0){
                        board[i][4] = 2;
                        r5 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p2Turn && r6){
            rC.moveDown();
            g.drawImage(rC.getCircle(), rC.getX(), rC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][5] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(rC.getY() >= j){
                draw = false;
                r6 = false;
            }
            if(p2Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][5] == 0){
                        board[i][5] = 2;
                        r6 = false;
                        break;
                    }
                }
            }
        }
        if(draw && p2Turn && r7){
            rC.moveDown();
            g.drawImage(rC.getCircle(), rC.getX(), rC.getY(), null);
            int j = 0;
            for(int i = 5; i>=0; i--){
                if(board[i][6] == 0){
                    j = 573 - ((5-i)*110);
                    break;
                }
            }
            if(rC.getY() >= j){
                draw = false;
                r7 = false;
            }
            if(p2Turn && !draw){
                for(int i = 5; i>=0; i--){
                    if(board[i][6] == 0){
                        board[i][6] = 2;
                        r7 = false;
                        break;
                    }
                }
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
                r1= true;
                draw = true;
                wC = new WhiteCircle(190, 0);
                rC = new RedCircle(200, 0);
            }else if(jb == row2){
                r2= true;
                draw = true;
                wC = new WhiteCircle(303, 0);
                rC = new RedCircle(313, 0);
            }else if(jb == row3){
                r3= true;
                draw = true;
                wC = new WhiteCircle(416, 0);
                rC = new RedCircle(426, 0);
            }else if(jb == row4){
                r4= true;
                draw = true;
                wC = new WhiteCircle(529, 0);
                rC = new RedCircle(539, 0);
            }else if(jb == row5){
                r5= true;
                draw = true;
                wC = new WhiteCircle(642, 0);
                rC = new RedCircle(652, 0);
            }else if(jb == row6){
                r6= true;
                draw = true;
                wC = new WhiteCircle(755, 0);
                rC = new RedCircle(765, 0);
            }else if(jb == row7){
                r7= true;
                draw = true;
                wC = new WhiteCircle(868, 0);
                rC = new RedCircle(873, 0);
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
