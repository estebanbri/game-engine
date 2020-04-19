package com.core.action.impl;

import com.core.GameObject;
import com.core.action.Action;
import com.core.util.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DownAction implements Action {

  private static final Logger log = LoggerFactory.getLogger(DownAction.class);

  @Override
  public void execute(GameObject go) {
//      Position p = go.getPosition();
//      //float dy = p.getY() + go.getMoveSpeed();
//      p.setY(dy);
//      go.setPosition(p);
//      log.debug(p.toString());
  }

}
