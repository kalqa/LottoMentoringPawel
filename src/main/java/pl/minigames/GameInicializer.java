package pl.minigames;

import pl.minigames.chooser.GameChooser;

class GameInicializer {

    private InputReceivable inputReciver;

    public GameInicializer(InputReceivable inputReciver, UserMenuOptions selectedOptionFromUser) {
        this.inputReciver = inputReciver;
        this.gameChooser = new GameChooser(inputReciver);
    }

    public void InitializeGame() {
        IGame iGame = gameChooser.selectingGame();
        startGame(iGame);
    }

    private void startGame(IGame game) {
        game.start();
    }
}
