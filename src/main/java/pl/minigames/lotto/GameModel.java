package pl.minigames.lotto;

import pl.minigames.InputReceivable;

import java.util.HashSet;
import java.util.Set;

class GameModel {
    private final InputReceivable inputReceivable;
    private final WinningNumbersProvider winningNumbersProvider;
    private final LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    private final UserInputRetriver userInputRetriver;
    private final LottoMenu lottoMenu;
    private final DataSaver dataSaver = DataSaver.getInstance();

    private final String GENERATING_NUMBERS_MESSAGE = "Generating random numbers";

    private final String WIN_MESSAGE = "You won!!!";

    private final String LOOSE_MESSAGE = "Sorry, it's a loosing game;)";
    private Set<Integer> numbersFromUser = new HashSet<>();
    private Set<Integer> drawnNumbers;

    public GameModel(InputReceivable inputReceivable, WinningNumbersProvider winningNumbersProvider) {
        this.inputReceivable = inputReceivable;
        this.winningNumbersProvider = winningNumbersProvider;
        this.userInputRetriver = new UserInputRetriver(inputReceivable);
        this.lottoMenu=new LottoMenu(inputReceivable);
    }

    public String play() {
        messagePrinter.printStartGameMessage();
        numbersFromUser = userInputRetriver.getNumbersFromUser();
        messagePrinter.printLottoMessage(GENERATING_NUMBERS_MESSAGE);
        generateWinningNumbers();
        messagePrinter.printNumbers(drawnNumbers);
        messagePrinter.printWaitingMessage();
        messagePrinter.printLottoMessage(getWinOrLooseMessage());
        if(winningNumbersProvider.getClass().equals(LottoNumberGenerator.class)){
            dataSaver.saveData(drawnNumbers);}
        return getWinOrLooseMessage();
    }

    private String getWinOrLooseMessage() {
        return drawnNumbers.containsAll(numbersFromUser) ? WIN_MESSAGE : LOOSE_MESSAGE;
    }

    private void generateWinningNumbers() {
        drawnNumbers = winningNumbersProvider.drawingNumbers();
    }
}
