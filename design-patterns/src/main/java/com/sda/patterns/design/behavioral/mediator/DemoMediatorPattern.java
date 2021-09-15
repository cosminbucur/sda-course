package com.sda.patterns.design.behavioral.mediator;

import com.sda.patterns.design.behavioral.mediator.components.AddButton;
import com.sda.patterns.design.behavioral.mediator.components.DeleteButton;
import com.sda.patterns.design.behavioral.mediator.components.Filter;
import com.sda.patterns.design.behavioral.mediator.components.List;
import com.sda.patterns.design.behavioral.mediator.components.SaveButton;
import com.sda.patterns.design.behavioral.mediator.components.TextBox;
import com.sda.patterns.design.behavioral.mediator.components.Title;
import com.sda.patterns.design.behavioral.mediator.mediator.Editor;
import com.sda.patterns.design.behavioral.mediator.mediator.Mediator;

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
