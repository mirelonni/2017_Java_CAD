package drawing;

import java.awt.Color;

/*
 * This class has the sole purpose to convert a String into a Color
 */
public final class MakeRGB {
  private MakeRGB() {
  }

  private static final int HEX = 16;
  private static final int R_END = 2;
  private static final int G_END = 4;
  private static final int B_END = 6;

  public static Color makeRGB(final String color, final int a) {
    String justColor = color.substring(1);
    String rr = justColor.substring(0, R_END);
    String gg = justColor.substring(R_END, G_END);
    String bb = justColor.substring(G_END, B_END);
    int r = Integer.parseInt(rr, HEX);
    int g = Integer.parseInt(gg, HEX);
    int b = Integer.parseInt(bb, HEX);
    return new Color(r, g, b, a);
  }
}
