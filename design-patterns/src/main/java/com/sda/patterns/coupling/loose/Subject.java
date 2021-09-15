package com.sda.patterns.coupling.loose;

import com.sda.patterns.coupling.tight.Topic;

public class Subject {

    private com.sda.patterns.coupling.tight.Topic topic;

    public Subject(Topic topic) {
        this.topic = topic;
    }

    public void startReading() {
        topic.understand();
    }
}
