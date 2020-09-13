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

            red = pixelPoint(br);
            green = pixelPoint(br);
            blue = pixelPoint(br);

                red2 = pixelPoint(br);
                green2 = pixelPoint(br);
                blue2 = pixelPoint(br);

                if (red == red2 && green == green2 && blue == blue2) {
                    nombreIdentique += 1;
                } else {
                    list.ajouterALaFin(red, green, blue, nombreIdentique);
                    red = red2;
                    green = green2;
                    blue = blue2;
                    list.getDernierSegment();
                }

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

    public static int pixelPoint(BufferedReader br) throws IOException {
        int caractere = br.read();

        int color = 0;

        while (!Character.isWhitespace(caractere) ) {
            if (caractere == -1 || caractere == '\n') {
                break;
            } else {
                color += (char) caractere;
                caractere = br.read();
            }
        }
        return color;
    }
}
