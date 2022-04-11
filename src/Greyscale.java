import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Greyscale {

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
            for (int j = 0; j < image.getWidth(); j++) {
                int p = image.getRGB(j,i);
                int r = (p >> 16) & 0xff;
                int g = (p >> 7) & 0xff;
                int b = p & 0xff;

                int average = (r + g + b) / 3;
                Color color = new Color(average, average, average);

                image.setRGB(j, i, color.getRGB());
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
