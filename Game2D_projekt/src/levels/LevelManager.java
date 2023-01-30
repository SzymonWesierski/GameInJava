package levels;

import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static main.Game.TILES_SIZE;

public class LevelManager {
    private final Game game;
    private BufferedImage[] levelSprite;
    private Level levelOne;
    private final int width = 12;
    private final int height = 4;

    public LevelManager(Game game){
        this.game = game;
        importOutsideSprites();
        levelOne = new Level(LoadSave.GetLevelData());
    }

    private void importOutsideSprites() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
        levelSprite = new BufferedImage[48];
        for(int j = 0; j< height; j++)
            for (int i = 0; i<width; i++){
                int index = j * width + i;
                levelSprite[index] = img.getSubimage(i*32,j*32,32,32);
            }
    }

    public void draw(Graphics g){
        for(int j = 0; j< Game.TILES_IN_HEIGHT; j++)
            for(int i = 0; i < Game.TILES_IN_WIDTH; i++){
                int index = levelOne.getSpriteIndex(i, j);
                g.drawImage(levelSprite[index],TILES_SIZE * i,TILES_SIZE * j,TILES_SIZE,TILES_SIZE,null);
            }

    }

    public void update(){

    }

    public Level getCurrentLevel(){
        return levelOne;
    }
}
