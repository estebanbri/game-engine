package com.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author esteb
 */
public abstract class GameLoop {
    private static final Logger log = LoggerFactory.getLogger(GameLoop.class);

    private Thread thread;
    public static int FPS;
    private volatile boolean running;
    private static final double UPDATE_CAP = 1.0 / 60.0; // for timming our loop

    GameLoop(){
        FPS = ConfigPropertiesEnum.GAMELOOP_FPS.getValueAsInt();
        start();
    }

    private void start() {
        if(thread != null){
            log.info("Game Engine already running...");
            return;
        }
        thread = new Thread(new Runnable() {
            public void run() {
                gameLoop();
            }
        });
        thread.start();
        log.info("Starting Game Engine...");
    }

    public void stop() {

    }

    private void gameLoop() {
        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0; // how many frames has passed

        running = true;
        while (running) {
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= UPDATE_CAP) {
                unprocessedTime -= UPDATE_CAP;
                render = true;

                if(frameTime >= 1.0){
                    frameTime = 0;
                    FPS = frames;
                    frames = 0;
                }

            }

            if(render){
                update();
                draw();
                drawToScreen();
                frames++;
            }{
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }


    private void dispose(){

    }

    protected abstract void update();

    protected abstract void draw();

    protected abstract void drawToScreen();

}
