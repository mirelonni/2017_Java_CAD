package form;

import java.awt.Color;
import java.io.IOException;
import drawing.Canvas;
import drawing.MakeRGB;
import fileio.implementations.FileReader;

public class Diamond extends Form implements Visitable {
    private int centerX;
    private int centerY;
    private int diagX;
    private int diagY;
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

    public final int getDiagX() {
        return diagX;
    }

    public final void setDiagX(final int diagX) {
        this.diagX = diagX;
    }

    public final int getDiagY() {
        return diagY;
    }

    public final void setDiagY(final int diagY) {
        this.diagY = diagY;
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

    public Diamond(final FileReader input) throws IOException {
        this.setCenterX(input.nextInt());
        this.setCenterY(input.nextInt());
        this.setDiagX(input.nextInt());
        this.setDiagY(input.nextInt());
        this.setBorderColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
        this.setInsideColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
    }

    @Override
    public final void draw(final Visitor visitor, final Canvas img) {
        visitor.visit(this, img);
    }
}
