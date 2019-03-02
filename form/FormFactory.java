package form;

import java.io.IOException;
import fileio.implementations.FileReader;

public final class FormFactory {
    private static FormFactory oneFactory = null;

    private FormFactory() {
    }

    public static FormFactory getFactory() {
        if (oneFactory == null) {
            oneFactory = new FormFactory();
        }

        return oneFactory;
    }

    public Form makeForm(final String formType, final FileReader input) throws IOException {
        switch (formType) {
        case "LINE":
            return new Line(input);
        case "SQUARE":
            return new Square(input);
        case "RECTANGLE":
            return new Rectangle(input);
        case "TRIANGLE":
            return new Triangle(input);
        case "DIAMOND":
            return new Diamond(input);
        case "CIRCLE":
            return new Circle(input);
        case "POLYGON":
            return new Polygon(input);
        default:
            return null;
        }

    }
}
