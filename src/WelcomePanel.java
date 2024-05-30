import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomePanel extends JPanel implements ActionListener {

    private JTextField name1;
    private JTextField name2;
    private JButton submitButton;
    private JFrame enclosingFrame;
    private BufferedImage c4;

    public WelcomePanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            c4 = ImageIO.read(new File("src/c4.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        name1 = new JTextField(10);
        name2 = new JTextField(10);
        submitButton = new JButton("Submit");
        add(name1);
        add(name2);
        add(submitButton);
        submitButton.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(c4, 150, 10, null);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.blue);
        g.drawString("Enter names in the boxes below:", 50, 30);
        name1.setLocation(30, 50);
        name2.setLocation(170, 50);
        submitButton.setLocation(50, 100);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == submitButton) {
                String playerName = name1.getText();
                String playerName2 = name2.getText();
                MainFrame f = new MainFrame(playerName, playerName2);
                enclosingFrame.setVisible(false);
            }
        }
    }
}
