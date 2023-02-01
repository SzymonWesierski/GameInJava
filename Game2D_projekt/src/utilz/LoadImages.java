package utilz;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadImages {
    public static final String PLAYER_ATLAS = "Player_Sprite/FinnSprite.png";
    public static final String LEVEL_ATLAS = "Environment/outside_sprites.png";
    public static final String LEVEL_ONE_DATA = "Environment/level_one_data.png";
    public static final String WIN_IMAGE = "win.png";
    public static final String BACKGROUND_DATA = "Environment/sea.png";

    public static BufferedImage GetSpriteAtlas(String filename){
        BufferedImage img = null;
        InputStream is = LoadImages.class.getResourceAsStream("/" + filename);

        try{
            img = ImageIO.read(is);
        } catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    public static BufferedImage GetImage(String filename){
        BufferedImage img = null;
        InputStream is = LoadImages.class.getResourceAsStream("/" + filename);

        try{
            img = ImageIO.read(is);
        } catch(IOException e){
            //e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    public static int[][] GetLevelData(){
        int[][] lvlData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
        BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);

        for(int j = 0; j< img.getHeight(); j++)
            for(int i = 0; i < img.getWidth(); i++){
                Color color = new Color(img.getRGB(i,j));
                int value = color.getRed();
                if(value >= 48)
                    value = 0;
                lvlData[j][i] = value;
            }
        return lvlData;
    }
}
