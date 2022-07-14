package pl.minigames.lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {

    @Test
    void should_return_six_numbers_drawn() {
        //Given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        //when
        int numbersDrawn = lottoNumberGenerator.drawingNumbers().size();
        //then
        assertEquals(6,numbersDrawn);

    }
}