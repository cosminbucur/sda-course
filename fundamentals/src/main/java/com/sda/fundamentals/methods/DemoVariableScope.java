package com.sda.fundamentals.methods;

public class DemoVariableScope {

    public void method() {
        int x = 1;

        if (x == 1) {
            System.out.println("ok");
            int y = 2;
            // x visible here
        }
        // y not visible
    }
}
