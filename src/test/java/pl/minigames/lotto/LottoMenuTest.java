package pl.minigames.lotto;

import org.junit.jupiter.api.Test;
import pl.minigames.InputReceivable;
import pl.minigames.TestInputReciver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoMenuTest {

    @Test
    void should_return_1_when_typed_option_1() {
        //given
        String[] commands = new String[]{"1"};
        int[] ints = new int[0];
        InputReceivable inputReceivable = new TestInputReciver(commands,ints);
        LottoMenu lottoMenu = new LottoMenu(inputReceivable);
        //when
        String result = lottoMenu.ChooseOptionToPlayOrCheckscore();
        //then
        assertEquals("1",result);
    }
    @Test
    void should_return_2_when_typed_option_2() {
        //given
        String[] commands = new String[]{"2"};
        int[] ints = new int[0];
        InputReceivable inputReceivable = new TestInputReciver(commands,ints);
        LottoMenu lottoMenu = new LottoMenu(inputReceivable);
        //when
        String result = lottoMenu.ChooseOptionToPlayOrCheckscore();
        //then
        assertEquals("2",result);
    }
    @Test
    void should_return_2_when_typed_option_2_after_invalid_input() {
        //given
        String[] commands = new String[]{"51","15","24","2"};
        int[] ints = new int[0];
        InputReceivable inputReceivable = new TestInputReciver(commands,ints);
        LottoMenu lottoMenu = new LottoMenu(inputReceivable);
        //when
        String result = lottoMenu.ChooseOptionToPlayOrCheckscore();
        //then
        assertEquals("2",result);
    }
}