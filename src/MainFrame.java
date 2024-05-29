import javax.swing.*;

public class MainFrame implements Runnable {

    private GraphicsPanel panel;

    public MainFrame(String name1, String name2) {
        JFrame frame = new JFrame("Connect4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        panel = new GraphicsPanel(name1, name2);
        frame.add(panel);
        frame.setVisible(true);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (true) {
            panel.repaint();
        }
    }
}
