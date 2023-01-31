package tests;

import org.junit.Test;
import utilz.HelpMethods;

import java.awt.geom.Rectangle2D;

import static org.junit.Assert.*;
import static utilz.HelpMethods.CanMoveHere;
import static utilz.HelpMethods.IsEntityOnFloor;

public class HelpMethodsTests {
    @Test
    public void CanMoveHereTest_returnTrue() {
        int[][] lvlData = {{11, 1, 0, 11}, {11, 2, 0, 2}, {11, 0, 11, 1}};
        float x = 0, y = 0, width = 2, height = 2;

        boolean result = HelpMethods.CanMoveHere(x, y, width, height, lvlData);

        assertTrue(result);
    }

    @Test
    public void testCanMoveHere_InvalidInput_ReturnsFalse() {
        int[][] lvlData = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        boolean result = CanMoveHere(-1, -1, 1, 1, lvlData);
        assertFalse(result);
    }

    @Test
    public void GetEntityXPosNextToWallTest() {
        Rectangle2D.Float hitBox = new Rectangle2D.Float(80, 80, 40, 40);
        float xSpeed = 10;

        float result = HelpMethods.GetEntityXPosNextToWall(hitBox, xSpeed);
        assertEquals(87, result, 0.1);

        xSpeed = -10;
        result = HelpMethods.GetEntityXPosNextToWall(hitBox, xSpeed);
        assertEquals(64, result, 0.1);
    }


    @Test
    public void GetEntityYPosUnderRoofOrAboveFloorTest() {
        Rectangle2D.Float hitBox = new Rectangle2D.Float(80, 80, 40, 40);
        float airSpeed = 10;

        float result = HelpMethods.GetEntityYPosUnderRoofOrAboveFloor(hitBox, airSpeed);
        assertEquals(87, result, 0.1);

        airSpeed = -10;
        result = HelpMethods.GetEntityYPosUnderRoofOrAboveFloor(hitBox, airSpeed);
        assertEquals(64, result, 0.1);
    }

    @Test
    public void testIsEntityOnFloor_ValidInput_ReturnsTrue() {
        int[][] lvlData = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Rectangle2D.Float hitBox = new Rectangle2D.Float(0, 0, 1, 1);
        boolean result = IsEntityOnFloor(hitBox, lvlData);
        assertTrue(result);
    }

    @Test
    public void testIsEntityOnFloor_InvalidInput_ReturnsFalse() {
        int[][] lvlData = {{11, 11, 11, 11}, {11, 11, 11, 11}, {11, 11, 11, 11}};
        Rectangle2D.Float hitBox = new Rectangle2D.Float(0, 0, 2, 2);

        boolean result = HelpMethods.IsEntityOnFloor(hitBox, lvlData);

        assertFalse(result);
    }
}
