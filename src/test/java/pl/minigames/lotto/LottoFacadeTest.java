package pl.minigames.lotto;

import org.junit.jupiter.api.Test;
import pl.minigames.TestInputReciver;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoFacadeTest {


    LottoFacade lottoFacade;


    @Test
    void when_sets_are_equal_should_return_win_message() {
        //Given
        String[] array = new String[]{"1", "1"};
        int[] ints = new int[]{1, 3, 2, 7, 5, 6};
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator();
        LottoFacade facade = new LottoFacade(new TestInputReciver(array, ints),testNumberGenerator);
        testNumberGenerator.setResultForTestPurpose(Arrays.stream(ints)
                .boxed()
                .sorted()
                .collect(Collectors.toSet()));
        //when
        String result = facade.start();

        //then
        assertEquals("You won!!!", result);
    }

    @Test
    void when_sets_are_unequal_should_return_loose_message() {
        //Given
        String[] array = new String[]{"1", "1"};
        int[] ints = new int[]{1, 3, 2, 7, 5, 6};
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator();
        LottoFacade facade = new LottoFacade(new TestInputReciver(array, ints),testNumberGenerator);
        testNumberGenerator.setResultForTestPurpose(Arrays.stream(new int[]{7, 8, 9, 10, 11, 12})
                .boxed()
                .sorted()
                .collect(Collectors.toSet()));
        //when
        String result = facade.start();

        //then
        assertEquals("Sorry, it's a loosing game;)", result);
    }

    @Test
    void should_return_numbers_from_base_with_given_index() {
        //Given
        String[] array = new String[]{"2", "0"};
        int[] ints = new int[]{1, 3, 2, 7, 5, 6};
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator();
        LottoFacade facade = new LottoFacade(new TestInputReciver(array, ints),testNumberGenerator);

        //when
        String result = facade.start();

        //then
        assertEquals("[99, 35, 38, 55, 9, 44]", result);
    }

    @Test
    void should_return_empty_set_when_index_out_of_bounds() {
        //Given
        String[] array = new String[]{"2", "0"};
        int[] ints = new int[]{77, 3, 2, 7, 5, 6};
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator();
        LottoFacade facade = new LottoFacade(new TestInputReciver(array, ints), testNumberGenerator);

        //when
        String result = facade.start();

        //then
        assertEquals("[]", result);
    }
}
