package com.animation;

import com.core.GameObject;

import java.awt.image.BufferedImage;

public class AnimationSystem {
    // stuff images anim
    private BufferedImage[] frames;
    private int currentFrame;

    // stuff to control when change next image animation
    private int ticks;
    private int delay;

    public void setFrames(BufferedImage[] frames) {
        setFrames(frames, 2);
    }

    public void setFrames(BufferedImage[] frames, int delay) {
        this.frames = frames;
        this.currentFrame = 0;
        this.ticks = 0;
        this.delay = delay;
    }

    // TODO agregar parametro GameObject go  asi podes desacoplar y quitar el metodo update() dentro de gameobject
    public void update() { // finalidad: actualizar al siguiente indice de la siguiente imagen a mostrar

        if(delay == -1) return; // check si es -1 es una unica imagen

        ticks++;

        if(ticks == delay) { // si la imagen se mostro en pantalla durante este delay
            currentFrame++;  // siguiente imagen index
            ticks = 0; // resetea count para que pase la misma cantidad de tiempo en cada vuelta
        }
        if(currentFrame == frames.length) {  // si el frame actual es el ultimo frame reseteamos los contadores para que repita la segunda de la animacion
            currentFrame = 0;
        }

    }


    public BufferedImage getCurrentImage() {
        return frames[currentFrame];
    }

    public void setDelay(int i) { delay = i; }

//    public void setFrame(int i) { currentFrame = i; }
//    public int getFrame() { return currentFrame; }
//    public int getTicks() { return ticks; }
//    public boolean hasPlayedOnce() { return timesPlayed > 0; }
//    public boolean hasPlayed(int i) { return timesPlayed == i; }
}
