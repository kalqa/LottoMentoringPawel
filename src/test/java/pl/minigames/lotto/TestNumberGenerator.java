package pl.minigames.lotto;

import java.util.HashSet;
import java.util.Set;

public class TestNumberGenerator implements WinningNumbersProvider {

    private Set<Integer> drawnNumbers = new HashSet<>();

    public TestNumberGenerator() {
    }

    @Override
    public Set<Integer> drawingNumbers() {
        return drawnNumbers;
    }

    @Override
    public void setResultForTestPurpose(Set<Integer> collect) {
        for (Integer i : collect)
            drawnNumbers.add(i);
    }
}
