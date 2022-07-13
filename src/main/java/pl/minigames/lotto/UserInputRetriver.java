package pl.minigames.lotto;

import pl.minigames.InputReceivable;

import java.util.HashSet;
import java.util.Set;

class UserInputRetriver {
    InputReceivable inputReciver;
    LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    private final String ADDING_TO_SET_MESSAGE = "Great!! I've added: ";
    public static final int MAX_NUMBER_BOUND = 99;
    public static final int MIN_NUMBER_BOUND = 1;
    private Set<Integer> numbersFromUser = new HashSet<>();

    public UserInputRetriver(InputReceivable inputReciver) {
        this.inputReciver = inputReciver;
    }

    public Set<Integer> getNumbersFromUser() {
        messagePrinter.printTypeNumbersMessage();
        try {
            while (numbersFromUser.size() < 6) {
                int number = 0;
                number = inputReciver.receiveNumberFromUser();
                if (numbersFromUser.contains(number)) {
                    messagePrinter.printWrongNumberTyped();
                }
                if (checkIfNumberCanBeAdded(number) && !numbersFromUser.contains(number)) {
                    numbersFromUser.add(number);
                    messagePrinter.printLottoMessage(ADDING_TO_SET_MESSAGE + number);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return numbersFromUser;
    }

    boolean checkIfNumberCanBeAdded(int number) {
        if (number <= MAX_NUMBER_BOUND && number >= MIN_NUMBER_BOUND) return true;
        messagePrinter.printWrongNumberTyped();
        return false;
    }


}
