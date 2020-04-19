package com.core;

public class CollitionSystem {

  private GameObject go;

  public CollitionSystem(GameObject go) {
    this.go = go;
  }

  public void checkCollitions() {
    if (go.getGoColliders() == null || go.getGoColliders().isEmpty()) {
      return;
    }
    for (GameObject collider : go.getGoColliders()) {
      if (go.getBoundsRight().intersects(collider.getBoundsLeft())) {
        go.getPosition().x = collider.position.x - go.getWidth();
      }
      if (go.getBoundsLeft().intersects(collider.getBoundsRight())) {
        go.getPosition().x = collider.position.x + collider.getWidth() + 0.001F;
      }
      if (go.getBoundsTop().intersects(collider.getBoundsBottom())) {
        go.getPosition().y = collider.position.y + collider.getHeight();
      }
      if (go.getBoundsBottom().intersects(collider.getBoundsTop())) {
        go.getPosition().y = collider.position.y - go.getHeight();
        go.isFalling = false;
        go.gravitySpeed = 0;
      }else{
        go.isFalling = true;
      }
    }
  }

}
