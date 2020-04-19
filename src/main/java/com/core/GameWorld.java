package com.core;


import com.exception.GameException;

import javax.swing.*;

public class GameWorld extends JFrame {

    private static final String SCENE_NOT_FOUND = "Scene not found, Please add at least one scene to the world";

    // TODO hacer una lista de gamescene?
    private GameScene gameScene;

    public void start(){
        if(gameScene == null){
           throw new GameException(SCENE_NOT_FOUND);
        }
        this.gameScene.start();
    }

    public void addGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
        this.add(gameScene);
        init();
    }

    private void init(){
        this.setTitle(ConfigPropertiesEnum.SCREEN_TITLE.getValue());
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
