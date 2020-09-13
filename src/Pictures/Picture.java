package Pictures;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Picture {
    private String pictureName;
    private int width;
    private int height;
    private int maxColorValue;
    private PixelList picturePixelList;


    public void setPictureSize(String path) throws IOException {
        String height = Files.readAllLines(Paths.get(path)).get(2);
        String[] parts = height.split(" ");
        this.width = Integer.parseInt(parts[0]);
        this.height = Integer.parseInt(parts[1]);
    }

    public void setMaxNumberForColor(String path) throws IOException {
        String number = Files.readAllLines(Paths.get(path)).get(3);
        this.maxColorValue = Integer.parseInt(number);
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMaxColorValue() {
        return maxColorValue;
    }

    public void setMaxColorValue(int maxColorValue) {
        this.maxColorValue = maxColorValue;
    }

    public PixelList getPicturePixelList() {
        return picturePixelList;
    }

    // Ici le create ?
    public void setPicturePixelList(PixelList picturePixelList) {
        this.picturePixelList = picturePixelList;
    }
}
