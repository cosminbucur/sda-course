package com.bucur.patterns.behavioral.state;

import com.bucur.patterns.behavioral.state.ui.Player;
import com.bucur.patterns.behavioral.state.ui.UI;

public class DemoStatePattern {

    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
