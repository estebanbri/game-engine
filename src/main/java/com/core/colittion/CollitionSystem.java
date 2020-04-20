package com.core.colittion;

import static com.core.colittion.CollitionsBox.getBottomCollitionBox;
import static com.core.colittion.CollitionsBox.getLeftCollitionBox;
import static com.core.colittion.CollitionsBox.getRightCollitionBox;
import static com.core.colittion.CollitionsBox.getTopCollitionBox;

import com.core.GameObject;

public class CollitionSystem {

  private GameObject go;


  public CollitionSystem(GameObject go) {
    this.go = go;

  }

  public void checkCollitions() {
    if (go.getRigidBody() == null || go.getRigidBody().getColliders().isEmpty()) {
      return;
    }
    for (GameObject collider : go.getRigidBody().getColliders()) {
      if (getRightCollitionBox(go).intersects(getLeftCollitionBox(collider))) {
        go.getPosition().x = collider.getPosition().x - go.getWidth();
      }
      if (getLeftCollitionBox(go).intersects(getRightCollitionBox(collider))) {
        go.getPosition().x = collider.getPosition().x + collider.getWidth() + 0.001F;
      }
      if (getTopCollitionBox(go).intersects(getBottomCollitionBox(collider))) {
        go.getPosition().y = collider.getPosition().y + collider.getHeight();
      }
      if (getBottomCollitionBox(go).intersects(getTopCollitionBox(collider))) {
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
