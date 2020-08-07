package com.bucur.patterns.behavioral.mediator;

import com.bucur.patterns.behavioral.mediator.components.AddButton;
import com.bucur.patterns.behavioral.mediator.components.DeleteButton;
import com.bucur.patterns.behavioral.mediator.components.Filter;
import com.bucur.patterns.behavioral.mediator.components.List;
import com.bucur.patterns.behavioral.mediator.components.SaveButton;
import com.bucur.patterns.behavioral.mediator.components.TextBox;
import com.bucur.patterns.behavioral.mediator.components.Title;
import com.bucur.patterns.behavioral.mediator.mediator.Editor;
import com.bucur.patterns.behavioral.mediator.mediator.Mediator;

import javax.swing.*;

public class DemoMediatorPattern {

    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
