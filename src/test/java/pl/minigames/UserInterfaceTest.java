package pl.minigames;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {
    MiniGames userInterface;

    @BeforeEach
    void setUp() {
        String[] array = new String[]{"1", "LOTTO", "1", "1"};
        int[] ints = new int[]{1, 2, 3, 4, 5, 6};
        userInterface = new MiniGames(new TestInputReceiver(array, ints));
    }

    @Test
    void winTextingConditions() {

    }

}
