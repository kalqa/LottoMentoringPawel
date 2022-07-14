package pl.minigames.lotto;

import org.junit.jupiter.api.Test;
import pl.minigames.TestInputReciver;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameModelTest {

    @Test
    void should_return_you_won() {
        //Given
        String[] array = new String[]{"1", "1"};
        int[] ints = new int[]{1, 3, 2, 7, 5, 6};
        WinningNumbersProvider winningNumbersProvider = new TestNumberGenerator();
        GameModel gameModel = new GameModel(new TestInputReciver(array, ints), winningNumbersProvider);
        winningNumbersProvider.setResultForTestPurpose(Arrays.stream(ints)
                .boxed()
                .sorted()
                .collect(Collectors.toSet()));
        //when
        String result = gameModel.play();

        //then
        assertEquals("You won!!!", result);
    }
    @Test
    void should_return_you_loose() {
        //Given
        String[] array = new String[]{"1", "1"};
        int[] ints = new int[]{1, 3, 2, 7, 5, 6};
        WinningNumbersProvider winningNumbersProvider = new TestNumberGenerator();
        GameModel gameModel = new GameModel(new TestInputReciver(array, ints), winningNumbersProvider);
        winningNumbersProvider.setResultForTestPurpose(Arrays.stream(new int[]{12,13,14,15,16,17})
                .boxed()
                .sorted()
                .collect(Collectors.toSet()));
        //when
        String result = gameModel.play();

        //then
        assertEquals("Sorry, it's a loosing game;)", result);
    }
    @Test
    void test_for_lossing_condition_when_not_supported_string_typed() {
        //Given
        String[] array = new String[]{"kadabra","magra","febra","12","1", "1"};
        int[] ints = new int[]{1, 3, 2, 7, 5, 6};
        WinningNumbersProvider winningNumbersProvider = new TestNumberGenerator();
        GameModel gameModel = new GameModel(new TestInputReciver(array, ints), winningNumbersProvider);
        winningNumbersProvider.setResultForTestPurpose(Arrays.stream(new int[]{12,13,14,15,16,17})
                .boxed()
                .sorted()
                .collect(Collectors.toSet()));
        //when
        String result = gameModel.play();

        //then
        assertEquals("Sorry, it's a loosing game;)", result);
    }
}