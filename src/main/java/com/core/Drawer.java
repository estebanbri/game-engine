package com.core;

import static com.core.colittion.CollitionsBox.getBottomCollitionBox;
import static com.core.colittion.CollitionsBox.getCollitionBox;
import static com.core.colittion.CollitionsBox.getLeftCollitionBox;
import static com.core.colittion.CollitionsBox.getRightCollitionBox;
import static com.core.colittion.CollitionsBox.getTopCollitionBox;

import com.core.colittion.CollitionsBox;
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
            drawRect(getCollitionBox(go), Color.RED);
            drawRect(getTopCollitionBox(go), Color.BLUE);
            drawRect(getBottomCollitionBox(go), Color.MAGENTA);
            drawRect(getRightCollitionBox(go), Color.GREEN);
            drawRect(getLeftCollitionBox(go), Color.ORANGE);
            drawFPS();
        }
        g.drawImage(go.getBufferedImage(), (int)go.getPosition().getX(), (int)go.getPosition().getY(), null);

    }

    private void drawFPS() {
        g.setColor(Color.RED);
        g.drawString("FPS: " + GameLoop.FPS, 10,10);
    }

    private void drawRect(Rectangle rectangle, Color color){
        g.setColor(color);
        g.drawRect((int)rectangle.x, (int)rectangle.y,(int)rectangle.getWidth(),(int)rectangle.getHeight());
    }

}
