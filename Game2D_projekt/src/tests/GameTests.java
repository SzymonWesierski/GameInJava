package tests;

import entities.Player;
import levels.LevelManager;
import main.Game;
import org.junit.Before;
import org.junit.Test;

import static main.Game.*;
import static main.Game.SCALE;
import static org.junit.Assert.*;

public class GameTests {
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
    public void testPlayerInitialPosition() {
        assertEquals(100, player.getHitBox().x, 0.01);
        assertEquals(575, player.getHitBox().y, 0.01);
    }

    @Test
    public void testGameDimensions() {
        assertEquals(1664, Game.GAME_WIDTH , 0.01);
        assertEquals(896, Game.GAME_HEIGHT, 0.01);
    }

    @Test
    public void testLevelManager() {
        assertNotNull(levelManager);
        assertNotNull(levelManager.getCurrentLevel());
    }
}