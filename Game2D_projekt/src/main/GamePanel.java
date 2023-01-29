package main;

import javax.swing.JPanel;
import java.awt.*;
import static main.Game.GAME_WIDTH;
import static main.Game.GAME_HEIGHT;



public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private Game game;
    public GamePanel(Game game) {
        mouseInputs = new MouseInputs(this);
        this.game = game;
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    public void updateGame() {

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }
    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("Window size: " + GAME_WIDTH +"x"+GAME_HEIGHT);
    }

    public Game getGame(){
        return game;
    }
}