package pl.minigames.lotto;

import java.util.Set;

class ManualLottoNumbersTest implements IWinningNumbersProvider {

    Set<Integer> result;

    public ManualLottoNumbersTest() {

    }

    public Set<Integer> drawingNumbers() {
        return result;
    }

    @Override
    public void saveNumbers(Set<Integer> set) {

    }

    public void setResultForTestPurpose(Set<Integer> result) {
        this.result = result;
    }
}
