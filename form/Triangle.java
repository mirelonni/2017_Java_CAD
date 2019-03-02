package form;

import java.awt.Color;
import java.io.IOException;
import drawing.Canvas;
import drawing.MakeRGB;
import fileio.implementations.FileReader;

public class Triangle extends Form {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private Color borderColor;
    private Color insideColor;
    private int triangleCenterX;
    private int triangleCenterY;

    public final int getX1() {
        return x1;
    }

    public final void setX1(final int x1) {
        this.x1 = x1;
    }

    public final int getY1() {
        return y1;
    }

    public final void setY1(final int y1) {
        this.y1 = y1;
    }

    public final int getX2() {
        return x2;
    }

    public final void setX2(final int x2) {
        this.x2 = x2;
    }

    public final int getY2() {
        return y2;
    }

    public final void setY2(final int y2) {
        this.y2 = y2;
    }

    public final int getX3() {
        return x3;
    }

    public final void setX3(final int x3) {
        this.x3 = x3;
    }

    public final int getY3() {
        return y3;
    }

    public final void setY3(final int y3) {
        this.y3 = y3;
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

    public final int getTriangleCenterX() {
        return triangleCenterX;
    }

    public final void setTriangleCenterX(final int triangleCenterX) {
        this.triangleCenterX = triangleCenterX;
    }

    public final int getTriangleCenterY() {
        return triangleCenterY;
    }

    public final void setTriangleCenterY(final int triangleCenterY) {
        this.triangleCenterY = triangleCenterY;
    }

    private static final int TRIANGLE_SIDES = 3;

    public Triangle(final FileReader input) throws IOException {
        this.setX1(input.nextInt());
        this.setY1(input.nextInt());
        this.setX2(input.nextInt());
        this.setY2(input.nextInt());
        this.setX3(input.nextInt());
        this.setY3(input.nextInt());
        this.setBorderColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
        this.setInsideColor(MakeRGB.makeRGB(input.nextWord(), input.nextInt()));
        this.setTriangleCenterX((this.getX1() + this.getX2() + this.getX3()) / TRIANGLE_SIDES);
        this.setTriangleCenterY((this.getY1() + this.getY2() + this.getY3()) / TRIANGLE_SIDES);
    }

    public final void draw(final Visitor visitor, final Canvas img) {
        visitor.visit(this, img);
    }
}
