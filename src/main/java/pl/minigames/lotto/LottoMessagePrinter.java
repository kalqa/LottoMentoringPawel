package pl.minigames.lotto;

import java.util.Set;


class LottoMessagePrinter {
    private final String CHECKING_MESSAGE = "checking if you won....";
    public static final String NUMBERS_ARE = "Numbers are: ";
    private final String START_GAME_MESSAGE = "Starting your lotto game";
    private final String TYPE_NUMBERS_MESSAGE = "Type numbers from 1-99";
    private final String WRONG_NUMBER_TYPED = "Wrong number typed";

    private final String PICK_START_OPTION_MESSAGE = "Type 1 to start game, Type 2 to check numbers by drawing number";
    private final String ERROR_IN_START_MESSAGE = "Well, there is an error in start..";

    public LottoMessagePrinter() {
    }

    public void printLottoMessage(String s) {
        System.out.println(s);
    }

    public void printWaitingMessage() {
        for (int i = 0; i < 5; i++) {
            printLottoMessage(CHECKING_MESSAGE);
        }
    }

    public void printNumbers(Set<Integer> set) {
        StringBuilder stringBuilder = new StringBuilder(NUMBERS_ARE);
        for (Integer i : set) {
            stringBuilder.append(i);
            stringBuilder.append(";");
        }
        System.out.println(stringBuilder);
    }

    public void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printTypeNumbersMessage() {
        System.out.println(TYPE_NUMBERS_MESSAGE);
    }

    public void printWrongNumberTyped() {
        System.out.println(WRONG_NUMBER_TYPED);
    }
    public void printStartMenuOption(){
        System.out.println(PICK_START_OPTION_MESSAGE);
    }
    public void printErrorInStartMessage(){
        System.out.println(ERROR_IN_START_MESSAGE);
    }


}
