package pl.minigames.solitare;

import pl.minigames.Playable;

public class SolitareFacade implements Playable {
    public SolitareFacade() {
    }

    @Override
    public String start() {
        System.out.println("Not ready yet");
        return "not ready yet";
    }
}
