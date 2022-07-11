package pl.minigames.lotto;

import pl.minigames.IGame;
import pl.minigames.IInputReciver;

import java.util.HashSet;
import java.util.Set;

public class LottoFacade implements IGame {
    public static final int MAX_NUMBER_BOUND = 99;
    public static final int MIN_NUMBER_BOUND = 1;
    public static final String TYPE_WITHDRAW_NUMBER = "Type withdraw number";
    public static final String NUMBERS_ARE = "Numbers are: ";
    private final IInputReciver INPUT_RECIVER;
    private final IWinningNumbersProvider iWinningNumbersProvider;
    private final LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    private final String PICK_START_OPTION_MESSAGE = "Type 1 to start game, Type 2 to check numbers by drawing number";
    private final String START_GAME_MESSAGE = "Starting your lotto game";
    private final String TYPE_NUMBERS_MESSAGE = "Starting your lotto game";
    private final String GENERATING_NUMBERS_MESSAGE = "Generating random numbers";
    private final String WRONG_NUMBER_TYPED = "Wrong number typed";
    private final String PLAY_OPTION_STRING = "1";
    private final String CHECKSCORE_OPTION_STRING = "2";
    private final String WIN_MESSAGE = "You won!!!";
    private final String SCORE_CHECKED_MESSAGE = "Score checked";
    private final String ERROR_IN_START_MESSAGE = "Well, there is an error in start..";
    private final String LOOSE_MESSAGE = "Sorry, it's a loosing game;)";
    private final String CHECKING_MESSAGE = "checking if you won....";
    private final String ADDING_TO_SET_MESSAGE = "Great!! I've added: ";
    private Set<Integer> numbersFromUser = new HashSet<>();
    private Set<Integer> drawnNumbers;

    public LottoFacade(IInputReciver inputReciver, boolean isNoTaTest) {
        this.INPUT_RECIVER = inputReciver;
        this.iWinningNumbersProvider = isNoTaTest == true ? new LottoNumberGenerator() : new ManualLottoNumbersTest();
    }

    @Override
    public String start() {
        messagePrinter.printLottoMessage(PICK_START_OPTION_MESSAGE);
        String optionPicked = "";
        while (!optionPicked.equals(PLAY_OPTION_STRING) || !optionPicked.equals(CHECKSCORE_OPTION_STRING)) {
            optionPicked=pickPlayOrCheckHistoricalNumbers();
            if (optionPicked.equals(PLAY_OPTION_STRING)) return play();
            if (optionPicked.equals(CHECKSCORE_OPTION_STRING)) return checkScore();
        }
        return ERROR_IN_START_MESSAGE;
    }

    private String pickPlayOrCheckHistoricalNumbers() {
        return INPUT_RECIVER.getString();
    }

    private String play() {
        getNumbersFromUser();
        generateWinningNumbers();
        printWaitingMessage();
        printWinOrLooseMassage();
        iWinningNumbersProvider.saveNumbers(drawnNumbers);
        return getWinOrLooseMessage();
    }

    private void printWinOrLooseMassage() {
        messagePrinter.printLottoMessage(getWinOrLooseMessage());
    }

    private String getWinOrLooseMessage() {
        return drawnNumbers.containsAll(numbersFromUser) ? WIN_MESSAGE : LOOSE_MESSAGE;
    }


    private void printWaitingMessage() {
        for (int i = 0; i < 5; i++) {
            messagePrinter.printLottoMessage(CHECKING_MESSAGE);
        }
    }

    private void generateWinningNumbers() {
        messagePrinter.printLottoMessage(GENERATING_NUMBERS_MESSAGE);
        drawnNumbers = getDrawnNumbers();
        printNumbers(drawnNumbers);
    }

    private Set<Integer> getDrawnNumbers() {
        return iWinningNumbersProvider.drawingNumbers();
    }

    public void getNumbersFromUser() {
        messagePrinter.printLottoMessage(START_GAME_MESSAGE);
        messagePrinter.printLottoMessage(TYPE_NUMBERS_MESSAGE);
        try {
            while (numbersFromUser.size() < 6) {
                int number = 0;
                number = INPUT_RECIVER.getInt();
                if (numbersFromUser.contains(number)) {
                    messagePrinter.printLottoMessage(WRONG_NUMBER_TYPED);
                }
                if (checkIfNumberCanBeAdded(number) && !numbersFromUser.contains(number)) {
                    numbersFromUser.add(number);
                    messagePrinter.printLottoMessage(ADDING_TO_SET_MESSAGE + number);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    boolean checkIfNumberCanBeAdded(int number) {
        if (number <= MAX_NUMBER_BOUND && number >= MIN_NUMBER_BOUND) return true;
        messagePrinter.printLottoMessage(WRONG_NUMBER_TYPED);
        return false;
    }

    private String checkScore() {
        messagePrinter.printLottoMessage(TYPE_WITHDRAW_NUMBER);
        Set<Integer> retrivedSet = LottoData.getInstance().getWithDrawalSet(INPUT_RECIVER.getInt());
        if (retrivedSet.size() > 0) printNumbers(retrivedSet);
        return retrivedSet.toString();
    }


    private void printNumbers(Set<Integer> set) {
        StringBuilder stringBuilder = new StringBuilder(NUMBERS_ARE);
        for (Integer i : set) {
            stringBuilder.append(i);
            stringBuilder.append(";");
        }
        System.out.println(stringBuilder);
    }

    public IWinningNumbersProvider getiWinningNumbersProvider() {
        return iWinningNumbersProvider;
    }
}
