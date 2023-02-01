package entities;

import java.awt.*;

public interface NewEntityInterface {
    public void update();
    public void updatePosition();
    private void updateAnimationTick(){};
    public void render(Graphics g);
    private void setAnimations(){};
    private void loadAnimations(){};
    public void loadLvlData(int[][] lvlData);

}
