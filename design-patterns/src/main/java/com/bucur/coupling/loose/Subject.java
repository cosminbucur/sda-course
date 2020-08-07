package com.bucur.coupling.loose;

import com.bucur.coupling.tight.Topic;

public class Subject {

    private Topic topic;

    public Subject(Topic topic) {
        this.topic = topic;
    }

    public void startReading() {
        topic.understand();
    }
}
