package form;

import java.awt.Color;
import java.io.IOException;
import drawing.Canvas;
import drawing.MakeRGB;
import fileio.implementations.FileReader;

public class Rectangle extends Form implements Visitable {
    private int startX;
    private int startY;
    private int height;
    private int width;
    private Color borderColor;
    private Color insideColor;
    private int rectangleCenterX;
    private int rectangleCenterY;

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

    public final int getHeight() {
        return height;
    }

    public final void setHeight(final int height) {
        this.height = height;
    }

    public final int getWidth() {
        return width;
    }

    public final void setWidth(final int width) {
        this.width = width;
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

    public final int getRectangleCenterX() {
        return rectangleCenterX;
    }

    public final void setRectangleCenterX(final int rectangleCenterX) {
        this.rectangleCenterX = rectangleCenterX;
    }

    public final int getRectangleCenterY() {
        return rectangleCenterY;
    }

    public final void setRectangleCenterY(final int rectangleCenterY) {
        this.rectangleCenterY = rectangleCenterY;
    }

    private static final int RECTANGLE_SIDES = 4;

    public Rectangle(final FileReader input) throws IOException {
        this.setStartX(input.nextInt());
        this.setStartY(input.nextInt());
        this.setHeight(input.nextInt());
        this.setWidth(input.nextInt());
        this.setBorderColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
        this.setInsideColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
        this.setRectangleCenterX(
            (this.getStartX() * RECTANGLE_SIDES + this.getWidth() * 2) / RECTANGLE_SIDES);
        this.setRectangleCenterY(
            (this.getStartY() * RECTANGLE_SIDES + this.getHeight() * 2) / RECTANGLE_SIDES);
    }

    @Override
    public final void draw(final Visitor visitor, final Canvas img) {
        visitor.visit(this, img);
    }
}
