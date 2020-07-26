package com.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageLoader {
    private static final Logger log = LoggerFactory.getLogger(ImageLoader.class);

    public static BufferedImage load(String path) throws IOException {
        final URL url = ImageLoader.class.getClassLoader().getResource(path);
        if(url == null) throw new IOException("URL not found: " + path);
        log.info("Image found in path: [{}]", path);
        return ImageIO.read(url);
    }

}
