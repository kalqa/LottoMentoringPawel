package pl.minigames.lotto;

import pl.minigames.InputReceivable;
import pl.minigames.Playable;

public class LottoFacade implements Playable {

    private final InputReceivable INPUT_RECIVER;
    private WinningNumbersProvider winningNumbersProvider;
    private final LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    private final LottoMenu lottoMenu;
    private final GameModel gameModel;
    private final ScoreChecker scoreChecker;
    private final String PICK_START_OPTION_MESSAGE = "Type 1 to start game, Type 2 to check numbers by drawing number";
    private final String PLAY_OPTION_STRING = "1";
    private final String CHECKSCORE_OPTION_STRING = "2";
    private final String ERROR_IN_START_MESSAGE = "Well, there is an error in start..";


    public LottoFacade(InputReceivable inputReciver, WinningNumbersProvider providedWinningNumbersProvider) {
        this.INPUT_RECIVER = inputReciver;
        this.winningNumbersProvider= new LottoNumberGenerator();
        if(providedWinningNumbersProvider!=null) { this.winningNumbersProvider = providedWinningNumbersProvider;}
        this.gameModel = new GameModel(inputReciver, winningNumbersProvider);
        this.scoreChecker = new ScoreChecker(inputReciver);
        this.lottoMenu= new LottoMenu(inputReciver);
    }

    @Override
    public String start() {
        String optionPicked = lottoMenu.ChooseOptionToPlayOrCheckscore();
        switch (optionPicked){
            case PLAY_OPTION_STRING:
                return gameModel.play();
            case CHECKSCORE_OPTION_STRING:
                return scoreChecker.checkScore();
        }
        return ERROR_IN_START_MESSAGE;
    }
}
