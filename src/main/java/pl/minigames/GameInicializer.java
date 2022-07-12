package pl.minigames;

class GameInicializer {
    private IInputReciver inputReciver;
    private final GameChooser gameChooser;
    public GameInicializer(IInputReciver inputReciver) {
        this.inputReciver=inputReciver;
        this.gameChooser= new GameChooser(inputReciver);
    }
    public void InitializeGame() {
        IGame iGame = gameChooser.selectingGame();
        initializeGame(iGame);
    }

    private void initializeGame(IGame game) {
        game.start();
    }
}
