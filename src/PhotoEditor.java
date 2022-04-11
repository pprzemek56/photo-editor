import java.util.ArrayList;
import java.util.List;

public class PhotoEditor {

    private static final ArrayList<Character> editors = new ArrayList<>(List.of('g','s','r','b','e'));

    public static void main(String[] args) {

        if(args.length != 3){
            System.out.println("Use following pattern to compile program");
            System.out.println("java PhotoEditor photo_name.png new_photo_name.png -e {for example e for edges edit}");
            return;
        }

        String pathName = args[0];
        String newPathName = args[1];
        char edit = args[2].charAt(1);

        if(!editors.contains(edit)){
            System.out.println("You have to use some of the following characters");
            System.out.println(editors);
            System.out.println("Don't forget about '-' before the character of editor");
        }

        switch(edit){
            case 'g' -> {
                if(Greyscale.editPhoto(pathName, newPathName)){
                    System.out.println("Your edited photo is in img/ directory");
                }
                else{
                    System.out.println("Something went wrong");
                    System.out.println("Try again");
                }
            }
            case 's' -> {
                if(Sepia.editPhoto(pathName, newPathName)){
                    System.out.println("Your edited photo is in img/ directory");
                }
                else{
                    System.out.println("Something went wrong");
                    System.out.println("Try again");
                }
            }
            case 'r' -> {
                if(Reflection.editPhoto(pathName, newPathName)){
                    System.out.println("Your edited photo is in img/ directory");
                }
                else{
                    System.out.println("Something went wrong");
                    System.out.println("Try again");
                }
            }
            case 'b' -> {
                if(Blur.editPhoto(pathName, newPathName)){
                    System.out.println("Your edited photo is in img/ directory");
                }
                else{
                    System.out.println("Something went wrong");
                    System.out.println("Try again");
                }
            }
            case 'e' -> {
                if(Edges.editPhoto(pathName, newPathName)){
                    System.out.println("Your edited photo is in img/ directory");
                }
                else{
                    System.out.println("Something went wrong");
                    System.out.println("Try again");
                }
            }


        }
    }
}
