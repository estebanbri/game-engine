package com.core;


public enum ConfigPropertiesEnum {
    DEBUG_MODE(GamePropertiesLoader.getProperty("debug", "false")),
    SCREEN_TITLE(GamePropertiesLoader.getProperty("screen.title", "My Game")),
    SCREEN_HEIGHT(GamePropertiesLoader.getProperty("screen.height", "200")),
    SCREEN_WITDH(GamePropertiesLoader.getProperty("screen.width", "200")),
    SCREEN_SCALE(GamePropertiesLoader.getProperty("screen.scale", "5")),
    GAMELOOP_FPS(GamePropertiesLoader.getProperty("gameloop.fps", "60"))
    ;

    private String value;

    ConfigPropertiesEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getValueAsInt(){
        return Integer.parseInt(value);
    }

    public boolean getValueAsBoolean() { return Boolean.parseBoolean(value);
    }
}
