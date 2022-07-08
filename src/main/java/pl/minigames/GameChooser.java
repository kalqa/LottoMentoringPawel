package pl.minigames;

import pl.minigames.batlleships.BatlleShipsFacade;
import pl.minigames.lotto.LottoFacade;
import pl.minigames.solitare.SolitareFacade;

import java.util.HashSet;
import java.util.Set;

class GameChooser {

    private final Set<String> availableGames = new HashSet<>();
    private final IInputReciver INPUT_RECIVER;
    private final MessagePrinter MESSAGE_PRINTER = new MessagePrinter();
    private IGame iGame;
    private final String CHOOSE_GAME_MESSAGE = "Please choose a game";
    private final String NO_GAME_IN_BASE_MESSAGE = "Sorry no such game in base";

    public GameChooser(IInputReciver inputReceiver) {
        initialize();
        this.INPUT_RECIVER = inputReceiver;
    }

    private void initialize() {
        availableGames.add("LOTTO"); //make import of games via file
        availableGames.add("BATLLESHIPS");
        availableGames.add("SOLITARE");
    }
    public void InitializeChoosenGame() {
        initializeGame(selectingGame());
    }

    private void initializeGame(IGame game) {
        game.start();
    }

    private IGame selectingGame() {
        MESSAGE_PRINTER.print(CHOOSE_GAME_MESSAGE);
        boolean validGame = false;
        while (!validGame) {
            String gameChosenByUser = INPUT_RECIVER.getString();
            if (validateGame(gameChosenByUser)) {
                return returnIGameClass(gameChosenByUser);
            } else {
                MESSAGE_PRINTER.print(NO_GAME_IN_BASE_MESSAGE);
            }
        }
        return null;
    }

    private IGame returnIGameClass(String gameChosenByUser) {
        switch (gameChosenByUser) {
            case "LOTTO":
                return new LottoFacade(ScannerInputReciver.getInstance());
            case "BATLLESHIPS":
                return new BatlleShipsFacade();
            case "SOLITARE":
                return new SolitareFacade();
            default:
                break;
        }
        return null;
    }


    public Set<String> getAvailableGames() {
        return availableGames;
    }

    private boolean validateGame(String s) {
        return availableGames.contains(s) ? true : false;
    }
}
