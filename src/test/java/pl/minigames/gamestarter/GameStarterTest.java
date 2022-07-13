package pl.minigames.gamestarter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.minigames.Playable;
import pl.minigames.TestInputReciver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStarterTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void game_is_started_by_gamestarter() {
        //given
        Playable game = new Playable() {
            @Override
            public String start() {
                return "it did start a game";
            }
        };
        GameStarter gameStarter = new GameStarter(new TestInputReciver(new String[]{}, new int[]{}), game);
        //when
        String result = gameStarter.startGame();

        //then
        assertEquals("it did start a game", result);
    }
}