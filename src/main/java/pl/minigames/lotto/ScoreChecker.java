package pl.minigames.lotto;

import pl.minigames.InputReceivable;

import java.util.Set;

class ScoreChecker {
    public static final String EMPTY_SET_MSG = "Empty set";
    InputReceivable inputReceiver;
    LottoMessagePrinter messagePrinter = new LottoMessagePrinter();
    public static final String TYPE_WITHDRAW_NUMBER = "Type withdraw number";

    public ScoreChecker(InputReceivable inputReceiver) {
        this.inputReceiver = inputReceiver;
    }

    public String checkScore() {
        messagePrinter.printLottoMessage(TYPE_WITHDRAW_NUMBER);
        Set<Integer> retrivedSet = retriveSetFromFile();
        printSetItAvaiable(retrivedSet);
        return retrivedSet.toString();
    }


    private Set<Integer> retriveSetFromFile() {
        Set<Integer> retrivedSet = DataLoader.getInstance().getWithDrawalSet(inputReceiver.receiveNumberFromUser());
        return retrivedSet;
    }
    private void printSetItAvaiable(Set<Integer> retrivedSet) {
        if (retrivedSet.size() > 0) {
            messagePrinter.printNumbers(retrivedSet);
        } else {
            messagePrinter.printLottoMessage(EMPTY_SET_MSG);
        }
    }


}
