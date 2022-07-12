package pl.minigames.lotto;

import pl.minigames.IInputReciver;

import java.util.HashSet;
import java.util.Set;

class GameModel {
    private final IInputReciver INPUT_RECIVER;
    private final IWinningNumbersProvider iWinningNumbersProvider;
    private final LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    private final UserInputRetriver userInputRetriver;

    private final String GENERATING_NUMBERS_MESSAGE = "Generating random numbers";

    private final String WIN_MESSAGE = "You won!!!";

    private final String LOOSE_MESSAGE = "Sorry, it's a loosing game;)";
    private Set<Integer> numbersFromUser = new HashSet<>();
    private Set<Integer> drawnNumbers;

    public GameModel(IInputReciver INPUT_RECIVER, IWinningNumbersProvider iWinningNumbersProvider) {
        this.INPUT_RECIVER = INPUT_RECIVER;
        this.iWinningNumbersProvider = iWinningNumbersProvider;
        this.userInputRetriver = new UserInputRetriver(INPUT_RECIVER);
    }

    public String play() {
        messagePrinter.printStartGameMessage();
        numbersFromUser = userInputRetriver.getNumbersFromUser();
        messagePrinter.printLottoMessage(GENERATING_NUMBERS_MESSAGE);
        generateWinningNumbers();
        messagePrinter.printNumbers(drawnNumbers);
        messagePrinter.printWaitingMessage();
        messagePrinter.printLottoMessage(getWinOrLooseMessage());
        iWinningNumbersProvider.saveNumbers(drawnNumbers);
        return getWinOrLooseMessage();
    }

    private String getWinOrLooseMessage() {
        return drawnNumbers.containsAll(numbersFromUser) ? WIN_MESSAGE : LOOSE_MESSAGE;
    }

    private void generateWinningNumbers() {
        drawnNumbers = iWinningNumbersProvider.drawingNumbers();
    }
}
