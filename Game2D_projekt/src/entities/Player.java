package entities;

import main.Game;
import utilz.LoadSave;
import java.awt.*;
import java.awt.image.BufferedImage;
import static utilz.Constants.PlayerConstants.*;
import static utilz.HelpMethods.*;


public class Player extends Entity{
    private BufferedImage[] animations;
    private int animationTick, animationIndex = 0, animationSpeed = 15;
    private int playerAction = IDLE;
    private boolean moving = false, attacking = false;
    private boolean left, right, up, down, jump;
    private float playerSpeed = 2.0f;
    private int[][] lvlData;
    private float xDrawOffset = 17 * Game.SCALE;
    private float yDrawOffset = 22 * Game.SCALE;


    private float airSpeed = 0f;
    private float gravity = 0.03f * Game.SCALE;
    private float jumpSpeed = -2.25f * Game.SCALE;
    private float fallSpeedAfterCollision = 0.5f * Game.SCALE;
    private boolean inAir = false;


    public Player(float x, float y, float w, float h){
        super(x, y, w, h);
        loadAnimations();
        initHitBox(x,y,32*Game.SCALE,43*Game.SCALE);
    }

    public void update(){
        updatePosition();
        updateAnimationTick();
        setAnimations();
    }

    private void updatePosition() {
        moving = false;

        if(jump) {
            jump();
        }

        if(!left && !right && !inAir)
            return;

        float xSpeed = 0;

        if(left) {
            xSpeed -= playerSpeed;
        }
        if (right){
            xSpeed += playerSpeed;
        }

        if (!inAir)
            if (!IsEntityOnFloor(hitBox, lvlData))
                inAir = true;

        if(inAir){

            if(CanMoveHere(hitBox.x, hitBox.y + airSpeed, hitBox.width, hitBox.height, lvlData)) {
                hitBox.y += airSpeed;
                airSpeed += gravity;
                updateXPosition(xSpeed);
            }else{
                 hitBox.y = GetEntityYPosUnderRoofOrAboveFloor(hitBox,airSpeed);
                 hitBox.y += 48;
                 if(airSpeed > 0){
                     resetInAir();
                 }else{
                     airSpeed = fallSpeedAfterCollision;
                 }
                 updateXPosition(xSpeed);
            }
        }else {
            updateXPosition(xSpeed);
        }
        moving = true;
    }

    private void jump() {
        if (inAir)
            return;
        inAir = true;
        airSpeed = jumpSpeed;
    }

    private void resetInAir() {
        inAir = false;
        airSpeed = 0;
    }

    private void updateXPosition(float xSpeed) {
        if(CanMoveHere(hitBox.x + xSpeed, hitBox.y, hitBox.width, hitBox.height, lvlData)){
            hitBox.x += xSpeed;
        }
        else {
            hitBox.x = GetEntityXPosNextToWall(hitBox,xSpeed);
        }
    }

    private void updateAnimationTick() {
        animationTick++;
        if(animationTick >= animationSpeed){
            animationTick = 0;
            animationIndex++;
            if(animationIndex >= GetSpriteAmount(playerAction)) {
                animationIndex = playerAction;
                attacking = false;
            }
        }
    }

    public void render(Graphics g){
        g.drawImage(animations[animationIndex], (int) (hitBox.x - xDrawOffset),(int) (hitBox.y - yDrawOffset), (int)width, (int)height,null);
        //drawHitBox(g);
    }

    private void setAnimations() {
        int startAnimation = playerAction;

        if(moving){
            playerAction = RUNNING;
            animationSpeed = 15;
        }
        else {
            playerAction = IDLE;
            animationSpeed = 45;
        }

        if (inAir){
            playerAction = JUMP;
            animationSpeed = 45;
        }

        if(attacking){
            playerAction = ATTACK;
            animationSpeed = 25;
        }
        if(startAnimation != playerAction)
            resetAnimationTick();
    }

    private void resetAnimationTick() {
        animationTick = 0;
        animationIndex = playerAction;
    }

    private void loadAnimations() {

        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
        animations = new BufferedImage[28];

        for(int j = 0; j < animations.length; j++)
                animations[j] = img.getSubimage(32 * j,0,32,32 );
    }

    public void loadLvlData(int[][] lvlData){
        this.lvlData = lvlData;
    }

    public void setAttacking(boolean attacking){
        this.attacking = attacking;
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    @Override
    public String toString(){
        return "Player, current action:" + playerAction;
    }


}
