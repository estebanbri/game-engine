package com.core;

import java.awt.*;

public class Drawer {

    private Graphics2D g;

    public Drawer(Graphics2D g){
        this.g = g;
    }

    public void draw(GameObject go) {
        // TODO vas a tener que hacer un go.getAnimation para que traiga la ref a animation dentro de gameobjct
//        g.drawImage(
//                go.getAnimation().getCurrentImage(),      // pinta la imagen actual del set de imaginacion
//                go.getCurrentPosition().getX(),
//                go.getCurrentPosition().getY(),
//               null
//        );
        if(ConfigPropertiesEnum.DEBUG_MODE.getValueAsBoolean()){
            drawGOLimit(go);
            drawGOTopCollitionBox(go);
            drawGOBottomCollitionBox(go);
            drawGORightCollitionBox(go);
            drawGOLeftCollitionBox(go);
            drawFPS();
        }
        g.drawImage(go.getBufferedImage(), (int)go.getPosition().getX(), (int)go.getPosition().getY(), null);

    }

    private void drawGOLimit(GameObject go) {
        g.setColor(Color.RED);
        g.drawRect((int)go.getPosition().getX(), (int)go.getPosition().getY(),go.getBufferedImage().getWidth(),go.getBufferedImage().getHeight());
    }

    private void drawGOTopCollitionBox(GameObject go) {
        g.setColor(Color.BLUE);
        g.drawRect((int)go.getBoundsTop().x, (int)go.getBoundsTop().y,(int)go.getBoundsTop().getWidth(),(int)go.getBoundsTop().getHeight());
    }

    private void drawGOBottomCollitionBox(GameObject go) {
        g.setColor(Color.GREEN);
        g.drawRect((int)go.getBoundsBottom().x, (int)go.getBoundsBottom().y,(int)go.getBoundsBottom().getWidth(),(int)go.getBoundsBottom().getHeight());
    }

    private void drawGORightCollitionBox(GameObject go) {
        g.setColor(Color.CYAN);
        g.drawRect((int)go.getBoundsRight().x, (int)go.getBoundsRight().y,(int)go.getBoundsRight().getWidth(),(int)go.getBoundsRight().getHeight());
    }

    private void drawGOLeftCollitionBox(GameObject go) {
        g.setColor(Color.MAGENTA);
        g.drawRect((int)go.getBoundsLeft().x, (int)go.getBoundsLeft().y,(int)go.getBoundsLeft().getWidth(),(int)go.getBoundsLeft().getHeight());
    }

    private void drawFPS() {
        g.setColor(Color.RED);
        g.drawString("FPS: " + GameLoop.FPS, 10,10);
    }

}
