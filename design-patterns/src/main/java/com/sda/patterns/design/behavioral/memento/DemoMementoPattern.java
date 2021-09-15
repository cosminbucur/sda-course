package com.sda.patterns.design.behavioral.memento;

import com.sda.patterns.design.behavioral.memento.editor.Editor;
import com.sda.patterns.design.behavioral.memento.shapes.Circle;
import com.sda.patterns.design.behavioral.memento.shapes.CompoundShape;
import com.sda.patterns.design.behavioral.memento.shapes.Dot;
import com.sda.patterns.design.behavioral.memento.shapes.Rectangle;

import java.awt.*;

public class DemoMementoPattern {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(
            new Circle(10, 10, 10, Color.BLUE),

            new CompoundShape(
                new Circle(110, 110, 50, Color.RED),
                new Dot(160, 160, Color.RED)
            ),

            new CompoundShape(
                new Rectangle(250, 250, 100, 100, Color.GREEN),
                new Dot(240, 240, Color.GREEN),
                new Dot(240, 360, Color.GREEN),
                new Dot(360, 360, Color.GREEN),
                new Dot(360, 240, Color.GREEN)
            )
        );
    }
}
