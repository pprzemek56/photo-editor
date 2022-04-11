import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Edges {

    private static final int[][] GX = {
            {-1,0,1},
            {-2,0,2},
            {-1,0,1}
    };
    private static final int[][] GY = {
            {1,2,1},
            {0,0,0},
            {-1,-2,-1}
    };

    public static boolean editPhoto(String pathName, String newPathName){

        BufferedImage originalImage, copiedImage;
        try{
            File f = new File("img/" + pathName);
            originalImage = ImageIO.read(f);
            copiedImage = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(pathName + " dose not exist!");
            System.out.println("Remember to put your photo in directory img/");
            return false;
        }

        for (int i = 0; i < originalImage.getHeight(); i++) {
            for (int j = 0; j < originalImage.getWidth(); j++) {

                int[][] surroundingPixels = new int[3][3];

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int h = i + (k - 1);
                        int w = j + (l - 1);

                        if(h < 0 || h >= originalImage.getHeight() || w < 0 || w >= originalImage.getWidth()){
                            surroundingPixels[k][l] = 0;
                        }
                        else{
                            surroundingPixels[k][l] = originalImage.getRGB(w, h);
                        }
                    }
                }

                int gxRed = 0;
                int gyRed = 0;
                int gxGreen = 0;
                int gyGreen = 0;
                int gxBlue = 0;
                int gyBlue = 0;

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        gxRed += ((surroundingPixels[k][l] >> 16) & 0xff) * GX[k][l];
                        gyRed += ((surroundingPixels[k][l] >> 16) & 0xff) * GY[k][l];
                        gxGreen += ((surroundingPixels[k][l] >> 8) & 0xff) * GX[k][l];
                        gyGreen += ((surroundingPixels[k][l] >> 8) & 0xff) * GY[k][l];
                        gxBlue += (surroundingPixels[k][l] & 0xff) * GX[k][l];
                        gyBlue += (surroundingPixels[k][l] & 0xff) * GY[k][l];
                    }
                }

                int r = Math.min((int) Math.sqrt(Math.pow(gxRed, 2) + Math.pow(gyRed, 2)), 255);
                int g = Math.min((int) Math.sqrt(Math.pow(gxGreen, 2) + Math.pow(gyGreen, 2)), 255);
                int b = Math.min((int) Math.sqrt(Math.pow(gxBlue, 2) + Math.pow(gyBlue, 2)), 255);

                Color color = new Color(r, g, b);

                copiedImage.setRGB(j, i, color.getRGB());
            }
        }

        try{
            File f = new File("img/" + newPathName);
            ImageIO.write(copiedImage, "png", f);
        } catch (IOException e) {
            System.out.println("There is some problem with your second argument");
            System.out.println("Try to fix it with following stack trace");
            e.printStackTrace();
            return false;
        }


        return true;
    }
}
