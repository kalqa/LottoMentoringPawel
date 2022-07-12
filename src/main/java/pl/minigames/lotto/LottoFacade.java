package pl.minigames.lotto;

import pl.minigames.IGame;
import pl.minigames.IInputReciver;

public class LottoFacade implements IGame {

    private final IInputReciver INPUT_RECIVER;
    private final IWinningNumbersProvider iWinningNumbersProvider;
    private final LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    private final GameModel gameModel;
    private final ScoreChecker scoreChecker;
    private final String PICK_START_OPTION_MESSAGE = "Type 1 to start game, Type 2 to check numbers by drawing number";
    private final String PLAY_OPTION_STRING = "1";
    private final String CHECKSCORE_OPTION_STRING = "2";
    private final String ERROR_IN_START_MESSAGE = "Well, there is an error in start..";


    public LottoFacade(IInputReciver inputReciver, boolean isNoTaTest) {
        this.INPUT_RECIVER = inputReciver;
        this.iWinningNumbersProvider = isNoTaTest == true ? new LottoNumberGenerator() : new ManualLottoNumbersTest();
        this.gameModel = new GameModel(inputReciver,iWinningNumbersProvider);
        this.scoreChecker = new ScoreChecker(inputReciver);
    }

    @Override
    public String start() {
        messagePrinter.printLottoMessage(PICK_START_OPTION_MESSAGE);
        String optionPicked = "";
        while (!optionPicked.equals(PLAY_OPTION_STRING) || !optionPicked.equals(CHECKSCORE_OPTION_STRING)) {
            optionPicked = INPUT_RECIVER.getString();
            if (optionPicked.equals(PLAY_OPTION_STRING)) return gameModel.play();
            if (optionPicked.equals(CHECKSCORE_OPTION_STRING)) return scoreChecker.checkScore();
        }
        return ERROR_IN_START_MESSAGE;
    }
    public IWinningNumbersProvider getiWinningNumbersProvider() {
        return iWinningNumbersProvider;
    }
}
