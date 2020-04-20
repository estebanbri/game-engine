package com.core;

import java.util.List;

public class RigidBody {

  private boolean gravityEnabled;
  private float gravity;
  public float gravitySpeed;
  private List<GameObject> colliders;

  public RigidBody(){
    gravity = 0.10F;
  }

  public boolean isGravityEnabled() {
    return gravityEnabled;
  }

  public void enableGravity() {
    this.gravityEnabled = true;
  }

  public void disableGravity() {
    this.gravityEnabled = true;
  }

  public float getGravity() {
    return gravity;
  }

  public void enableGravity(float gravity) {
    this.gravity = gravity;
  }

  public float getGravitySpeed() {
    return gravitySpeed;
  }

  public void setGravitySpeed(float gravitySpeed) {
    this.gravitySpeed = gravitySpeed;
  }

  public List<GameObject> getColliders() {
    return colliders;
  }

  public void setColliders(List<GameObject> colliders) {
    this.colliders = colliders;
  }

}
