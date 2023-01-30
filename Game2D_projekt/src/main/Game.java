package main;

import entities.Player;
import levels.LevelManager;

import java.awt.*;
import java.io.IOException;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    public final static int playerStartX = 100;
    public final static int playerStartY = 575;
    private Player player;
    private LevelManager levelManager;
    public final static int TILES_DEFAULT_SIZE = 64;
    public final static float SCALE = 1.5F;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = TILES_DEFAULT_SIZE * (int)SCALE;
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    public Game(){
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void initClasses() {
        levelManager = new LevelManager(this);
        player = new Player(playerStartX,playerStartY,(int)(80 * SCALE),(int)(80 * SCALE));
        player.loadLvlData(levelManager.getCurrentLevel().getLvlData());
    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update(){
        player.update();
        playerInfo();
        levelManager.update();
    }

    public void playerInfo(){
        System.out.println(player);
    }

    public void render(Graphics g){
        levelManager.drawBackground(g);
        levelManager.draw(g);
        player.render(g);
    }

    @Override
    public void run(){

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long previousTime = System.nanoTime();
        int frame = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while(true){
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }

            if(deltaF >= 1){
                gamePanel.repaint();
                deltaF--;
                frame++;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS:" + frame + ", UPS:" + updates);
                frame = 0;
                updates = 0;
            }
        }
    }

    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }
}