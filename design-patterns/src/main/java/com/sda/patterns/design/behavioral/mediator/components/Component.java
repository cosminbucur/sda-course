package com.sda.patterns.design.behavioral.mediator.components;

import com.sda.patterns.design.behavioral.mediator.mediator.Mediator;

public interface Component {

    void setMediator(Mediator mediator);

    String getName();
}
