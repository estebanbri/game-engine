package com.core;

public class MovementSystem {

  private boolean canMove;
  private float moveSpeed;
  private boolean left;
  private boolean right;
  private boolean up;
  private boolean down;

  private GameObject go;

  public MovementSystem(GameObject go) {
    this.go = go;
    moveSpeed = 3;
  }

  public boolean canMove() {
    return canMove;
  }

  public void setCanMove(boolean canMove) {
    this.canMove = canMove;
  }

  public float getMoveSpeed() {
    return moveSpeed;
  }

  public void setMoveSpeed(float moveSpeed) {
    this.moveSpeed = moveSpeed;
  }

  public boolean isLeft() {
    return left;
  }

  public void setLeft() {
    clearMovements();
    this.left = true;
  }

  public boolean isRight() {
    return right;
  }

  public void setRight() {
    clearMovements();
    this.right = true;
  }

  public boolean isUp() {
    return up;
  }

  public void setUp() {
    clearMovements();
    go.isJumping = true;
    this.up = true;
  }

  public boolean isDown() {
    return down;
  }

  public void setDown() {
    clearMovements();
    this.down = true;
  }

  public void move() {
    if (right) {
      go.getPosition().x += moveSpeed;
    }
    if (left) {
      go.getPosition().x -= moveSpeed;
    }
    if (up) {
      go.getPosition().y -= moveSpeed;
    }
    if (down) {
      go.getPosition().y += moveSpeed;
    }
  }

  public boolean isStopped() {
    return go.getPosition().equals(go.getPositionDest());
  }

  public void clearMovements() {
    up = false;
    down = false;
    right = false;
    left = false;
    canMove = false;
  }

}
