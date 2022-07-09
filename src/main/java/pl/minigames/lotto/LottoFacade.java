package pl.minigames.lotto;

import pl.minigames.IGame;
import pl.minigames.IInputReciver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoFacade implements IGame {
    private final IInputReciver INPUT_RECIVER;
    private final LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    private final String PICK_START_OPTION_MESSAGE = "Type 1 to start game, Type 2 to check numbers by drawing number";
    private final String START_GAME_MESSAGE = "Starting your lotto game";
    private final String TYPE_NUMBERS_MESSAGE = "Starting your lotto game";
    public LottoFacade(IInputReciver inputReciver) {
        this.INPUT_RECIVER = inputReciver;
    }

    public Set<Integer> getNumbersFromUser() {
        messagePrinter.printLottoMessage(START_GAME_MESSAGE);
        messagePrinter.printLottoMessage(TYPE_NUMBERS_MESSAGE);
        Set<Integer> array = new HashSet<>();
        try {
            while (array.size() < 6) {
                int number = 0;
                number = INPUT_RECIVER.getInt();
                if (array.contains(number)) {
                    System.out.println("You've already typed that number");
                }
                if (numberCanBeAddedChecker(number) && !array.contains(number)) {
                    array.add(number);
                    System.out.println("Great!! I've added: " + number);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return array;
    }

    boolean numberCanBeAddedChecker(int number) {
        if (number < 100 && number > 0) return true;
        System.out.println("wrong number typed");
        return false;
    }

    @Override
    public void start() {
        messagePrinter.printLottoMessage(PICK_START_OPTION_MESSAGE);
        pickPlayOrCheckHistoricalNumbers();
    }

    private void pickPlayOrCheckHistoricalNumbers() {
       String command = INPUT_RECIVER.getString();
            switch (command) {
                case "1":
                    play();
                    break;
                case "2":
                    checkScore();
                    break;
            }

    }

    private String play() {
        Set<Integer> array = getNumbersFromUser();
        System.out.println("Generating random numbers");
        Set<Integer> drawnNumbers = getDrawnNumbers();
        printNumbers(drawnNumbers);
        for (int i = 0; i < 5; i++) {
            System.out.println("checking if you won....");
        }
        System.out.println(drawnNumbers.containsAll(array) ? "You won!!!" : "Sorry it's a loosing game;)");
        return drawnNumbers.containsAll(array) ? "You won!!!" : "Sorry it's a loosing game;)";
    }

    private void checkScore() {
        System.out.println("Type withdraw number");
        try (Scanner sc = new Scanner(System.in)) {
            Integer i = sc.nextInt();
            sc.nextLine();
            System.out.println("Numbers in withdrawal: " + i);
            printNumbers(LottoData.getInstance().getWithDrawalSet(i));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error in checking numbers?");
        }
    }

    private Set<Integer> getDrawnNumbers() {
        IWinningConditions lottoNumberGenerator = new LottoNumberGenerator(); //
        return lottoNumberGenerator.drawingNumbers();
    }

    private void printNumbers(Set<Integer> set) {
        StringBuilder stringBuilder = new StringBuilder("Numbers are: ");
        for (Integer i : set) {
            stringBuilder.append(i);
            stringBuilder.append(";");
        }
        System.out.println(stringBuilder);
    }
}
