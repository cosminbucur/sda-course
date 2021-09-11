package com.bucur.patterns.behavioral.visitor.visitor;

import com.bucur.patterns.behavioral.visitor.shapes.Circle;
import com.bucur.patterns.behavioral.visitor.shapes.Dot;
import com.bucur.patterns.behavioral.visitor.shapes.MyCompoundShape;
import com.bucur.patterns.behavioral.visitor.shapes.Rectangle;

public interface Visitor {

    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(MyCompoundShape compoundShape);
}
