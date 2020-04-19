package com.core.action.impl;

import com.core.GameObject;
import com.core.action.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FireAction implements Action {
  private static final Logger log = LoggerFactory.getLogger(FireAction.class);

  @Override
  public void execute(GameObject go) {
    log.debug("Fire");
  }

}
