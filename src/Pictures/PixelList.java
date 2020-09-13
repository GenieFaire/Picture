package Pictures;

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

}
