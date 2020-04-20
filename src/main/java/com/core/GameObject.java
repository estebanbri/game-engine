package com.core;

import com.animation.AnimationSystem;
import com.core.action.Action;
import com.core.action.impl.GravityAction;
import com.core.colittion.CollitionSystem;
import com.core.util.Position;


import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Objects;

// TODO agregar algun id ya sea numerico o string para identificar y te sea mas facil saber
// que objeto hace referencia cuando lo investigues en modo debug
public class GameObject {


  // Dimensiones
  protected int width;
  protected int height;

  private MovementSystem movementSystem;
  private CollitionSystem collitionSystem;


  // Posicion
  protected Position position;
  protected Position positionDest;

  private BufferedImage bufferedImage;

  // Animation
  protected AnimationSystem animationSystem;
  protected int currentAnimation;

  protected boolean isAlive;
  public boolean isFalling;
  protected boolean isJumping;
  private int jumpHeight;

  protected Action gravityAction;
  private RigidBody rb;


  public GameObject() {
    movementSystem = new MovementSystem(this);
    collitionSystem = new CollitionSystem(this);
    animationSystem = new AnimationSystem();
    position = new Position();
    positionDest = new Position();
    gravityAction = new GravityAction();
    isAlive = true;
    isFalling = true;
  }

  public void setInitialPosition(Position pos) {
    final float x = pos.getX();
    final float y = pos.getY();
    position.x = x;
    position.y = y;
    positionDest.x = x;
    positionDest.y = y;
  }

  public void update() { // seleccionar animacion
    // update animation
    // TODO Animation
    //animation.update(); // finalidad: actualizar al siguiente indice de la siguiente imagen a mostrar
    if (rb != null && rb.isGravityEnabled() && (isFalling ||  isJumping)) {
      gravityAction.execute(this);
    }

    movementSystem.move();

    collitionSystem.checkCollitions();

    movementSystem.clearMovements();

  }

  // Getters & Setters

  public void setBufferedImage(BufferedImage bufferedImage) {
    Objects.requireNonNull(bufferedImage);
    this.bufferedImage = bufferedImage;
    width = bufferedImage.getWidth();
    height = bufferedImage.getHeight();
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public int getJumpHeight() {
    return jumpHeight;
  }

  public void setJumpHeight(int jumpHeight) {
    this.jumpHeight = jumpHeight;
  }

  public Position getPositionDest() {
    return positionDest;
  }

  public void setPositionDest(Position positionDest) {
    this.positionDest = positionDest;
  }

  public void setMoveSpeed(int i) {
    movementSystem.setMoveSpeed(i);
  }

  public MovementSystem getMovementSystem() {
    return movementSystem;
  }

  public void setMovementSystem(MovementSystem movementSystem) { this.movementSystem = movementSystem; }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public boolean isFalling() {
    return isFalling;
  }

  public void setFalling(boolean isFalling) {
    isFalling = isFalling;
  }

  public boolean isJumping() {
    return isJumping;
  }

  public void setJumping(boolean jumping) {
    isJumping = jumping;
  }

  public void addRigidBody(RigidBody rb) {
    this.rb = rb;
  }

  public RigidBody getRigidBody() { return rb; }
}
