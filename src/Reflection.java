import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Reflection {

    public static boolean editPhoto(String pathName, String newPathName){

        BufferedImage image;
        try{
            File f = new File("img/" + pathName);
            image = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(pathName + ".png dose not exist!");
            System.out.println("Remember to put your photo in directory img/");
            return false;
        }

        for(int i = 0; i < image.getHeight(); i++){
            for (int j = 0; j < image.getWidth() / 2; j++) {
                int s = image.getRGB(j,i);
                int e = image.getRGB(image.getWidth() - (j + 1), i);

                image.setRGB(j, i, e);
                image.setRGB(image.getWidth() - (j + 1), i, s);
            }
        }

        try{
            File f = new File("img/" + newPathName);
            ImageIO.write(image, "png", f);
        } catch (IOException e) {
            System.out.println("There is some problem with your second argument");
            System.out.println("Try to fix it with following stack trace");
            e.printStackTrace();
            return false;
        }


        return true;
    }

}
