package com.sda.patterns.design.behavioral.visitor.shapes;

import com.sda.patterns.design.behavioral.visitor.visitor.Visitor;

public interface MyShape {

    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
