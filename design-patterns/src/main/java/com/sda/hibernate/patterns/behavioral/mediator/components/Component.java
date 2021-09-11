package com.bucur.patterns.behavioral.mediator.components;

import com.bucur.patterns.behavioral.mediator.mediator.Mediator;

public interface Component {

    void setMediator(Mediator mediator);

    String getName();
}
