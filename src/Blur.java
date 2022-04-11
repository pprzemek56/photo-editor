import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Blur {

    public static boolean editPhoto(String pathName, String newPathName){

        BufferedImage originalImage, copiedImage;
        try{
            File f = new File("img/" + pathName);
            originalImage = ImageIO.read(f);
            copiedImage = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(pathName + ".png dose not exist!");
            System.out.println("Remember to put your photo in directory img/");
            return false;
        }

        for(int i = 0; i < originalImage.getHeight(); i++){
            for (int j = 0; j < originalImage.getWidth(); j++) {
                int counter = 0;
                int r = 0;
                int g = 0;
                int b = 0;
                for (int k = i - 1; k < i + 2; k++) {
                    for (int l = j - 1; l < j + 2; l++) {
                        if(k < 0 || k > originalImage.getHeight() - 1)break;
                        if(l < 0 || l > originalImage.getWidth() - 1)continue;
                        counter++;
                        int p = originalImage.getRGB(l, k);

                        r += (p >> 16) & 0xff;
                        g += (p >> 8) & 0xff;
                        b += p & 0xff;

                    }
                }

                r /= counter;
                g /= counter;
                b /= counter;

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
