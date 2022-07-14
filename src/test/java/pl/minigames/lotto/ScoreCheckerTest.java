package pl.minigames.lotto;

import org.junit.jupiter.api.Test;
import pl.minigames.TestInputReciver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCheckerTest {

    @Test
    void should_return_numbers_from_base_with_given_index() {
        //Given

        String[] array = new String[]{"2", "0"};
        int[] ints = new int[]{1};
        TestInputReciver testInputReciver = new TestInputReciver(array,ints);
        ScoreChecker scoreChecker = new ScoreChecker(testInputReciver);

        //when
        String result = scoreChecker.checkScore();

        //then
        assertEquals("[99, 35, 38, 55, 9, 44]", result);
    }

    @Test
    void should_return_empty_set_when_index_out_of_bounds() {
        //Given
        String[] array = new String[]{""};
        int[] ints = new int[]{77};
        TestInputReciver testInputReciver = new TestInputReciver(array,ints);
        ScoreChecker scoreChecker = new ScoreChecker(testInputReciver);

        //when
        String result = scoreChecker.checkScore();

        //then
        assertEquals("[]", result);
    }
}