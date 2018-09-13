/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog5;

import java.awt.image.BufferedImage;

/**
 *
 * @author christophermallalieu
 */
public class GImage {
    
    private BufferedImage img;
    
    public GImage (BufferedImage img) { //GImage constructor
        this.img = img;
    }
    
    public void convertToGray() { //method to convert to grayscale
        int height = img.getHeight(); //gets high of picture
        int width = img.getWidth(); //gets width of picture
        
        for (int i = 0; i < height; i++) { //loops to get color value of each pixel
            for (int j = 0; j < width; j++) {
                int color = img.getRGB(j, i); //gets RGB int
                int blue = color & 0xff; //seperates RGB int into individual colors
                int green = (color >> 8) & 0xff;
                int red = (color >> 16) & 0xff;
                int colorAve = (red + blue + green) / 3; 
                int newRgb = (colorAve << 16) | (colorAve << 8) | colorAve; //finds new gray RGB int 
                
                img.setRGB(j, i, newRgb); //sets pixel color to shade of gray
            }
        }
        /*try {
            ImageIO.write(img, "jpg", new File("grayimage.jpg"));
        } catch (IOException ex) {
            System.out.println (ex.getMessage());
        } */
    }
    
    public char[][] convertToChars() { //converts grayscale pixels to askii characters
        
        int height = img.getHeight(); //gets image height
        int width = img.getWidth(); //gets image width
        char[][] charArray = new char[width][height]; //creates array to hold askii pixels
        String grayScale = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "; //askii char grayscale
        
        for (int i = 0; i < height; i++) { //loops for filling array with correst askii char
            for (int j = 0; j < width; j++) {
                int color = img.getRGB(j, i);
                int shade = color >> 16 & 0xff; //gets gray value
                int charPosition = (shade * 69) / 255; //calculates which char to use
                charArray[j][i] = grayScale.charAt(charPosition); //fills array
            }
        }
        return charArray;
    }
}
