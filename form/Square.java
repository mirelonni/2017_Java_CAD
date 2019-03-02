package form;

import java.awt.Color;
import java.io.IOException;
import drawing.Canvas;
import drawing.MakeRGB;
import fileio.implementations.FileReader;

public class Square extends Form implements Visitable {
    private int startX;
    private int startY;
    private int side;
    private Color borderColor;
    private Color insideColor;
    private int squareCenterX;
    private int squareCenterY;

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

    public final int getSide() {
        return side;
    }

    public final void setSide(final int side) {
        this.side = side;
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

    public final int getSquareCenterX() {
        return squareCenterX;
    }

    public final void setSquareCenterX(final int squareCenterX) {
        this.squareCenterX = squareCenterX;
    }

    public final int getSquareCenterY() {
        return squareCenterY;
    }

    public final void setSquareCenterY(final int squareCenterY) {
        this.squareCenterY = squareCenterY;
    }

    private static final int SQUARE_SIDES = 4;

    public Square(final FileReader input) throws IOException {
        this.setStartX(input.nextInt());
        this.setStartY(input.nextInt());
        this.setSide(input.nextInt());
        this.setBorderColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
        this.setInsideColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
        this.setSquareCenterY((this.getStartY() * SQUARE_SIDES + this.getSide() * 2) / SQUARE_SIDES);
        this.setSquareCenterX((this.getStartX() * SQUARE_SIDES + this.getSide() * 2) / SQUARE_SIDES);
    }

    @Override
    public final void draw(final Visitor visitor, final Canvas img) {
        visitor.visit(this, img);
    }
}
