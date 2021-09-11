package com.bucur.patterns.behavioral.visitor.shapes;

import com.bucur.patterns.behavioral.visitor.visitor.Visitor;

public interface MyShape {

    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
