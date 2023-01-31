package entities;

import main.Game;
import utilz.Constants;
import utilz.LoadImages;
import java.awt.*;
import java.awt.image.BufferedImage;
import static utilz.Constants.PlayerConstants.*;
import static utilz.HelpMethods.*;


public class Player extends Entity{
    private BufferedImage[] animations;
    private int animationTick, animationIndex = 0, animationSpeed = 15;
    private int playerAction = IDLE;
    private boolean moving = false, attacking = false, win = false;
    private boolean left, right, up, down, jump;
    private float playerSpeed = 2.0f;
    private int[][] lvlData;
    private float xDrawOffset = 17 * Game.SCALE;
    private float yDrawOffset = 22 * Game.SCALE;

    private float timeToRespown = 0;
    private float timeToRestart = 5;
    private int deadPlayer = Constants.PlayerConstants.GetSpriteAmount(DYING);

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
        isDeadOrWin();
        setAnimations();
    }

    public void isDeadOrWin() {
        if(hitBox.y + 65 == Game.GAME_HEIGHT && animationIndex != deadPlayer){
            playerAction = DYING;
        }

        if(timeToRespown >= timeToRestart) {
            respawn();
        }else if (animationIndex == deadPlayer) {
            timeToRespown += 1;
        }

        if(hitBox.x >= 1200 && hitBox.y == 575.0){
            timeToRespown += 0.02f;
            if(timeToRespown >= 1.0){
                win = true;
            }
        }
        else win = false;
    }

    private void respawn(){
        hitBox.x = Game.playerStartX;
        hitBox.y = Game.playerStartY;
        playerAction = IDLE;
        timeToRespown = 0;
        resetAnimationTick();
    }

    public void updatePosition() {
        moving = false;

        if(playerAction != DYING) {
            if (jump && !win) {
                jump();
            }

            if (!left && !right && !inAir)
                return;

            float xSpeed = 0;

            if (left) {
                xSpeed -= playerSpeed;
            }
            if (right) {
                xSpeed += playerSpeed;
            }

            if (!inAir)
                if (!IsEntityOnFloor(hitBox, lvlData))
                    inAir = true;

            if (inAir) {

                if (CanMoveHere(hitBox.x, hitBox.y + airSpeed, hitBox.width, hitBox.height, lvlData)) {
                    hitBox.y += airSpeed;
                    airSpeed += gravity;
                    updateXPosition(xSpeed);
                } else {
                    hitBox.y = GetEntityYPosUnderRoofOrAboveFloor(hitBox, airSpeed);
                    hitBox.y += 48;
                    if (airSpeed > 0) {
                        resetInAir();
                    } else {
                        airSpeed = fallSpeedAfterCollision;
                    }
                    updateXPosition(xSpeed);
                }
            } else {
                updateXPosition(xSpeed);
            }
            moving = true;
        }
    }

    public void jump() {
        if (inAir)
            return;
        inAir = true;
        airSpeed = jumpSpeed;
    }

    public void resetInAir() {
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
            if(animationIndex + 1 == deadPlayer )
                animationIndex = deadPlayer;
            if(animationIndex != deadPlayer){
                animationIndex++;
                if(animationIndex >= GetSpriteAmount(playerAction)) {
                    animationIndex = playerAction;
                    attacking = false;
                }
            }
        }
    }

    public void render(Graphics g){
        g.drawImage(animations[animationIndex], (int) (hitBox.x - xDrawOffset),(int) (hitBox.y - yDrawOffset), (int)width, (int)height,null);
        //drawHitBox(g);
    }

    private void setAnimations() {
        int startAnimation = playerAction;

        if(playerAction != DYING && animationIndex != deadPlayer){
            if (moving) {
                playerAction = RUNNING;
                animationSpeed = 15;
            } else {
                playerAction = IDLE;
                animationSpeed = 45;
            }

            if (inAir) {
                playerAction = JUMP;
                animationSpeed = 45;
            }

            if (attacking) {
                playerAction = ATTACK;
                animationSpeed = 25;
            }
            if (startAnimation != playerAction)
                resetAnimationTick();
        }
    }

    private void resetAnimationTick() {

        animationTick = 0;
        animationIndex = playerAction;
    }

    private void loadAnimations() {

        BufferedImage img = LoadImages.GetSpriteAtlas(LoadImages.PLAYER_ATLAS);
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

    @Override
    public String toString(){
        return "Player, current action:" + playerAction+"/"+ animationIndex+", coordination:"+hitBox.x+", "+hitBox.y;
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

    public boolean isWin() {
        return win;
    }

    public BufferedImage[] getAnimations() {
        return animations;
    }

    public int getAnimationTick() {
        return animationTick;
    }

    public int getAnimationIndex() {
        return animationIndex;
    }

    public int getAnimationSpeed() {
        return animationSpeed;
    }

    public int getPlayerAction() {
        return playerAction;
    }

    public boolean isMoving() {
        return moving;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isJump() {
        return jump;
    }

    public float getPlayerSpeed() {
        return playerSpeed;
    }

    public int[][] getLvlData() {
        return lvlData;
    }

    public float getxDrawOffset() {
        return xDrawOffset;
    }

    public float getyDrawOffset() {
        return yDrawOffset;
    }

    public float getTimeToRespown() {
        return timeToRespown;
    }

    public float getTimeToRestart() {
        return timeToRestart;
    }

    public int getDeadPlayer() {
        return deadPlayer;
    }

    public float getAirSpeed() {
        return airSpeed;
    }

    public float getGravity() {
        return gravity;
    }

    public float getJumpSpeed() {
        return jumpSpeed;
    }

    public float getFallSpeedAfterCollision() {
        return fallSpeedAfterCollision;
    }

    public boolean isInAir() {
        return inAir;
    }

    public void setAnimations(BufferedImage[] animations) {
        this.animations = animations;
    }

    public void setAnimationTick(int animationTick) {
        this.animationTick = animationTick;
    }

    public void setAnimationIndex(int animationIndex) {
        this.animationIndex = animationIndex;
    }

    public void setAnimationSpeed(int animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

    public void setPlayerAction(int playerAction) {
        this.playerAction = playerAction;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public void setPlayerSpeed(float playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    public void setLvlData(int[][] lvlData) {
        this.lvlData = lvlData;
    }

    public void setxDrawOffset(float xDrawOffset) {
        this.xDrawOffset = xDrawOffset;
    }

    public void setyDrawOffset(float yDrawOffset) {
        this.yDrawOffset = yDrawOffset;
    }

    public void setTimeToRespown(float timeToRespown) {
        this.timeToRespown = timeToRespown;
    }

    public void setTimeToRestart(float timeToRestart) {
        this.timeToRestart = timeToRestart;
    }

    public void setDeadPlayer(int deadPlayer) {
        this.deadPlayer = deadPlayer;
    }

    public void setAirSpeed(float airSpeed) {
        this.airSpeed = airSpeed;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }


    public void setJumpSpeed(float jumpSpeed) {
        this.jumpSpeed = jumpSpeed;
    }

    public void setFallSpeedAfterCollision(float fallSpeedAfterCollision) {
        this.fallSpeedAfterCollision = fallSpeedAfterCollision;
    }

    public void setInAir(boolean inAir) {
        this.inAir = inAir;
    }
}
