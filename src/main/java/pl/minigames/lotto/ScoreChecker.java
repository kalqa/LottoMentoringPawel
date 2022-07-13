package pl.minigames.lotto;

import pl.minigames.InputReceivable;

import java.util.Set;

class ScoreChecker {
    InputReceivable inputReciver;
    LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    public static final String TYPE_WITHDRAW_NUMBER = "Type withdraw number";

    public ScoreChecker(InputReceivable inputReciver) {
        this.inputReciver = inputReciver;
    }

    public String checkScore() {
        messagePrinter.printLottoMessage(TYPE_WITHDRAW_NUMBER);
        Set<Integer> retrivedSet = DataLoader.getInstance().getWithDrawalSet(inputReciver.receiveNumberFromUser());
        if (retrivedSet.size() > 0) messagePrinter.printNumbers(retrivedSet);
        return retrivedSet.toString();
    }

}
