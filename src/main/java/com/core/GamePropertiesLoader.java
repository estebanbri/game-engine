package com.core;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO reemplazar los metodos para extraer las properties por un enum
// TODO ej: SCREEN_WIDTH(GameProperties::getScreenWidth())
public class GamePropertiesLoader {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(GameLoop.class);

    private static final Properties properties;
    private static final String DEFAULT_PROPERTY_PATH = "application.properties";

    static{
        properties = new Properties();
        try {
            properties.load(GamePropertiesLoader.class.getClassLoader().getResourceAsStream(DEFAULT_PROPERTY_PATH));
            log.info("application.property: {}", properties);
        } catch (IOException e) {
            Logger.getLogger(GamePropertiesLoader.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key,"DEFAULT_VALUE");
    }

    public static String getProperty(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }


}
