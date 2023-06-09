package utilz;

import main.Game;
import java.awt.geom.Rectangle2D;

public class HelpMethods {

    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
        if (!IsSolid(x, y, lvlData))
            if (!IsSolid(x + width, y + height, lvlData))
                if (!IsSolid(x + width, y, lvlData))
                    if (!IsSolid(x, y + height, lvlData))
                        return true;
        return false;
    }

    private static boolean IsSolid(float x, float y, int[][] lvlData) {
        if (x < 0 || x >= Game.GAME_WIDTH)
            return true;
        if (y < 0 || y >= Game.GAME_HEIGHT)
            return true;

        float xIndex = x / Game.TILES_SIZE;
        float yIndex = y / Game.TILES_SIZE;

        int value = lvlData[(int) yIndex][(int) xIndex];

        if (value >= 48 || value < 0 || value != 11)
            return true;
        return false;
    }

    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitBox, float xSpeed){
        int currentTile = (int)(hitBox.x / Game.TILES_SIZE);

        if(xSpeed > 0){
            //prawo
            int tileXPos = currentTile * Game.TILES_SIZE;
            int xOffset = (int) (Game.TILES_SIZE - hitBox.width);
            return tileXPos + xOffset - 1;
        }else {
            //lewo
            return currentTile * Game.TILES_SIZE;
        }
    }

    public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitBox, float airSpeed){
        int currentTile = (int)(hitBox.y / Game.TILES_SIZE);
        if(airSpeed > 0){
            //Upadek - dotknięcie podłogi
            int tileXPos = currentTile * Game.TILES_SIZE;
            int xOffset = (int) (Game.TILES_SIZE - hitBox.width);
            return tileXPos + xOffset - 1;
        }else{
            //Skok
            return currentTile * Game.TILES_SIZE;
        }
    }

    public static boolean IsEntityOnFloor(Rectangle2D.Float hitBox, int[][] lvlData) {
        // Sprawdź pixel poniżej: lewydolny i prawydolny
        if (!IsSolid(hitBox.x, hitBox.y + hitBox.height + 1, lvlData))
            if (!IsSolid(hitBox.x + hitBox.width, hitBox.y + hitBox.height + 1, lvlData))
                return false;

        return true;


    }
}
