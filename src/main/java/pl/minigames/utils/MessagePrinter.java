package pl.minigames.utils;

import pl.minigames.Playable;

import java.util.Map;

public class MessagePrinter {

    public MessagePrinter() {
    }


    public void printGames(Map<String, Playable> availableGames) {
        for (String s : availableGames.keySet()) {
            print("We have a " + s + " game in database right now");
        }
    }

    private void print(String s) {
        System.out.println(s);
    }
}
