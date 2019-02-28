package drawing;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public final class Canvas extends BufferedImage {
  private static Canvas singleCanvas = null;

  private Canvas(final int width, final int height, final int imageType) {
    super(width, height, imageType);
  }

  public static Canvas getCanvas(final int width, final int height) {
    if (singleCanvas == null) {
      singleCanvas = new Canvas(width, height, BufferedImage.TYPE_INT_ARGB);
    }
    return singleCanvas;
  }

  public void fillBG(final Color color) {
    int[] colorArray = new int[singleCanvas.getWidth()];
    for (int i = 0; i < singleCanvas.getWidth(); i++) {
      colorArray[i] = color.getRGB();
    }
    singleCanvas.setRGB(0, 0, singleCanvas.getWidth(), singleCanvas.getHeight(), colorArray, 0, 0);
  }

  /*
   * Line drawing algorithm.
   */
  public void drawLine(final int startX, final int startY, final int endX, final int endY,
      final Color color) {
    int x = startX;
    int y = startY;
    int deltaX = Math.abs(endX - startX);
    int deltaY = Math.abs(endY - startY);
    int sX;
    int sY;
    if (startX < endX) {
      sX = 1;
    } else if (startX > endX) {
      sX = -1;
    } else {
      sX = 0;
    }
    if (startY < endY) {
      sY = 1;
    } else if (startY > endY) {
      sY = -1;
    } else {
      sY = 0;
    }
    // interchange delta_x and delta_y, depending on the slope of the line
    boolean interchanged;
    if (deltaY > deltaX) {
      int tmp = deltaY;
      deltaY = deltaX;
      deltaX = tmp;
      interchanged = true;
    } else {
      interchanged = false;
    }

    // initialize the error term to compensate for a nonzero intercept
    int error = 2 * deltaY - deltaX;

    for (int i = 0; i <= deltaX; i++) {
      if (x >= 0 && y >= 0 && x < this.getWidth() && y < this.getHeight()) {
        this.setRGB(x, y, color.getRGB());
      }

      while (error > 0) {
        if (interchanged) {
          x = x + sX;
        } else {
          y = y + sY;
        }
        error = error - 2 * deltaX;
      }

      if (interchanged) {
        y = y + sY;
      } else {
        x = x + sX;
      }
      error = error + 2 * deltaY;
    }
  }

  private static final int CIRCLE_THREE = 3;
  private static final int CIRCLE_FOUR = 4;
  private static final int CIRCLE_SIX = 6;
  private static final int CIRCLE_TEN = 10;

  /*
   * Circle drawing algorithm.
   */
  public void drawCircle(final int centerX, final int centerY, final int radius,
      final Color color) {
    int x = 0;
    int y = radius;
    int d = CIRCLE_THREE - 2 * radius;
    while (y >= x) {
      this.plotCircle(centerX, centerY, x, y, color.getRGB());
      x++;

      if (d > 0) {
        y--;
        d = d + CIRCLE_FOUR * (x - y) + CIRCLE_TEN;
      } else {
        d = d + CIRCLE_FOUR * x + CIRCLE_SIX;
      }
      this.plotCircle(centerX, centerY, x, y, color.getRGB());
    }
  }

  /*
   * Actual drawing of the circle points.
   */
  private void plotCircle(final int centerX, final int centerY, final int x, final int y,
      final int rgb) {
    this.checkPlotCircle(centerX + x, centerY + y, rgb);
    this.checkPlotCircle(centerX - x, centerY + y, rgb);
    this.checkPlotCircle(centerX + x, centerY - y, rgb);
    this.checkPlotCircle(centerX - x, centerY - y, rgb);
    this.checkPlotCircle(centerX + y, centerY + x, rgb);
    this.checkPlotCircle(centerX - y, centerY + x, rgb);
    this.checkPlotCircle(centerX + y, centerY - x, rgb);
    this.checkPlotCircle(centerX - y, centerY - x, rgb);
  }

  /*
   * This function checks if the point from the circle fits in the canvas.
   */
  private void checkPlotCircle(final int x, final int y, final int rgb) {
    if (x >= 0 && y >= 0 && x < this.getWidth() && y < this.getHeight()) {
      this.setRGB(x, y, rgb);
    }
  }

  /*
   * Iterative flood fill algorithm.
   */
  public void floodFill(final int x, final int y, final Color rgb, final Color border) {
    Queue<Point> queue = new LinkedList<Point>();
    queue.add(new Point(x, y));
    while (!queue.isEmpty()) {
      Point p = queue.remove();
      int x1 = p.x;
      int y1 = p.y;
      if (checkPixel(x1 + 1, y1, border.getRGB(), rgb.getRGB())) {
        queue.add(new Point(x1 + 1, y1));
      }
      if (checkPixel(x1 - 1, y1, border.getRGB(), rgb.getRGB())) {
        queue.add(new Point(x1 - 1, y1));
      }
      if (checkPixel(x1, y1 + 1, border.getRGB(), rgb.getRGB())) {
        queue.add(new Point(x1, y1 + 1));
      }
      if (checkPixel(x1, y1 - 1, border.getRGB(), rgb.getRGB())) {
        queue.add(new Point(x1, y1 - 1));
      }
    }
  }

  /*
   * This function actually checks the pixel from the iterative flood fill algorithm and colors said
   * pixel and enables it to be added to the queue used in the flood fill
   */
  private boolean checkPixel(final int x, final int y, final int border, final int rgb) {
    if (x < 0 || y < 0 || x >= this.getWidth() || y >= this.getHeight()
        || this.getRGB(x, y) == border || this.getRGB(x, y) == rgb) {
      return false;
    }
    this.setRGB(x, y, rgb);
    return true;

  }
}
