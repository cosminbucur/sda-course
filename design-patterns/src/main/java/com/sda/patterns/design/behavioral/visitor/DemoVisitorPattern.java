package com.sda.patterns.design.behavioral.visitor;

import com.sda.patterns.design.behavioral.visitor.shapes.Circle;
import com.sda.patterns.design.behavioral.visitor.shapes.Dot;
import com.sda.patterns.design.behavioral.visitor.shapes.MyCompoundShape;
import com.sda.patterns.design.behavioral.visitor.shapes.MyShape;
import com.sda.patterns.design.behavioral.visitor.shapes.Rectangle;
import com.sda.patterns.design.behavioral.visitor.visitor.XMLExportVisitor;

public class DemoVisitorPattern {

    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        MyCompoundShape mainShape = new MyCompoundShape(4);
        mainShape.add(dot);
        mainShape.add(circle);
        mainShape.add(rectangle);

        MyCompoundShape childShape = new MyCompoundShape(5);
        childShape.add(dot);

        mainShape.add(childShape);

        export(circle, mainShape);
    }

    private static void export(MyShape... myShapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(myShapes));
    }
}
