package pl.minigames.batlleships;

import pl.minigames.IGame;

public class BatlleShipsFacade implements IGame {
    public BatlleShipsFacade() {
    }

    @Override
    public String start() {
        System.out.println("Not ready yet");
        return "not ready yet";
    }
}
