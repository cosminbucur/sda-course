package com.bucur.patterns.behavioral.observer;

import com.bucur.patterns.behavioral.observer.editor.Editor;
import com.bucur.patterns.behavioral.observer.listeners.EmailNotificationListener;
import com.bucur.patterns.behavioral.observer.listeners.LogOpenListener;

public class DemoObserverPattern {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
