import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RedCircle {
    private BufferedImage redCircle;
    private int x;
    private int y;
    public RedCircle(String link, int X, int Y){
        try{
            redCircle = ImageIO.read(new File(link));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        x = X;
        y = Y;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }

    public void moveDown(){ y++; }
    public BufferedImage getRedCircle(){
        return redCircle;
    }
}
