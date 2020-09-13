package Pictures;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String fileName;
        char c = 0;
        StringBuilder pixelsList = new StringBuilder();

        System.out.print("Choisir le nom du fichier (ne pas mettre l'extension) : ");
        fileName = "img/" + scanner.nextLine() + ".ppm";

        try {

            FileReader file = new FileReader(fileName);
            BufferedReader br = new BufferedReader(file);
            int index = 0;
            int red, green, blue, red2, green2, blue2;
            boolean samePixel = false;
            int nombreIdentique = 1;
            PixelList list = new PixelList();


            // On saute les premières lignes
            while (index < 4) {
                br.readLine();
                index++;
            }

            while (true) {
                red = getPixelPoint(br);
                green = getPixelPoint(br);
                blue = getPixelPoint(br);

                if (red == -1 || green == -1 || blue == -1) {
                    break;
                }

                PixelSegment lastSegment = list.getLastPixelSegment();
                if (lastSegment != null
                        && lastSegment.is(red, green, blue)) {
                    lastSegment.incConsecutivePixelCount();
                } else {
                    PixelSegment nextPixelSegment = list.createPixelSegment(red, green, blue);
                    if (lastSegment != null) lastSegment.setNextPixelSegment(nextPixelSegment);
                }
            }

            System.out.print(list.getFirst());

        } catch (FileNotFoundException ex) {
            System.out.println("LE fichier n'existe pas");
        } catch (IOException exc) {
            System.out.println("Erreur d'entrée sortie");
        }
    }

    public static void pictureSize(String path) throws IOException {
        String height = Files.readAllLines(Paths.get(path)).get(2);
        String[] parts = height.split(" ");
        System.out.println("La largeur de l'image est : " + parts[0]);
        System.out.println("La hauteur de l'image est : " + parts[1]);
    }

    public static void maxNumberForColor(String path) throws IOException {
        String number = Files.readAllLines(Paths.get(path)).get(3);
        System.out.println("Le nombre maximal utilisable pour représenter les couleurs est : " + number);
    }

    /**
     * Returns -1 if no more character to read
     * @param br
     * @return
     * @throws IOException
     */
    public static int getPixelPoint(BufferedReader br) throws IOException {


        String strColor = null;

        while (true) {

            int currentChar = br.read();
            if (currentChar == -1) {
                break;
            }

            if (Character.isWhitespace(currentChar)) {
                if (strColor != null) {
                    break;
                }
                continue;
            }

            if (strColor == null) {
                strColor = "" + (char)currentChar;
            } else {
                strColor = strColor + (char)currentChar;
            }

        }
        return strColor != null ? Integer.parseInt(strColor) : -1;
    }
}
