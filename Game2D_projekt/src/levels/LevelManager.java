package levels;

import main.Game;
import utilz.LoadImages;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static main.Game.*;

public class LevelManager {
    private final Game game;
    private ArrayList<BufferedImage> levelSprite;
    private Level levelOne;
    private final int width = 12;
    private final int height = 4;

    public LevelManager(Game game){
        this.game = game;
        importOutsideSprites();
        levelOne = new Level(LoadImages.GetLevelData());
    }

    private void importOutsideSprites() {
        BufferedImage img = LoadImages.GetSpriteAtlas(LoadImages.LEVEL_ATLAS);
        levelSprite = new ArrayList<BufferedImage>();
        for(int j = 0; j< height; j++)
            for (int i = 0; i<width; i++){
                //int index = j * width + i;
                levelSprite.add(img.getSubimage(i*32,j*32,32,32));
            }
    }

    public void draw(Graphics g){
        //level
        for(int j = 0; j< Game.TILES_IN_HEIGHT; j++)
            for(int i = 0; i < Game.TILES_IN_WIDTH; i++){
                int index = levelOne.getSpriteIndex(i, j);
                g.drawImage(levelSprite.get(index),TILES_SIZE * i,TILES_SIZE * j,TILES_SIZE,TILES_SIZE,null);
            }
    }

    public void drawBackground(Graphics g) {
        g.drawImage(LoadImages.GetImage(LoadImages.BACKGROUND_DATA),0,0,GAME_WIDTH,GAME_HEIGHT,null);
    }

    public void drawWinImage(Graphics g){
        g.drawImage(LoadImages.GetImage(LoadImages.WIN_IMAGE),0,0,GAME_WIDTH,GAME_HEIGHT,null);
    }

    public Level getCurrentLevel(){
        return levelOne;
    }


}
