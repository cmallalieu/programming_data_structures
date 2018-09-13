/*
CSE 17
Christopher Mallalieu
cpm220
Image ASKII Art Converter
*/


package prog5;

import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
/**
 *
 * @author christophermallalieu
 */
public class Prog5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("Enter the url/path of the image to be converted: ");
        String arg = args[0];
        
        try {
            if (arg.startsWith("http")) { //case if a url is provided 
                URL url = new URL(arg); //creates url object
                BufferedImage urlImage = ImageIO.read(url); //reads url object
                GImage urlPic = new GImage(urlImage);
                urlPic.convertToGray(); //convers picture to grayscale
                char[][] picArray = urlPic.convertToChars(); //array of askii pixels
                for (int i = 0; i < urlImage.getHeight(); i++) { //loops to print askii art
                    for (int j = 0; j < urlImage.getWidth(); j++) {
                        System.out.print (picArray[j][i]);
                        if (j % urlImage.getWidth() == 0) { //prints new line when the loop reaches the end of a line
                            System.out.println();
                        }
                    }
                }
            } else {
                BufferedImage fileImage = ImageIO.read(new File(arg)); //case if a file path is provided
                GImage filePic = new GImage(fileImage);
                filePic.convertToGray(); //converts picture to grayscale
                char[][] picArray = filePic.convertToChars(); //array of askii pixels
                for (int i = 0; i < fileImage.getHeight(); i++) { //loops to print askii art
                    for (int j = 0; j < fileImage.getWidth(); j++) {
                        System.out.print (picArray[j][i]);
                        if (j % fileImage.getHeight() == 0) { //prints new line when the loop reaches the end of a line
                            System.out.println();
                        }
                    }
                }
            }
        } catch (IOException ex) { //catch IOException
            System.out.println (ex.getMessage());
        }
    }
}
