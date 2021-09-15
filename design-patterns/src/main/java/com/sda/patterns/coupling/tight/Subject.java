package com.sda.patterns.coupling.tight;

// subject depends on topic. because they are tightly coupled
// any change to topic will force subject to change
public class Subject {

    Topic topic = new Topic();

    public void startReading() {
        topic.understand();
    }
}
