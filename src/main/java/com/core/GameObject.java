package com.core;

import com.animation.AnimationSystem;
import com.core.action.Action;
import com.core.action.impl.GravityAction;
import com.core.util.Position;


import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Objects;

// TODO agregar algun id ya sea numerico o string para identificar y te sea mas facil saber
// que objeto hace referencia cuando lo investigues en modo debug
public class GameObject {


  // Dimensiones
  protected int width;
  protected int height;

  private MovementSystem movementSystem;
  private CollitionSystem collitionSystem;

  private List<GameObject> goColliders;

  protected boolean gravityEnabled;
  protected float gravity;
  public float gravitySpeed;

  private int jumpHeight;

  // Posicion
  protected Position position;
  protected Position positionDest;

  // Movimientos
  protected Action currentAction;

  private BufferedImage bufferedImage;

  // Animation
  protected AnimationSystem animationSystem;
  protected int currentAnimation;

  protected boolean isAlive;
  public boolean isFalling;
  protected boolean isJumping;

  protected Action gravityAction;



  public GameObject() {
    movementSystem = new MovementSystem(this);
    collitionSystem = new CollitionSystem(this);
    animationSystem = new AnimationSystem();
    position = new Position();
    positionDest = new Position();
    gravityAction = new GravityAction();
    isAlive = true;
    isFalling = true;
    gravityEnabled = false;
    gravity = 0.10F;
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
    if (hasGravityEnable() && (isFalling ||  isJumping)) {
      gravityAction.execute(this);
    }

    movementSystem.move();

    collitionSystem.checkCollitions();

    movementSystem.clearMovements();

  }

  public Rectangle getBoundsTop() {
    return new Rectangle(
        (int)position.x,
        (int)position.y,
        (int)(width-(width*0.01f)),
        (int)(height/2)
    );
  }
  public Rectangle getBoundsBottom() {
    return new Rectangle(
        (int)position.x,
        (int)(position.y+(height/2)),
        (int)(width-(width*0.01f)),
        (int)(height/2)
    );
  }

  public Rectangle getBoundsLeft() {
    return new Rectangle(
        (int)position.x,
        (int)position.y,
        (int)((int)width*0.15f),
        (int)height
    );
  }

  public Rectangle getBoundsRight() {
    return new Rectangle(
        (int) ((int)position.x+(width-(width*0.15f))),
        (int)position.y,
        (int) ((int)width*0.15f),
        (int)height
    );
  }

  // Getters & Setters

  public Action getCurrentAction() {
    return currentAction;
  }

  public void setCurrentAction(Action command) {
    this.currentAction = command;
  }

  public void cleanCurrentAction() {
    this.currentAction = null;
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

  public void setBufferedImage(BufferedImage bufferedImage) {
    Objects.requireNonNull(bufferedImage);
    this.bufferedImage = bufferedImage;
    width = bufferedImage.getWidth();
    height = bufferedImage.getHeight();
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public boolean hasGravityEnable() {
    return gravityEnabled;
  }

  public void enableGravity() {
    gravityEnabled = true;
  }

  public float getGravity() {
    return gravity;
  }

  public void setGravity(float gravity) {
    this.gravity = gravity;
  }

  public Rectangle getRectangle() {
    return new Rectangle((int) getPositionDest().getX(), (int) getPositionDest().getY(), width, height);
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

  public void setMovementSystem(MovementSystem movementSystem) {
    this.movementSystem = movementSystem;
  }

  public List<GameObject> getGoColliders() {
    return goColliders;
  }

  public void setGoColliders(List<GameObject> goColliders) {
    this.goColliders = goColliders;
  }

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
}
