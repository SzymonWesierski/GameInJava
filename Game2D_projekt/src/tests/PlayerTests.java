package tests;

import entities.Player;
import main.Game;
import org.junit.Before;
import org.junit.Test;
import levels.LevelManager;
import utilz.Constants;

import static main.Game.*;
import static org.junit.Assert.*;
import static utilz.Constants.PlayerConstants.DYING;
import static utilz.Constants.PlayerConstants.IDLE;

public class PlayerTests {
    private Game game;
    private LevelManager levelManager;
    private Player player;

    @Before
    public void setUp() {
        game = new Game();
        levelManager = new LevelManager(new Game());
        player = new Player(playerStartX,playerStartY,(int)(80 * SCALE),(int)(80 * SCALE));
    }

    @Test
    public void jumpTest() {
        player.getHitBox().x = playerStartX;
        player.getHitBox().y = playerStartY;

        player.setJump(true);
        player.loadLvlData(levelManager.getCurrentLevel().getLvlData());
        player.updatePosition();
        assertTrue(player.isInAir());
        assertEquals(-2.25 * Game.SCALE, player.getAirSpeed(), 0.1);
    }

    @Test
    public void testRespawn() {
        player.getHitBox().x = playerStartX;
        player.getHitBox().y = playerStartY;

        player.setTimeToRespown(player.getTimeToRestart() + 1);
        player.update();
        assertEquals(player.getHitBox().x, playerStartX, 0.001);
        assertEquals(player.getHitBox().y, playerStartY, 0.001);
        assertEquals(player.getPlayerAction(), IDLE);
        assertEquals(player.getTimeToRespown(), 0, 0.001);
    }

    @Test
    public void updatePositionTest() {
        player.getHitBox().x = playerStartX;
        player.getHitBox().y = playerStartY;

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
        player.getHitBox().x = playerStartX;
        player.getHitBox().y = playerStartY;

        player.getHitBox().y = Game.GAME_HEIGHT - 65;
        player.update();
        assertEquals(player.getPlayerAction(), DYING);
    }

    @Test
    public void isDeadOrWinTest() {
        player.getHitBox().x = playerStartX;
        player.getHitBox().y = playerStartY;

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
        player.getHitBox().x = playerStartX;
        player.getHitBox().y = playerStartY;

        player.jump();
        player.resetInAir();
        assertEquals(false, player.isInAir());
    }

    @Test
    public void testToString() {
        player.getHitBox().x = playerStartX;
        player.getHitBox().y = playerStartY;
        String expected = "Player, current action:0/0, coordination:100.0, 575.0";
        assertEquals(expected, player.toString());
    }

    public void testResetDirBooleans() {
        player.setUp(true);
        player.setDown(true);
        player.setLeft(true);
        player.setRight(true);

        player.resetDirBooleans();

        assertFalse(!player.isUp());
        assertFalse(player.isDown());
        assertFalse(player.isLeft());
        assertFalse(player.isRight());
    }


}

