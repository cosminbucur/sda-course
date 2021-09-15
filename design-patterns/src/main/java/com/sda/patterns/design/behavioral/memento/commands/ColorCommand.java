package com.sda.patterns.design.behavioral.memento.commands;

import com.sda.patterns.design.behavioral.memento.editor.Editor;
import com.sda.patterns.design.behavioral.memento.shapes.Shape;

import java.awt.*;

public class ColorCommand implements Command {

    private Editor editor;
    private Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
