package com.core.action.impl;

import com.core.GameObject;
import com.core.action.Action;
import com.core.util.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeftAction implements Action {

  private static final Logger log = LoggerFactory.getLogger(LeftAction.class);

  @Override
  public void execute(GameObject go) {
//    Position p = go.getPosition();
//    float dx = p.getX() - go.getMoveSpeed();
//    p.setX(dx);
//    go.setPosition(p);
//    log.debug(p.toString());
  }

}
