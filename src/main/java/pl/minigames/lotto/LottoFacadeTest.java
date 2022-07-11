package pl.minigames.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.minigames.IInputReciver;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoFacadeTest {
    String[] array = new String[2];
    int[] ints = new int[6];

    LottoFacade lottoFacade;
    @BeforeEach
    void setUp(){
        IInputReciver inputReciver = new TestInputReciver(array,ints);
        lottoFacade = new LottoFacade(inputReciver,false);
        String x ="[50, 9, 59, 27, 28, 63]";
    }

    @Test
    void startGameTest() {
       array[0] ="1";
       array[1] ="1";
       ints[0]=1;
        ints[1]=2;
        ints[2]=3;
        ints[3]=4;
        ints[4]=5;
        ints[5]=6;
        lottoFacade.getiWinningNumbersProvider().setResultForTestPurpose(Arrays.stream(ints).boxed().collect(Collectors.toSet()));
       String result = lottoFacade.start();
       assertEquals("You won!!!",result);
    }
    @Test
    void startChooseScoreTest() {
        array[0] ="2";
        array[1] ="0";
        ints[0]=1;
        String result = lottoFacade.start();
        assertEquals("[99, 35, 38, 55, 9, 44]",result);
    }
    @Test
    void chooseScoreTestOutOfBounds() {
        array[0] ="2";
        array[1] ="77";
        ints[0]=77;
        String result = lottoFacade.start();
        assertEquals("[]",result);
    }
}