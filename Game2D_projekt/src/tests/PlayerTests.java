package tests;

import entities.Player;
import main.Game;
import org.junit.Before;
import org.junit.Test;
import levels.LevelManager;
import utilz.Constants;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static main.Game.*;
import static org.junit.Assert.*;
import static utilz.Constants.PlayerConstants.DYING;
import static utilz.Constants.PlayerConstants.IDLE;

public class PlayerTests {
    private LevelManager levelManager;
    private Player player;

    @Before
    public void setUp() {
        levelManager = new LevelManager(new Game());
        player = new Player(playerStartX,playerStartY,(int)(80 * SCALE),(int)(80 * SCALE));
    }

    @Test
    public void jumpTest() {
        player.setJump(true);
        player.loadLvlData(levelManager.getCurrentLevel().getLvlData());
        player.updatePosition();
        assertTrue(player.isInAir());
        assertEquals(-2.25 * Game.SCALE, player.getAirSpeed(), 0.1);
    }

    @Test
    public void testRespawn() {
        player.setTimeToRespown(player.getTimeToRestart() + 1);
        player.update();
        assertEquals(player.getHitBox().x, playerStartX, 0.001);
        assertEquals(player.getHitBox().y, playerStartY, 0.001);
        assertEquals(player.getPlayerAction(), IDLE);
        assertEquals(player.getTimeToRespown(), 0, 0.001);
    }

    @Test
    public void updatePositionTest() {
        player.loadLvlData(levelManager.getCurrentLevel().getLvlData());

        player.setLeft(true);
        player.updatePosition();
        assertEquals(98, player.getHitBox().x, 0.1);
        player.setLeft(false);

        player.setRight(true);
        player.updatePosition();
        assertEquals(100, player.getHitBox().x, 0.1);
    }
    @Test
    public void testDying() {
        player.getHitBox().y = Game.GAME_HEIGHT - 65;
        player.update();
        assertEquals(player.getPlayerAction(), DYING);
    }

    @Test
    public void isDeadOrWinTest() {
        player.getHitBox().y = Game.GAME_HEIGHT - 65;
        player.update();
        assertEquals(Constants.PlayerConstants.DYING, player.getPlayerAction());
        player.setTimeToRespown(5);
        player.update();
        assertEquals(Game.playerStartX, player.getHitBox().x, 0.1);
        assertEquals(Game.playerStartY, player.getHitBox().y, 0.1);
        player.getHitBox().x = 1200;
        player.getHitBox().y = 575;
        player.setTimeToRespown(2);
        player.update();
        assertTrue(player.isWin());
    }

    @Test
    public void testResetInAir() {
        player.jump();
        player.resetInAir();
        assertEquals(false, player.isInAir());
    }

    @Test
    public void testToString() {
        String expected = "Player, current action:0/0, coordination:100.0, 575.0";
        assertEquals(expected, player.toString());
    }

    @Test
    public void testResetDirBooleans() {
        player.setUp(true);
        player.setDown(true);
        player.setLeft(true);
        player.setRight(true);

        player.resetDirBooleans();

        assertFalse(player.isUp());
        assertFalse(player.isDown());
        assertFalse(player.isLeft());
        assertFalse(player.isRight());
    }

    @Test
    public void testRight() {
        player.setRight(true);
        assertEquals(true, player.isRight());
    }

    @Test
    public void testLeft() {
        player.setLeft(true);
        assertEquals(true, player.isLeft());
    }

    @Test
    public void testJump() {
        player.setJump(true);
        assertEquals(true, player.isJump());
    }

    @Test
    public void testUp() {
        player.setUp(true);
        assertTrue( player.isUp());
    }

    @Test
    public void testDown() {
        player.setDown(true);
        assertTrue( player.isDown());
    }

    @Test
    public void testAnimations() {
        ArrayList<BufferedImage> newArray = new ArrayList<>();
        player.setAnimations(newArray);
        assertEquals(newArray, player.getAnimations());
    }

    @Test
    public void testAnimationTick() {
        int number = 5;
        player.setAnimationTick(number);
        assertEquals(number, player.getAnimationTick());
    }

    @Test
    public void testAnimationIndex() {
        int index = 8;
        player.setAnimationIndex(index);
        assertEquals(index, player.getAnimationIndex());
    }

    @Test
    public void testAnimationSpeed() {
        int speed = 2;
        player.setAnimationSpeed(speed);
        assertEquals(speed, player.getAnimationSpeed());
    }

    @Test
    public void testPlayerAction() {
        int action = Constants.PlayerConstants.JUMP;
        player.setPlayerAction(action);
        assertEquals(action, player.getPlayerAction());
    }

    @Test
    public void testMoving() {
        player.setMoving(true);
        assertTrue(player.isMoving());
    }

    @Test
    public void testWin() {
        player.setWin(true);
        assertTrue(player.isWin());
    }

    @Test
    public void testPlayerSpeed() {
        float speed = 2.0f;
        player.setPlayerSpeed(speed);
        assertEquals(speed, player.getPlayerSpeed(),0.01);
    }

    @Test
    public void testLvlData() {
        int[][] tab = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        player.setLvlData(tab);
        assertArrayEquals(tab, player.getLvlData());
    }

    @Test
    public void testxDrawOffset() {
        float x = 5.0f;
        player.setxDrawOffset(x);
        assertEquals(x, player.getxDrawOffset(), 0.01);
    }

    @Test
    public void testyDrawOffset() {
        float y = 7.0f;
        player.setyDrawOffset(y);
        assertEquals(y, player.getyDrawOffset(), 0.01);
    }

    @Test
    public void testTimeToRestart() {
        float y = 7.2f;
        player.setTimeToRestart(y);
        assertEquals(y, player.getTimeToRestart(), 0.01);
    }

    @Test
    public void testDeadPlayer() {
        int i = DYING;
        player.setDeadPlayer(i);
        assertEquals(i, player.getDeadPlayer());
    }

    @Test
    public void testAirSpeed() {
        float y = 7.2f;
        player.setAirSpeed(y);
        assertEquals(y, player.getAirSpeed(), 0.01);
    }

    @Test
    public void testGravity() {
        float y = 7.2f;
        player.setGravity(y);
        assertEquals(y, player.getGravity(), 0.01);
    }

    @Test
    public void testJumpSpeed() {
        float y = 7.2f;
        player.setJumpSpeed(y);
        assertEquals(y, player.getJumpSpeed(), 0.01);
    }

    @Test
    public void testFallSpeedAfterCollision() {
        float y = 7.2f;
        player.setFallSpeedAfterCollision(y);
        assertEquals(y, player.getFallSpeedAfterCollision(), 0.01);
    }

    @Test
    public void testInAir() {
        player.setInAir(true);
        assertTrue(player.isInAir());
    }

}

