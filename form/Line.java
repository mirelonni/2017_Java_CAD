package form;

import java.awt.Color;
import java.io.IOException;
import drawing.Canvas;
import drawing.MakeRGB;
import fileio.implementations.FileReader;

public class Line extends Form implements Visitable {
  private int startX;
  private int startY;
  private int endX;

  public final int getStartX() {
    return startX;
  }

  public final void setStartX(final int startX) {
    this.startX = startX;
  }

  public final int getStartY() {
    return startY;
  }

  public final void setStartY(final int startY) {
    this.startY = startY;
  }

  public final int getEndX() {
    return endX;
  }

  public final void setEndX(final int endX) {
    this.endX = endX;
  }

  public final int getEndY() {
    return endY;
  }

  public final void setEndY(final int endY) {
    this.endY = endY;
  }

  public final Color getColor() {
    return color;
  }

  public final void setColor(final Color color) {
    this.color = color;
  }

  private int endY;
  private Color color;

  public Line(final FileReader input) throws IOException {
    this.startX = input.nextInt();
    this.startY = input.nextInt();
    this.endX = input.nextInt();
    this.endY = input.nextInt();
    this.color = MakeRGB.makeRGB(input.nextWord(), input.nextInt());
  }

  @Override
  public final void draw(final Visitor visitor, final Canvas img) {
    visitor.visit(this, img);
  }
}
