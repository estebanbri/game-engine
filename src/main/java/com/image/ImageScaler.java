package com.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class ImageScaler {
    private static final Logger log = LoggerFactory.getLogger(ImageScaler.class);

    public static BufferedImage scale(BufferedImage before, double scaleX, double scaleY){
        Objects.requireNonNull(before);
        BufferedImage after = new BufferedImage(before.getWidth(), before.getHeight(), BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(scaleX, scaleY);
        AffineTransformOp scaleOp =
                new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        return scaleOp.filter(before, after);
    }
}
