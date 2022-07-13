package pl.minigames.chooser;

import org.junit.jupiter.api.Test;
import pl.minigames.InputReceivable;
import pl.minigames.Playable;
import pl.minigames.TestInputReciver;
import pl.minigames.batlleships.BatlleShipsFacade;
import pl.minigames.lotto.LottoFacade;
import pl.minigames.solitare.SolitareFacade;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameChooserTest {

    @Test
    void should_return_playable_object_lotto_when_typed_lotto() {
        //given
        InputReceivable inputReceivable = new TestInputReciver(new String[]{"LOTTO"}, new int[]{});
        GameChooser gameChooser = new GameChooser(inputReceivable, true);
        LottoFacade lottoFacade = new LottoFacade(inputReceivable, false);

        //when
        Playable game = gameChooser.selectingGame();

        //then
        assertEquals(lottoFacade.getClass(), game.getClass());
    }

    @Test
    void should_return_playable_objecy_batleships_when_typed_batleships() {
        //given
        InputReceivable inputReceivable = new TestInputReciver(new String[]{"BATLLESHIPS"}, new int[]{});
        GameChooser gameChooser = new GameChooser(inputReceivable, true);
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
        GameChooser gameChooser = new GameChooser(inputReceivable, true);
        SolitareFacade Facade = new SolitareFacade();

        //when
        Playable game = gameChooser.selectingGame();

        //then
        assertEquals(Facade.getClass(), game.getClass());
    }
}