package form;

import drawing.Canvas;
import java.util.ArrayList;

public class FillVisitor implements Visitor {

    @Override
    public final void visit(final Line line, final Canvas img) {
    }

    @Override
    public final void visit(final Square square, final Canvas img) {
        if (square.getSquareCenterX() < 0) {
            square.setSquareCenterX((square.getStartX() + square.getSide()) / 2);
        }

        if (square.getSquareCenterX() > img.getWidth()) {
            square.setSquareCenterX(img.getWidth() - (img.getWidth() - square.getStartX()) / 2);
        }

        if (square.getSquareCenterY() < 0) {
            square.setSquareCenterY((square.getStartY() + square.getSide()) / 2);
        }

        if (square.getSquareCenterY() > img.getHeight()) {
            square.setSquareCenterY(img.getHeight() - (img.getHeight() - square.getStartY()) / 2);
        }

        img.floodFill(square.getSquareCenterX(), square.getSquareCenterY(), square.getInsideColor(),
                      square.getBorderColor());
    }

    @Override
    public final void visit(final Rectangle rectangle, final Canvas img) {
        if (rectangle.getRectangleCenterX() < 0) {
            rectangle.setRectangleCenterX((rectangle.getStartX() + rectangle.getWidth()) / 2);
        }

        if (rectangle.getRectangleCenterX() > img.getWidth()) {
            rectangle.setRectangleCenterX(img.getWidth() - (img.getWidth() - rectangle.getStartX()) / 2);
        }

        if (rectangle.getRectangleCenterY() < 0) {
            rectangle.setRectangleCenterY((rectangle.getStartY() + rectangle.getHeight()) / 2);
        }

        if (rectangle.getRectangleCenterY() > img.getHeight()) {
            rectangle
            .setRectangleCenterY(img.getHeight() - (img.getHeight() - rectangle.getStartY()) / 2);
        }

        img.floodFill(rectangle.getRectangleCenterX(), rectangle.getRectangleCenterY(),
                      rectangle.getInsideColor(), rectangle.getBorderColor());
    }

    @Override
    public final void visit(final Triangle triangle, final Canvas img) {
        img.floodFill(triangle.getTriangleCenterX(), triangle.getTriangleCenterY(),
                      triangle.getInsideColor(), triangle.getBorderColor());
    }

    @Override
    public final void visit(final Diamond diamond, final Canvas img) {
        img.floodFill(diamond.getCenterX(), diamond.getCenterY(), diamond.getInsideColor(),
                      diamond.getBorderColor());
    }

    @Override
    public final void visit(final Circle circle, final Canvas img) {
        img.floodFill(circle.getCenterX(), circle.getCenterY(), circle.getInsideColor(),
                      circle.getBorderColor());
    }

    @Override
    public final void visit(final Polygon polygon, final Canvas img) {
        ArrayList<Integer> x = polygon.getX();
        ArrayList<Integer> y = polygon.getY();
        int sumX = 0;
        int sumY = 0;

        for (int i = 0; i < polygon.getNumberOfPoints() - 1; i++) {
            sumX += x.get(i);
            sumY += y.get(i);
        }

        sumX += x.get(polygon.getNumberOfPoints() - 1);
        sumY += y.get(polygon.getNumberOfPoints() - 1);
        img.floodFill(sumX / polygon.getNumberOfPoints(), sumY / polygon.getNumberOfPoints(),
                      polygon.getInsideColor(), polygon.getBorderColor());
    }

    @Override
    public void visit(final Form form, final Canvas img) {
    }

}
