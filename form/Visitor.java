package form;

import drawing.Canvas;

public interface Visitor {
  void visit(Form form, Canvas img);

  void visit(Line line, Canvas img);

  void visit(Square square, Canvas img);

  void visit(Rectangle rectangle, Canvas img);

  void visit(Triangle triangle, Canvas img);

  void visit(Diamond diamond, Canvas img);

  void visit(Circle circle, Canvas img);

  void visit(Polygon polygon, Canvas img);
}
