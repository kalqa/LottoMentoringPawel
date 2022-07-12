package pl.minigames;

import pl.minigames.batlleships.BatlleShipsFacade;
import pl.minigames.lotto.LottoFacade;
import pl.minigames.solitare.SolitareFacade;

import java.util.HashMap;
import java.util.Map;

class GameChooser {

    private final Map<String, IGame> availableGames = new HashMap<>();
    private final IInputReciver INPUT_RECIVER;
    private final MessagePrinter MESSAGE_PRINTER;
    private final String CHOOSE_GAME_MESSAGE = "Please choose a game";
    private final String NO_GAME_IN_BASE_MESSAGE = "Sorry no such game in base";

    public GameChooser(IInputReciver inputReceiver) {
        this.INPUT_RECIVER = inputReceiver;
        this.MESSAGE_PRINTER = new MessagePrinter();
        initialize();
    }

    private void initialize() {
        availableGames.put("LOTTO", new LottoFacade(INPUT_RECIVER, true));
        availableGames.put("BATLLESHIPS", new BatlleShipsFacade());
        availableGames.put("SOLITARE", new SolitareFacade());
    }


    public IGame selectingGame() {
        MESSAGE_PRINTER.print(CHOOSE_GAME_MESSAGE);
        boolean validGame = false;
        String gameChosenByUser = "";
        while (!validGame) {
            gameChosenByUser = INPUT_RECIVER.getString();
            if (validateGame(gameChosenByUser)) {
                validGame = validateGame(gameChosenByUser);
            } else {
                MESSAGE_PRINTER.print(NO_GAME_IN_BASE_MESSAGE);
            }
        }
        return availableGames.get(gameChosenByUser);
    }

    public Map<String, IGame> getAvailableGames() {
        return availableGames;
    }

    private boolean validateGame(String s) {
        return availableGames.containsKey(s) ? true : false;
    }
}
