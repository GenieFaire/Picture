package Pictures;

public class PixelSegment {

    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private int pixelNumber;
    private PixelSegment nextPixel;

    public PixelSegment(int red, int green, int blue, int pixelNumber, PixelSegment nextPixel) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.pixelNumber = pixelNumber;
        this.nextPixel = nextPixel;
    }

    public PixelSegment(int red, int green, int blue, int pixelNumber) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.pixelNumber = pixelNumber;
        this.nextPixel = null;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getPixelNumber() {
        return pixelNumber;
    }

    public void setPixelNumber(int pixelNumber) {
        this.pixelNumber = pixelNumber;
    }

    public PixelSegment getNextPixel() {
        return nextPixel;
    }

    public void setNextPixel(PixelSegment nextPixel) {
        this.nextPixel = nextPixel;
    }
}
