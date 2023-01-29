package main;

import java.awt.*;
import java.awt.image.BufferedImage;




public class Player extends Entity{
    private boolean left, right;
    private float playerSpeed = 2.0f;
    private float xDrawOffset = 17 * Game.SCALE;
    private float yDrawOffset = 22 * Game.SCALE;
    private BufferedImage[] animations;


    public Player(float x, float y, float w, float h){
        super(x, y, w, h);
        loadAnimations();
        initHitBox(x,y,32*Game.SCALE,43*Game.SCALE);
    }

    private void loadAnimations() {

        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
        animations = new BufferedImage[28];

        for(int j = 0; j < animations.length; j++)
            animations[j] = img.getSubimage(32 * j,0,32,32 );
    }



    public void render(Graphics g){
        g.drawImage(animations[5], (int) (hitBox.x - xDrawOffset),(int) (hitBox.y - yDrawOffset), (int)width, (int)height,null);
        drawHitBox(g);
    }

    public void resetDirBooleans() {
        left = false;
        right = false;

    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }




}
