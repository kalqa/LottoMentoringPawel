package pl.minigames.chooser;

import pl.minigames.InputReceivable;
import pl.minigames.Playable;
import pl.minigames.batlleships.BatlleShipsFacade;
import pl.minigames.lotto.LottoFacade;
import pl.minigames.lotto.WinningNumbersProvider;
import pl.minigames.solitare.SolitareFacade;

import java.util.HashMap;
import java.util.Map;

public class GameChooser {

    private final Map<String, Playable> availableGames = new HashMap<>();
    private final InputReceivable inputReciver;
    private final MessagePrinter printer;


    public GameChooser(InputReceivable inputReceiver, WinningNumbersProvider winningNumbersProvider) {
        this.inputReciver = inputReceiver;
        this.printer = new MessagePrinter();
        availableGames.put("LOTTO", new LottoFacade(inputReciver, winningNumbersProvider));
        availableGames.put("BATLLESHIPS", new BatlleShipsFacade());
        availableGames.put("SOLITARE", new SolitareFacade());
    }


    public Playable selectingGame() {
        printer.printChooseGame();
        String gameChosenByUser = retriveValidGameNameFromUser();
        return availableGames.get(gameChosenByUser);
    }

    private String retriveValidGameNameFromUser() {
        String gameChosenByUser="";
        while (!validateGame(gameChosenByUser)) {
            gameChosenByUser = inputReciver.receiveSignFromUser();
            if (!validateGame(gameChosenByUser)) {
                printer.printNoGameInBase();
            }
        }
        return gameChosenByUser;
    }

    private boolean validateGame(String s) {
        return availableGames.containsKey(s) ? true : false;
    }

    public Map<String, Playable> getAvailableGames() {
        return availableGames;
    }


}
