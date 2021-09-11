package com.bucur.patterns.behavioral.visitor.visitor;

import com.bucur.patterns.behavioral.visitor.shapes.Circle;
import com.bucur.patterns.behavioral.visitor.shapes.Dot;
import com.bucur.patterns.behavioral.visitor.shapes.MyCompoundShape;
import com.bucur.patterns.behavioral.visitor.shapes.MyShape;
import com.bucur.patterns.behavioral.visitor.shapes.Rectangle;

public class XMLExportVisitor implements Visitor {

    public String export(MyShape... args) {
        StringBuilder sb = new StringBuilder();
        for (MyShape myShape : args) {
            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
            sb.append(myShape.accept(this)).append("\n");
            System.out.println(sb.toString());
            sb.setLength(0);
        }
        return sb.toString();
    }

    public String visitDot(Dot d) {
        return "<dot>" + "\n" +
            "    <id>" + d.getId() + "</id>" + "\n" +
            "    <x>" + d.getX() + "</x>" + "\n" +
            "    <y>" + d.getY() + "</y>" + "\n" +
            "</dot>";
    }

    public String visitCircle(Circle c) {
        return "<circle>" + "\n" +
            "    <id>" + c.getId() + "</id>" + "\n" +
            "    <x>" + c.getX() + "</x>" + "\n" +
            "    <y>" + c.getY() + "</y>" + "\n" +
            "    <radius>" + c.getRadius() + "</radius>" + "\n" +
            "</circle>";
    }

    public String visitRectangle(Rectangle r) {
        return "<rectangle>" + "\n" +
            "    <id>" + r.getId() + "</id>" + "\n" +
            "    <x>" + r.getX() + "</x>" + "\n" +
            "    <y>" + r.getY() + "</y>" + "\n" +
            "    <width>" + r.getWidth() + "</width>" + "\n" +
            "    <height>" + r.getHeight() + "</height>" + "\n" +
            "</rectangle>";
    }

    public String visitCompoundGraphic(MyCompoundShape cs) {
        return "<compound_graphic>" + "\n" +
            "   <id>" + cs.getId() + "</id>" + "\n" +
            _visitCompoundGraphic(cs) +
            "</compound_graphic>";
    }

    private String _visitCompoundGraphic(MyCompoundShape cs) {
        StringBuilder sb = new StringBuilder();
        for (MyShape myShape : cs.children) {
            String obj = myShape.accept(this);
            // Proper indentation for sub-objects.
            obj = "    " + obj.replace("\n", "\n    ") + "\n";
            sb.append(obj);
        }
        return sb.toString();
    }
}
