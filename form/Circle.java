package form;

import java.awt.Color;
import java.io.IOException;
import drawing.Canvas;
import drawing.MakeRGB;
import fileio.implementations.FileReader;

public class Circle extends Form {
  private int centerX;
  private int centerY;
  private int radius;
  private Color borderColor;
  private Color insideColor;

  public final int getCenterX() {
    return centerX;
  }

  public final void setCenterX(final int centerX) {
    this.centerX = centerX;
  }

  public final int getCenterY() {
    return centerY;
  }

  public final void setCenterY(final int centerY) {
    this.centerY = centerY;
  }

  public final int getRadius() {
    return radius;
  }

  public final void setRadius(final int radius) {
    this.radius = radius;
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

  public Circle(final FileReader input) throws IOException {
    this.setCenterX(input.nextInt());
    this.setCenterY(input.nextInt());
    this.setRadius(input.nextInt());
    this.setBorderColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
    this.setInsideColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
  }

  @Override
  public final void draw(final Visitor visitor, final Canvas img) {
    visitor.visit(this, img);
  }
}
