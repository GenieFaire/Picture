package Pictures;

public class PixelSegment {

    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private int consecutivePixelCount;
    private PixelSegment nextPixelSegment;

    public PixelSegment(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.consecutivePixelCount = 1;
        this.nextPixelSegment = null;
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

    public int getConsecutivePixelCount() {
        return consecutivePixelCount;
    }

    public void setConsecutivePixelCount(int consecutivePixelCount) {
        this.consecutivePixelCount = consecutivePixelCount;
    }

    public PixelSegment getNextPixelSegment() {
        return nextPixelSegment;
    }

    public void setNextPixelSegment(PixelSegment nextPixelSegment) {

        this.nextPixelSegment = nextPixelSegment;
    }

    public void incConsecutivePixelCount() {
        this.consecutivePixelCount++;
    }

    public boolean is(int red, int green, int blue) {
        return this.red == red && this.green == green && this.blue == blue;
    }
}
