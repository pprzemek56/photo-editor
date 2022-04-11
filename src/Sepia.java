import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sepia {

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

                int red = (int) Math.round((0.393 * r + 0.769 * g + 0.189 * b));
                int sepiaRed = Math.min(red, 255);

                int green = (int) Math.round((0.349 * r + 0.686 * g + 0.168 * b));
                int sepiaGreen = Math.min(green, 255);

                int blue = (int) Math.round((0.272 * r + 0.534 * g + 0.131 * b));
                int sepiaBlue = Math.min(blue, 255);
                
                Color color = new Color(sepiaRed, sepiaGreen, sepiaBlue);

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
