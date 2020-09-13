package Pictures;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String pictureName;
        String picturePath;

        System.out.print("Choisir le nom du fichier (ne pas mettre l'extension) : ");
        pictureName = scanner.nextLine();
        picturePath = "img/" + pictureName + ".ppm";

        try {

            // TODO voir où est mon premier pixel
            FileReader fileReader = new FileReader(picturePath);
            BufferedReader br = new BufferedReader(fileReader);


            PixelList list = new PixelList();
            Picture currentPicture = new Picture();

            currentPicture.setPictureName(pictureName);
            currentPicture.setPictureSize(picturePath);
            currentPicture.setMaxNumberForColor(picturePath);

            list = PixelList.createList(br);

            currentPicture.setPicturePixelList(list);
            currentPicture.getPicturePixelList().displayList();

//            System.out.println(currentPicture.getWidth());
//            System.out.println(currentPicture.getHeight());
//            System.out.println(currentPicture.getMaxColorValue());


//             On saute les premières lignes
//            while (index < 4) {
//                br.readLine();
//                index++;
//            }

//            while (true) {
//                red = getPixelPoint(br);
//                green = getPixelPoint(br);
//                blue = getPixelPoint(br);
//
//                if (red == -1 || green == -1 || blue == -1) {
//                    break;
//                }
//
//                PixelSegment lastSegment = list.getLastPixelSegment();
//                if (lastSegment != null
//                        && lastSegment.is(red, green, blue)) {
//                    lastSegment.incConsecutivePixelCount();
//                } else {
//                    PixelSegment nextPixelSegment = list.createPixelSegment(red, green, blue);
//                    if (lastSegment != null) {
//                        lastSegment.setNextPixelSegment(nextPixelSegment);
//                    }
//                }
//            }


            scanner.close();

        } catch (FileNotFoundException ex) {
            System.out.println("LE fichier n'existe pas");
        } catch (IOException exc) {
            System.out.println("Erreur d'entrée sortie");
        }
    }




}
