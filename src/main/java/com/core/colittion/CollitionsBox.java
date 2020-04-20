package com.core.colittion;

import com.core.GameObject;
import java.awt.Rectangle;

public class CollitionsBox {

  public static Rectangle getCollitionBox(GameObject go) {
    return new Rectangle(
        (int) go.getPosition().x,
        (int) go.getPosition().y,
        go.getWidth(),
        go.getHeight());
  }

  public static Rectangle getTopCollitionBox(GameObject go) {
    return new Rectangle(
        (int) go.getPosition().x,
        (int) go.getPosition().y,
        (int) (go.getWidth() - (go.getWidth() * 0.01F)),
        (int) (go.getHeight() / 2)
    );
  }

  public static Rectangle getBottomCollitionBox(GameObject go) {
    return new Rectangle(
        (int) go.getPosition().x,
        (int) (go.getPosition().y + (go.getHeight() / 2)),
        (int) (go.getWidth() - (go.getWidth() * 0.01f)),
        (int) (go.getHeight() / 2)
    );
  }

  public static Rectangle getLeftCollitionBox(GameObject go) {
    return new Rectangle(
        (int) go.getPosition().x,
        (int) go.getPosition().y,
        (int) ((int) go.getWidth() * 0.15f),
        (int) go.getHeight()
    );
  }

  public static Rectangle getRightCollitionBox(GameObject go) {
    return new Rectangle(
        (int) ((int) go.getPosition().x + (go.getWidth() - (go.getWidth() * 0.15f))),
        (int) go.getPosition().y,
        (int) ((int) go.getWidth() * 0.15f),
        (int) go.getHeight()
    );
  }

}
