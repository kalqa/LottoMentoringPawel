package pl.minigames.solitare;

import pl.minigames.IGame;

public class SolitareFacade implements IGame {
    public SolitareFacade() {
    }

    @Override
    public String start() {
        System.out.println("Not ready yet");
        return "not ready yet";
    }
}
