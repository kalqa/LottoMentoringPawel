package pl.minigames.lotto;

import pl.minigames.Playable;
import pl.minigames.InputReceivable;

import java.util.Set;

public class LottoFacade implements Playable {

    private final InputReceivable INPUT_RECIVER;
    private final WinningNumbersProvider winningNumbersProvider;
    private final LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    private final GameModel gameModel;
    private final ScoreChecker scoreChecker;
    private final String PICK_START_OPTION_MESSAGE = "Type 1 to start game, Type 2 to check numbers by drawing number";
    private final String PLAY_OPTION_STRING = "1";
    private final String CHECKSCORE_OPTION_STRING = "2";
    private final String ERROR_IN_START_MESSAGE = "Well, there is an error in start..";


    public LottoFacade(InputReceivable inputReciver, boolean overrideMethodsForTestPurposes) {
        this.INPUT_RECIVER = inputReciver;
        this.winningNumbersProvider = overrideMethodsForTestPurposes ? new WinningNumbersProvider() {


            @Override
            public Set<Integer> drawingNumbers() {
                return drawnNumbers;
            }

            @Override
            public void setResultForTestPurpose(Set<Integer> collect) {
                for (Integer i : collect)
                    drawnNumbers.add(i);
            }

            @Override
            public void saveNumbers(Set<Integer> set) {

            }
        } : new LottoNumberGenerator();
        this.gameModel = new GameModel(inputReciver, winningNumbersProvider);
        this.scoreChecker = new ScoreChecker(inputReciver);
    }

    @Override
    public String start() {
        messagePrinter.printLottoMessage(PICK_START_OPTION_MESSAGE);
        String optionPicked = "";
        while (!optionPicked.equals(PLAY_OPTION_STRING) || !optionPicked.equals(CHECKSCORE_OPTION_STRING)) {
            optionPicked = INPUT_RECIVER.receiveSignFromUser();
            if (optionPicked.equals(PLAY_OPTION_STRING)) return gameModel.play();
            if (optionPicked.equals(CHECKSCORE_OPTION_STRING)) return scoreChecker.checkScore();
        }
        return ERROR_IN_START_MESSAGE;
    }

    public WinningNumbersProvider getWinningNumbersProvider() {
        return winningNumbersProvider;
    }
}
