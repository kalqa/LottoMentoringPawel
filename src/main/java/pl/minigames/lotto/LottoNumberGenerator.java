package pl.minigames.lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class LottoNumberGenerator implements IWinningNumbersProvider {
    private final int NUMBERS_TO_DRAW = 6;
    private final int MAX_DRAWN_NUMBER_BOUND =100;
    private final int MIN_DRAWN_NUMBER_BOUND =0;
    private DataLoader dataLoader = DataLoader.getInstance();
    private DataSaver dataSaver = DataSaver.getInstance();
    public LottoNumberGenerator() {
    }

    @Override
    public void setResultForTestPurpose(Set<Integer> collect) {

    }

    public Set<Integer> drawingNumbers() {
        Set<Integer> drawnNumbers = new HashSet<>();
        while (drawnNumbers.size() < NUMBERS_TO_DRAW) {
            Random random = new Random();
            Integer number = random.nextInt(MAX_DRAWN_NUMBER_BOUND);
            if (number > MIN_DRAWN_NUMBER_BOUND && !drawnNumbers.contains(number)) drawnNumbers.add(number);
        }
        return drawnNumbers;
    }

    public void saveNumbers(Set<Integer> set) {
        dataSaver.saveData(set);
    }

}
