package pl.minigames.lotto;

import pl.minigames.InputReceivable;

import java.util.HashSet;
import java.util.Set;

class GameModel {
    private final InputReceivable INPUT_RECIVER;
    private final WinningNumbersProvider winningNumbersProvider;
    private final LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    private final UserInputRetriver userInputRetriver;

    private final String GENERATING_NUMBERS_MESSAGE = "Generating random numbers";

    private final String WIN_MESSAGE = "You won!!!";

    private final String LOOSE_MESSAGE = "Sorry, it's a loosing game;)";
    private Set<Integer> numbersFromUser = new HashSet<>();
    private Set<Integer> drawnNumbers;

    public GameModel(InputReceivable INPUT_RECIVER, WinningNumbersProvider winningNumbersProvider) {
        this.INPUT_RECIVER = INPUT_RECIVER;
        this.winningNumbersProvider = winningNumbersProvider;
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
        winningNumbersProvider.saveNumbers(drawnNumbers);
        return getWinOrLooseMessage();
    }

    private String getWinOrLooseMessage() {
        return drawnNumbers.containsAll(numbersFromUser) ? WIN_MESSAGE : LOOSE_MESSAGE;
    }

    private void generateWinningNumbers() {
        drawnNumbers = winningNumbersProvider.drawingNumbers();
    }
}
