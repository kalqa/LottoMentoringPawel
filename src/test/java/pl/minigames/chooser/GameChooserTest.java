package pl.minigames.chooser;

import org.junit.jupiter.api.Test;
import pl.minigames.InputReceivable;
import pl.minigames.Playable;
import pl.minigames.TestInputReciver;
import pl.minigames.batlleships.BatlleShipsFacade;
import pl.minigames.lotto.LottoFacade;
import pl.minigames.lotto.WinningNumbersProvider;
import pl.minigames.solitare.SolitareFacade;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameChooserTest {

    @Test
    void should_return_playable_object_lotto_when_typed_lotto() {
        //given
        WinningNumbersProvider winningNumbersProvider = null;
        InputReceivable inputReceivable = new TestInputReciver(new String[]{"LOTTO"}, new int[]{});
        GameChooser gameChooser = new GameChooser(inputReceivable, winningNumbersProvider);
        LottoFacade lottoFacade = new LottoFacade(inputReceivable,winningNumbersProvider);

        //when
        Playable game = gameChooser.selectingGame();

        //then
        assertEquals(lottoFacade.getClass(), game.getClass());
    }

    @Test
    void should_return_playable_objecy_batleships_when_typed_batleships() {
        //given
        InputReceivable inputReceivable = new TestInputReciver(new String[]{"BATLLESHIPS"}, new int[]{});
        GameChooser gameChooser = new GameChooser(inputReceivable, null);
        BatlleShipsFacade Facade = new BatlleShipsFacade();

        //when
        Playable game = gameChooser.selectingGame();

        //then
        assertEquals(Facade.getClass(), game.getClass());
    }

    @Test
    void should_return_playable_object_solitare_when_typed_solitare() {
        //given
        InputReceivable inputReceivable = new TestInputReciver(new String[]{"SOLITARE"}, new int[]{});
        GameChooser gameChooser = new GameChooser(inputReceivable, null);
        SolitareFacade Facade = new SolitareFacade();

        //when
        Playable game = gameChooser.selectingGame();

        //then
        assertEquals(Facade.getClass(), game.getClass());
    }
}