package pl.minigames;

import pl.minigames.lotto.LottoFacade;

import java.util.HashMap;
import java.util.Map;

class GameChooser {

    private final Map<String, String> availableGames = new HashMap<>();
    private static final InputReciver inputReciver = InputReciver.getInstance();
    private static final MessagePrinter MESSAGE_PRINTER = new MessagePrinter();

    public GameChooser() {
        initialize();
    }

    private void initialize() {
        availableGames.put("Lotto", "Loading, please wait"); //make import of games via file
        availableGames.put("Batlleships", "Sorry not ready yet..");
        availableGames.put("Solitare", "Ups, not ready!");
    }

    public void choose() {
        String game = chooseGame();
        initializeGame(game);
    }

    private String chooseGame() {
        String game = "";
        while (!game.equals("Lotto")) {
            game = choosingGame();
        }
        return game;
    }

    private void initializeGame(String s) {
        switch (s) {
            case "Lotto":
                startLotto();
        }
    }

    private String choosingGame() {
        chooseGameMessage();
        boolean chooseGame = true;
        while (chooseGame) {
            String choosenGame = inputReciver.getString();
            if (validateGame(choosenGame)) {
                printGameReadyState(choosenGame);
                return choosenGame;
            } else gameNotInBaseMessage();
        }
        return "Probably an error of some kind occured";
    }

    private void gameNotInBaseMessage() {
        System.out.println("Sorry no such game in base");
    }

    private void chooseGameMessage() {
        System.out.println("Please choose a game");
    }

    public Map<String, String> getAvailableGames() {
        return availableGames;
    }

    private boolean validateGame(String s) {
        return availableGames.containsKey(s) ? true : false;
    }

    private void printGameReadyState(String s) {
        System.out.println(availableGames.get(s));
    }

    private void startLotto() {
        LottoFacade clientLotto = new LottoFacade();
        clientLotto.start();
    }
}
