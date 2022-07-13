package pl.minigames;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.minigames.lotto.LottoFacade;
import pl.minigames.menu.UserMenu;
import pl.minigames.utils.MessagePrinter;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class MiniGamesTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void should_return_you_won_in_lotto_game_choosen() {
        String[] array = new String[]{"LOTTO", "1", "1"};
        int[] ints = new int[]{0, 1, 3, 2, 7, 5, 6};
        TestInputReciver testInputReciver = new TestInputReciver(array, ints);
        MiniGames miniGame = new MiniGames(testInputReciver, new MessagePrinter(), new UserMenu(testInputReciver), true);
        LottoFacade facade = new LottoFacade(testInputReciver, true);
        facade.getWinningNumbersProvider().setResultForTestPurpose(Arrays.stream(new int[]{1, 3, 2, 7, 5, 6})
                .boxed()
                .sorted()
                .collect(Collectors.toSet()));
        //when
        String result = miniGame.startProgramAndGetFinalGameResult();

        //then
        assertEquals("You won!!!", result);

    }

    @Test
    void should_return_you_loose_in_lotto_game_choosen() {
        String[] array = new String[]{"LOTTO", "1", "1"};
        int[] ints = new int[]{0, 1, 3, 12, 7, 5, 6};
        TestInputReciver testInputReciver = new TestInputReciver(array, ints);
        MiniGames miniGame = new MiniGames(testInputReciver, new MessagePrinter(), new UserMenu(testInputReciver), true);
        LottoFacade facade = new LottoFacade(testInputReciver, true);
        facade.getWinningNumbersProvider().setResultForTestPurpose(Arrays.stream(new int[]{1, 3, 2, 7, 5, 6})
                .boxed()
                .sorted()
                .collect(Collectors.toSet()));
        //when
        String result = miniGame.startProgramAndGetFinalGameResult();

        //then
        assertNotSame("You won!!!", result);

    }

    @Test
    void should_return_not_ready_in_solitare_game_choosen() {
        String[] array = new String[]{"SOLITARE", "1", "1"};
        int[] ints = new int[]{0, 1, 3, 12, 7, 5, 6};
        TestInputReciver testInputReciver = new TestInputReciver(array, ints);
        MiniGames miniGame = new MiniGames(testInputReciver, new MessagePrinter(), new UserMenu(testInputReciver), true);

        //when
        String result = miniGame.startProgramAndGetFinalGameResult();

        //then
        assertEquals("not ready yet", result);
    }

    @Test
    void should_return_not_ready_in_batlleships_game_choosen() {
        String[] array = new String[]{"BATLLESHIPS"};
        int[] ints = new int[]{0};
        TestInputReciver testInputReciver = new TestInputReciver(array, ints);
        MiniGames miniGame = new MiniGames(testInputReciver, new MessagePrinter(), new UserMenu(testInputReciver), true);

        //when
        String result = miniGame.startProgramAndGetFinalGameResult();

        //then
        assertEquals("not ready yet", result);
    }
}