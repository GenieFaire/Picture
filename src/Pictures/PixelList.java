package Pictures;

public class PixelList {

    PixelSegment premier;

    public PixelSegment getPremier() {
        return premier;
    }

  public boolean isEmpty() {
      return premier == null;
  }

  public void ajouterALaFin(int red, int green, int blue, int pixelNumber) {
        if (isEmpty()) {
            premier = new PixelSegment(red, green, blue, pixelNumber);
        } else {
            PixelSegment dernier = getDernierSegment();
        }
  }

  public PixelSegment getDernierSegment() {
        PixelSegment dernier = premier;
        while(dernier.getNextPixel() != null) {
            dernier = dernier.getNextPixel();
      }
        return dernier;
  }

}
à