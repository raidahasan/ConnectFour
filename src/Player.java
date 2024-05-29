import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private String name = "";
    private BufferedImage image;
    private int x = 0;
    private int y = 0;
    public Player(String link, String n){
        name = n;
        try{
            image = ImageIO.read(new File(link));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }
}
