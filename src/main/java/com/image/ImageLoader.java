package com.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageLoader {
    private static final Logger log = LoggerFactory.getLogger(ImageLoader.class);

    public static BufferedImage load(String path){
        try {
            File file = new File(path);
            log.info("Image loaded in path: [{}]", path);
            return ImageIO.read(file);
        } catch (Exception e) {
            log.warn("Image not found in path: {}", path);
        }
        return null;
    }

}
