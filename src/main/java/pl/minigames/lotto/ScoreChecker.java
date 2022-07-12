package pl.minigames.lotto;

import pl.minigames.IInputReciver;

import java.util.Set;

class ScoreChecker {
    IInputReciver inputReciver;
    LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    public static final String TYPE_WITHDRAW_NUMBER = "Type withdraw number";

    public ScoreChecker(IInputReciver inputReciver) {
        this.inputReciver = inputReciver;
    }
    public String checkScore() {
        messagePrinter.printLottoMessage(TYPE_WITHDRAW_NUMBER);
        Set<Integer> retrivedSet = DataLoader.getInstance().getWithDrawalSet(inputReciver.getInt());
        if (retrivedSet.size() > 0) messagePrinter.printNumbers(retrivedSet);
        return retrivedSet.toString();
    }

}
