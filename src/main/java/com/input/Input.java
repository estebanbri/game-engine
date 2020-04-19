package com.input;

// Contains an array of current key state
// previous key state. A value of true
// means the key is pressed.

// The GamePanel KeyListener will update the array.
// All GameStates now have a handleInput() function
// in order to keep all keyboard input operations
// on the game thread rather than on the EDT to avoid
// problems.


import java.awt.event.KeyEvent;

public class Input {

    public static final int CANTIDAD_TECLAS = 8;
    public static boolean keyState[] = new boolean[CANTIDAD_TECLAS]; // cuando quiero saber si una tecla isDown() simplemente consulto este solo
    public static boolean prevKeyState[] = new boolean[CANTIDAD_TECLAS]; // cuando quiero saber si una tecla isPressed() consulto si prevKeyState[i] era false y en KeyState[] es true

    public static int KEY_UP = 0;
    public static int KEY_LEFT = 1;
    public static int KEY_DOWN = 2;
    public static int KEY_RIGHT = 3;
    public static int KEY_SPACE = 4;
    public static int KEY_ENTER = 5;
    public static int KEY_ESCAPE = 6;


    public static void updateKeyState(KeyEvent event, boolean pressed) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_W: {
                keyState[KEY_UP] = pressed;
                break;
            }
            case KeyEvent.VK_A: {
                keyState[KEY_LEFT] = pressed;
                break;
            }
            case KeyEvent.VK_S: {
                keyState[KEY_DOWN] = pressed;
                break;
            }
            case KeyEvent.VK_D: {
                keyState[KEY_RIGHT] = pressed;
                break;
            }
            case KeyEvent.VK_SPACE: {
                keyState[KEY_SPACE] = pressed;
                break;
            }
            case KeyEvent.VK_ENTER: {
                keyState[KEY_ENTER] = pressed;
                break;
            }
            case KeyEvent.VK_ESCAPE: {
                keyState[KEY_ESCAPE] = pressed;
                break;
            }
        }
    }

    // copiar valores del array keyState al prevkeyState
    public static void update() {
        for (int i = 0; i < CANTIDAD_TECLAS; i++) {
            prevKeyState[i] = keyState[i];
        }
    }

    // esta presionada si en el estado actual es true, y en el estado anterior era false
    public static boolean isPressed(int i) {
        return keyState[i] && !prevKeyState[i];
    }

    // esta hundida simplemente si el estado actual es true
    public static boolean isDown(int i) {
        return keyState[i];
    }
}
