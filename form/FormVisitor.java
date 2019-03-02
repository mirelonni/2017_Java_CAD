package form;

import drawing.Canvas;
import java.util.ArrayList;

public class FormVisitor implements Visitor {

    @Override
    public final void visit(final Line line, final Canvas img) {
        img.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY(),
                     line.getColor());
    }

    @Override
    public final void visit(final Square square, final Canvas img) {
        img.drawLine(square.getStartX(), square.getStartY(), square.getStartX() + square.getSide() - 1,
                     square.getStartY(), square.getBorderColor());
        img.drawLine(square.getStartX(), square.getStartY(), square.getStartX(),
                     square.getStartY() + square.getSide() - 1, square.getBorderColor());
        img.drawLine(square.getStartX() + square.getSide() - 1, square.getStartY(),
                     square.getStartX() + square.getSide() - 1, square.getStartY() + square.getSide() - 1,
                     square.getBorderColor());
        img.drawLine(square.getStartX(), square.getStartY() + square.getSide() - 1,
                     square.getStartX() + square.getSide() - 1, square.getStartY() + square.getSide() - 1,
                     square.getBorderColor());
    }

    @Override
    public final void visit(final Rectangle rectangle, final Canvas img) {
        img.drawLine(rectangle.getStartX(), rectangle.getStartY(),
                     rectangle.getStartX() + rectangle.getWidth() - 1, rectangle.getStartY(),
                     rectangle.getBorderColor());
        img.drawLine(rectangle.getStartX(), rectangle.getStartY() + rectangle.getHeight() - 1,
                     rectangle.getStartX(), rectangle.getStartY(), rectangle.getBorderColor());
        img.drawLine(rectangle.getStartX() + rectangle.getWidth() - 1, rectangle.getStartY(),
                     rectangle.getStartX() + rectangle.getWidth() - 1,
                     rectangle.getStartY() + rectangle.getHeight() - 1, rectangle.getBorderColor());
        img.drawLine(rectangle.getStartX(), rectangle.getStartY() + rectangle.getHeight() - 1,
                     rectangle.getStartX() + rectangle.getWidth() - 1,
                     rectangle.getStartY() + rectangle.getHeight() - 1, rectangle.getBorderColor());
    }

    @Override
    public final void visit(final Triangle triangle, final Canvas img) {
        img.drawLine(triangle.getX1(), triangle.getY1(), triangle.getX2(), triangle.getY2(),
                     triangle.getBorderColor());
        img.drawLine(triangle.getX2(), triangle.getY2(), triangle.getX3(), triangle.getY3(),
                     triangle.getBorderColor());
        img.drawLine(triangle.getX3(), triangle.getY3(), triangle.getX1(), triangle.getY1(),
                     triangle.getBorderColor());
    }

    @Override
    public final void visit(final Diamond diamond, final Canvas img) {
        img.drawLine(diamond.getCenterX(), diamond.getCenterY() - diamond.getDiagY() / 2,
                     diamond.getCenterX() + diamond.getDiagX() / 2, diamond.getCenterY(),
                     diamond.getBorderColor());
        img.drawLine(diamond.getCenterX() + diamond.getDiagX() / 2, diamond.getCenterY(),
                     diamond.getCenterX(), diamond.getCenterY() + diamond.getDiagY() / 2,
                     diamond.getBorderColor());
        img.drawLine(diamond.getCenterX(), diamond.getCenterY() + diamond.getDiagY() / 2,
                     diamond.getCenterX() - diamond.getDiagX() / 2, diamond.getCenterY(),
                     diamond.getBorderColor());
        img.drawLine(diamond.getCenterX(), diamond.getCenterY() - diamond.getDiagY() / 2,
                     diamond.getCenterX() - diamond.getDiagX() / 2, diamond.getCenterY(),
                     diamond.getBorderColor());
    }

    @Override
    public final void visit(final Circle circle, final Canvas img) {
        img.drawCircle(circle.getCenterX(), circle.getCenterY(), circle.getRadius(),
                       circle.getBorderColor());
    }

    @Override
    public final void visit(final Polygon polygon, final Canvas img) {
        ArrayList<Integer> x = polygon.getX();
        ArrayList<Integer> y = polygon.getY();

        for (int i = 0; i < polygon.getNumberOfPoints() - 1; i++) {
            img.drawLine(x.get(i), y.get(i), x.get(i + 1), y.get(i + 1), polygon.getBorderColor());
        }

        img.drawLine(x.get(polygon.getNumberOfPoints() - 1), y.get(polygon.getNumberOfPoints() - 1),
                     x.get(0), y.get(0), polygon.getBorderColor());
    }

    @Override
    public void visit(final Form form, final Canvas img) {
    }

}
