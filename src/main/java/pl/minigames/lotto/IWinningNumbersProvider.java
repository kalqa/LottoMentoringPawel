package pl.minigames.lotto;

import java.util.Set;

public interface IWinningNumbersProvider {
    Set<Integer> drawingNumbers();

    void setResultForTestPurpose(Set<Integer> collect);

    void saveNumbers(Set<Integer> set);
}
