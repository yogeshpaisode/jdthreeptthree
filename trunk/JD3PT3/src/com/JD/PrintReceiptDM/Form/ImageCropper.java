/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JD.PrintReceiptDM.Form;

/**
 *
 * @author Yogesh
 */
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ImageCropper {
    static Rectangle clip;
    public ImageCropper() {
        try {
            String inputFileLocation = "TEMP.jpg";
            String outputFileLocation = "TEMP1.jpg";
            BufferedImage originalImage = readImage(inputFileLocation);
            int cropHeight = 75;
            int cropWidth = 50;
            int cropStartX = 10;
            int cropStartY = 32;
            BufferedImage processedImage = cropMyImage(originalImage, cropWidth, cropHeight, cropStartX, cropStartY);
            writeImage(processedImage, outputFileLocation, "jpg");
            //new ImageRotator();
        } catch (Exception ex) {
            Logger.getLogger(ImageCropper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BufferedImage cropMyImage(BufferedImage img, int cropWidth,
        int cropHeight, int cropStartX, int cropStartY) throws Exception {
        BufferedImage clipped = null;
        Dimension size = new Dimension(cropWidth, cropHeight);
        createClip(img, size, cropStartX, cropStartY);
        try {
            int w = clip.width;
            int h = clip.height;
            clipped = img.getSubimage(clip.x, clip.y, w, h);
        } catch (RasterFormatException rfe) {
            return null;
        }
        return clipped;
    }

    private static void createClip(BufferedImage img, Dimension size,
            int clipX, int clipY) throws Exception {
        boolean isClipAreaAdjusted = false;
        if (clipX < 0) {
            clipX = 0;
            isClipAreaAdjusted = true;
        }
        if (clipY < 0) {
            clipY = 0;
            isClipAreaAdjusted = true;
        }
        if ((size.width + clipX) <= img.getWidth()
                && (size.height + clipY) <= img.getHeight()) {
            clip = new Rectangle(size);
            clip.x = clipX;
            clip.y = clipY;
        } else {
            if ((size.width + clipX) > img.getWidth()) {
                size.width = img.getWidth() - clipX;
            }
            if ((size.height + clipY) > img.getHeight()) {
                size.height = img.getHeight() - clipY;
            }
            clip = new Rectangle(size);
            clip.x = clipX;
            clip.y = clipY;
            isClipAreaAdjusted = true;
        }
        if (isClipAreaAdjusted) {
        }
    }

    public static BufferedImage readImage(String fileLocation) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileLocation));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static void writeImage(BufferedImage img, String fileLocation,
            String extension) {
        try {
            BufferedImage bi = img;
            File outputfile = new File(fileLocation);
            ImageIO.write(bi, extension, outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
