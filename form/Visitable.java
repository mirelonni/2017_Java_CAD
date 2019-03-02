package form;

import drawing.Canvas;

public interface Visitable {
    void draw(Visitor visitor, Canvas img);
}
