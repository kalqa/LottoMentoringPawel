package pl.minigames.lotto;

import pl.minigames.InputReceivable;

class LottoMenu {

    private final LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    private final InputReceivable inputReceivable;
    private final String PICK_START_OPTION_MESSAGE = "Type 1 to start game, Type 2 to check numbers by drawing number";
    private final String PLAY_OPTION_STRING = "1";
    private final String CHECKSCORE_OPTION_STRING = "2";
    private final String ERROR_IN_START_MESSAGE = "Well, there is an error in start..";


    public LottoMenu(InputReceivable inputReceivable) {
        this.inputReceivable = inputReceivable;
    }

    public String ChooseOptionToPlayOrCheckscore() {
        messagePrinter.printLottoMessage(PICK_START_OPTION_MESSAGE);
        String optionPicked = "";
        while (!optionPicked.equals(PLAY_OPTION_STRING) || !optionPicked.equals(CHECKSCORE_OPTION_STRING)) {
            optionPicked = inputReceivable.receiveSignFromUser();
            if (optionPicked.equals(PLAY_OPTION_STRING)) return PLAY_OPTION_STRING;
            if (optionPicked.equals(CHECKSCORE_OPTION_STRING)) return CHECKSCORE_OPTION_STRING;
        }
        return ERROR_IN_START_MESSAGE;
    }
}
