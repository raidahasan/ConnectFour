import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WhiteCircle {
    private BufferedImage whiteCircle;
    private int x;
    private int y;
    public WhiteCircle(String link, int X, int Y){
        try{
            whiteCircle = ImageIO.read(new File(link));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        x = X;
        y = Y;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }

    public void moveDown(){ y+=3; }
    public BufferedImage getWhiteCircle(){
        return whiteCircle;
    }
}
