package com.sda.patterns.design.behavioral.visitor.shapes;

import com.sda.patterns.design.behavioral.visitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class MyCompoundShape implements MyShape {

    public int id;
    public List<MyShape> children = new ArrayList<>();

    public MyCompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        // move shape
    }

    @Override
    public void draw() {
        // draw shape
    }

    public int getId() {
        return id;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundGraphic(this);
    }

    public void add(MyShape myShape) {
        children.add(myShape);
    }
}
