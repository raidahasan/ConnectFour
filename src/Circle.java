import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Circle {
    private BufferedImage Circle;
    private int x;
    private int y;
    public Circle(String link, int X, int Y){
        try{
            Circle = ImageIO.read(new File(link));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        x = X;
        y = Y;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }

    public void moveDown(){ y+=9; }
    public BufferedImage getCircle(){
        return Circle;
    }
}
