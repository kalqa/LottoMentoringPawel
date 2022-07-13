package pl.minigames.chooser;

import pl.minigames.InputReceivable;
import pl.minigames.Playable;
import pl.minigames.batlleships.BatlleShipsFacade;
import pl.minigames.lotto.LottoFacade;
import pl.minigames.solitare.SolitareFacade;

import java.util.HashMap;
import java.util.Map;

public class GameChooser {

    private final Map<String, Playable> availableGames = new HashMap<>();
    private final InputReceivable inputReciver;
    private final MessagePrinter printer;
    private final boolean testMode;


    public GameChooser(InputReceivable inputReceiver, boolean testMode) {
        this.inputReciver = inputReceiver;
        this.testMode = testMode;
        this.printer = new MessagePrinter();
        availableGames.put("LOTTO", new LottoFacade(inputReciver, false));
        availableGames.put("BATLLESHIPS", new BatlleShipsFacade());
        availableGames.put("SOLITARE", new SolitareFacade());
        if (testMode) {
            availableGames.put("LOTTO", new LottoFacade(inputReciver, true));
        }
    }


    public Playable selectingGame() {
        printer.printChooseGame();
        String gameChosenByUser = "";
        while (!validateGame(gameChosenByUser)) {
            gameChosenByUser = inputReciver.receiveSignFromUser();
            if (!validateGame(gameChosenByUser)) {
                printer.printNoGameInBase();
            }
        }
        return availableGames.get(gameChosenByUser);
    }

    private boolean validateGame(String s) {
        return availableGames.containsKey(s) ? true : false;
    }

    public Map<String, Playable> getAvailableGames() {
        return availableGames;
    }


}
