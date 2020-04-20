package com.core.action.impl;

import com.core.GameObject;
import com.core.action.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GravityAction implements Action {
    private static final Logger log = LoggerFactory.getLogger(GravityAction.class);

    @Override
    public void execute(GameObject go) {
        go.getRigidBody().gravitySpeed += go.getRigidBody().getGravity();
        go.getPosition().y += go.getRigidBody().gravitySpeed;
    }
}
