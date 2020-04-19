package com.core;

//import com.core.state.GameGameStateManager;

import com.input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author esteb
 */
public abstract class GameScene extends JPanel implements KeyListener {

    protected Map<String, GameObject> gameObjectMap;

    private BufferedImage image;
    private Graphics2D g;

    private Drawer drawer;
    private Color backgroundColor;

    public GameScene() {
        backgroundColor = Color.GRAY;
        gameObjectMap = new HashMap<>();
        initComponent();
    }

    public void start() {
        image = new BufferedImage(ConfigPropertiesEnum.SCREEN_WITDH.getValueAsInt() * ConfigPropertiesEnum.SCREEN_SCALE.getValueAsInt(), ConfigPropertiesEnum.SCREEN_HEIGHT.getValueAsInt() * ConfigPropertiesEnum.SCREEN_SCALE.getValueAsInt(), 1);
        g = (Graphics2D) image.getGraphics();
        drawer = new Drawer(g);
        new GameLoop() {
            @Override
            protected void update() {
                updateGameObjects();
                updateScene();
            }

            @Override
            protected void draw() {
                setDefaultBackgroundColor();
                drawGameObjects();
                drawScene(g);

            }

            @Override
            protected void drawToScreen() {
                drawSceneToScreen();
            }
        };
    }

    private void setDefaultBackgroundColor() {
        g.setColor(backgroundColor);
        g.fillRect(0,0, ConfigPropertiesEnum.SCREEN_WITDH.getValueAsInt() * ConfigPropertiesEnum.SCREEN_SCALE.getValueAsInt(),
                            ConfigPropertiesEnum.SCREEN_HEIGHT.getValueAsInt() * ConfigPropertiesEnum.SCREEN_SCALE.getValueAsInt());
    }

    public void setBackgroundColor(Color color){
        backgroundColor = color;
    }

    @Override
    public void keyTyped(KeyEvent key) {
    }

    @Override
    public void keyPressed(KeyEvent key) {
        Input.updateKeyState(key, true);
    }

    @Override
    public void keyReleased(KeyEvent key) {
        Input.updateKeyState(key, false);
    }

    public void putGameObject(String key, GameObject gameObject) {
        gameObjectMap.put(key, gameObject);
    }

    protected abstract void updateScene();

    protected abstract void drawScene(Graphics2D g);

    private void initComponent() {
        setPreferredSize(new Dimension((int) ConfigPropertiesEnum.SCREEN_WITDH.getValueAsInt()  * ConfigPropertiesEnum.SCREEN_SCALE.getValueAsInt(),
                                      (int) ConfigPropertiesEnum.SCREEN_HEIGHT.getValueAsInt() * ConfigPropertiesEnum.SCREEN_SCALE.getValueAsInt()));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    // copy buffer to screen
    private void drawSceneToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, ConfigPropertiesEnum.SCREEN_WITDH.getValueAsInt()  * ConfigPropertiesEnum.SCREEN_SCALE.getValueAsInt(),
                                       ConfigPropertiesEnum.SCREEN_HEIGHT.getValueAsInt() * ConfigPropertiesEnum.SCREEN_SCALE.getValueAsInt(), null);
        g2.dispose();
    }

    private void updateGameObjects() {
        for (GameObject go : gameObjectMap.values()) {
            go.update();
        }
    }
    private void drawGameObjects() {
        for (GameObject go : gameObjectMap.values()) {
            drawer.draw(go);
        }
    }

}
