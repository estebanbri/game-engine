package com.animation;

import com.core.GameObject;

import java.util.List;

public class AnimationManager {

    public static void update(List<GameObject> gameObjectList){
        for(GameObject go: gameObjectList){
            if(!go.isAlive()) {continue;}
            go.update();
        }
    }

}
