package pl.minigames.batlleships;

import pl.minigames.Playable;

public class BatlleShipsFacade implements Playable {
    public BatlleShipsFacade() {
    }

    @Override
    public String start() {
        System.out.println("Not ready yet");
        return "not ready yet";
    }
}
