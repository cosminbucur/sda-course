package com.sda.patterns.design.behavioral.visitor.visitor;

import com.sda.patterns.design.behavioral.visitor.shapes.Circle;
import com.sda.patterns.design.behavioral.visitor.shapes.Dot;
import com.sda.patterns.design.behavioral.visitor.shapes.MyCompoundShape;
import com.sda.patterns.design.behavioral.visitor.shapes.Rectangle;

public interface Visitor {

    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(MyCompoundShape compoundShape);
}
