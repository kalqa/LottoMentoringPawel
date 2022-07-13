package pl.minigames.lotto;

import java.util.HashSet;
import java.util.Set;

public interface WinningNumbersProvider {
    Set<Integer> drawnNumbers = new HashSet<>();

    Set<Integer> drawingNumbers();

    void setResultForTestPurpose(Set<Integer> collect);

    void saveNumbers(Set<Integer> set);
}
