package form;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import drawing.Canvas;
import drawing.MakeRGB;
import fileio.implementations.FileReader;

public class Polygon extends Form implements Visitable {
  private int numberOfPoints;
  private ArrayList<Integer> x = new ArrayList<Integer>();
  private ArrayList<Integer> y = new ArrayList<Integer>();
  private Color borderColor;
  private Color insideColor;

  public final int getNumberOfPoints() {
    return numberOfPoints;
  }

  public final void setNumberOfPoints(final int numberOfPoints) {
    this.numberOfPoints = numberOfPoints;
  }

  public final ArrayList<Integer> getX() {
    return x;
  }

  public final void setX(final ArrayList<Integer> x) {
    this.x = x;
  }

  public final ArrayList<Integer> getY() {
    return y;
  }

  public final void setY(final ArrayList<Integer> y) {
    this.y = y;
  }

  public final Color getBorderColor() {
    return borderColor;
  }

  public final void setBorderColor(final Color borderColor) {
    this.borderColor = borderColor;
  }

  public final Color getInsideColor() {
    return insideColor;
  }

  public final void setInsideColor(final Color insideColor) {
    this.insideColor = insideColor;
  }

  public Polygon(final FileReader input) throws IOException {
    this.setNumberOfPoints(input.nextInt());
    for (int i = 0; i < this.getNumberOfPoints(); i++) {
      this.x.add(input.nextInt());
      this.y.add(input.nextInt());
    }
    this.setBorderColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
    this.setInsideColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
  }

  @Override
  public final void draw(final Visitor visitor, final Canvas img) {
    visitor.visit(this, img);
  }
}
