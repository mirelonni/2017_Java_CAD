import java.awt.Color;
import java.io.File;
import java.io.IOException;
import drawing.Canvas;
import drawing.MakeRGB;
import fileio.implementations.FileReader;
import form.FillVisitor;
import form.Form;
import form.FormFactory;
import form.FormVisitor;
import javax.imageio.ImageIO;

public final class Main {
  private Main() {
  }

  public static void main(final String[] args) throws IOException {
    FileReader input = new FileReader(args[0]);
    int numberOfForms = input.nextInt();
    input.nextWord();
    /*
     * Canvas creation.
     */
    int height = input.nextInt();
    int width = input.nextInt();
    Canvas img = Canvas.getCanvas(width, height);
    String rgb = input.nextWord();
    int a = input.nextInt();
    Color col = MakeRGB.makeRGB(rgb, a);
    img.fillBG(col);
    /*
     * Individual form drawing.
     */
    FormFactory factory = FormFactory.getFactory();
    FormVisitor formVis = new FormVisitor();
    FillVisitor fillVis = new FillVisitor();
    for (int i = 0; i < numberOfForms - 1; i++) {
      String nextForm = input.nextWord();
      Form form = factory.makeForm(nextForm, input);
      form.draw(formVis, img);
      form.draw(fillVis, img);
    }
    ImageIO.write(img, "PNG", new File("./drawing.png"));
  }
}
