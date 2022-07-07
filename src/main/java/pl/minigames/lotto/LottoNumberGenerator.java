package pl.minigames.lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class LottoNumberGenerator {
    public LottoNumberGenerator() {
    }
    public Set<Integer> drawingNumbers() {
        Set<Integer> drawnNumbers = new HashSet<>();
        while(drawnNumbers.size()<6){
            Random random = new Random();
            Integer number = random.nextInt(100);
            if(number>0&&!drawnNumbers.contains(number)) drawnNumbers.add(number);
        }
    saveNumbers(drawnNumbers);
    return drawnNumbers;
    }
    private void saveNumbers(Set<Integer> set){
    LottoData lottoData = LottoData.getInstance();
    lottoData.saveData(set);
    }

}
