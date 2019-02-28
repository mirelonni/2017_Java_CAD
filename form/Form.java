package form;

import drawing.Canvas;

public abstract class Form implements Visitable {
  /**
   * Used for linking the forms used in the factory.
   */
  public void draw(final Visitor visitor, final Canvas img) {
    visitor.visit(this, img);
  }
}
