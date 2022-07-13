package pl.minigames.gamestarter;

import pl.minigames.Playable;
import pl.minigames.InputReceivable;

public class GameStarter {


    private InputReceivable inputReciver;
    private Playable game;

    public GameStarter(InputReceivable inputReciver, Playable game) {
        this.inputReciver = inputReciver;
        this.game = game;
    }


    public String startGame() {
        return game.start();
    }
}
