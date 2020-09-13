package Pictures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PixelList {

    private PixelSegment lastPixelSegment = null; // during the creation, it contains the last created one
    private PixelSegment firstPixelSegment = null;

    public PixelSegment createPixelSegment(int red, int green, int blue) {
        this.lastPixelSegment = new PixelSegment(red, green, blue);
        if (this.firstPixelSegment == null) { // on the first creation we set the first element of the chain to retrieve it further
            this.firstPixelSegment = this.lastPixelSegment;
        }
        return this.lastPixelSegment;
    }

    public PixelSegment getLastPixelSegment() {
        return this.lastPixelSegment;
    }

    public PixelSegment getFirst() {
        return this.firstPixelSegment;
    }

    public static PixelList createList(BufferedReader br) throws IOException {
        int index = 0;
        int red, green, blue;
        PixelList list = new PixelList();

        while (index < 4) {
            br.readLine();
            index++;
        }

        try {
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
                    if (lastSegment != null) {
                        lastSegment.setNextPixelSegment(nextPixelSegment);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("LE fichier n'existe pas");
        } catch (IOException exc) {
            System.out.println("Erreur d'entrée sortie");
        }

        return list;
    }

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
                strColor = "" + (char) currentChar;
            } else {
                strColor = strColor + (char) currentChar;
            }
        }
        return strColor != null ? Integer.parseInt(strColor) : -1;
    }

//    public String toString() {
//        return "rouge : " + firstPixelSegment.getRed()
//                    + "    vert : " + firstPixelSegment.getGreen()
//                   + "    bleu : " + firstPixelSegment.getBlue()
//                   + "    répétition du pixel : " + firstPixelSegment.getConsecutivePixelCount();
//    }
//
    public void displayList() {

        this.getFirst().displaySegment();

//        System.out.println(this.getFirst().toString());
//        if (lastPixelSegment != null) {
//            lastPixelSegment.displayList();
//        }
    }

//        int pixelSegmentNumber = 0;
//        while(list != null) {
//            System.out.println("rouge : " + list.firstPixelSegment.getRed()
//                    + "    vert : " + list.firstPixelSegment.getGreen()
//                    + "    bleu : " + list.firstPixelSegment.getBlue()
//                    + "    répétition du pixel : " + list.firstPixelSegment.getConsecutivePixelCount());
//        } else {
//            System.out.println("pas de liste");
//        }
//    }

}
