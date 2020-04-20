package com.core.colittion;

import static com.core.colittion.CollisionBox.getBottomCollisionBox;
import static com.core.colittion.CollisionBox.getLeftCollisionBox;
import static com.core.colittion.CollisionBox.getRightCollisionBox;
import static com.core.colittion.CollisionBox.getTopCollisionBox;

import com.core.GameObject;

public class CollisionSystem {

  private GameObject go;


  public CollisionSystem(GameObject go) {
    this.go = go;

  }

  public void checkCollitions() {
    if (go.getRigidBody() == null || go.getRigidBody().getColliders().isEmpty()) {
      return;
    }
    for (GameObject collider : go.getRigidBody().getColliders()) {
      if (getRightCollisionBox(go).intersects(getLeftCollisionBox(collider))) {
        go.getPosition().x = collider.getPosition().x - go.getWidth();
      }
      if (getLeftCollisionBox(go).intersects(getRightCollisionBox(collider))) {
        go.getPosition().x = collider.getPosition().x + collider.getWidth() + 0.001F;
      }
      if (getTopCollisionBox(go).intersects(getBottomCollisionBox(collider))) {
        go.getPosition().y = collider.getPosition().y + collider.getHeight();
      }
      if (getBottomCollisionBox(go).intersects(getTopCollisionBox(collider))) {
        go.getPosition().y = collider.getPosition().y - go.getHeight();
        go.isFalling = false;
        if(go.getRigidBody() != null){
          go.getRigidBody().gravitySpeed = 0;
        }
      }else{
        go.isFalling = true;
      }
    }
  }

}
