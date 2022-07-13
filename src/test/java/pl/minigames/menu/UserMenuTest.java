package pl.minigames.menu;

import org.junit.jupiter.api.Test;
import pl.minigames.InputReceivable;
import pl.minigames.TestInputReciver;

import static org.assertj.core.api.Assertions.assertThat;

class UserMenuTest {

    @Test
    public void should_return_exit_option_when_user_want_to_exit() {
        //given
        InputReceivable scanner = new TestInputReciver(new String[]{""}, new int[]{2});
        UserMenu userMenu = new UserMenu(scanner);

        // when
        UserMenuOptions userMenuOptions = userMenu.pickOption();

        // then
        assertThat(userMenuOptions.isExit()).isTrue();
    }

    @Test
    public void should_return_initialize_when_user_wants_to_start_game() {
        // given
        InputReceivable scanner = new TestInputReciver(new String[]{""}, new int[]{0});
        UserMenu userMenu = new UserMenu(scanner);

        // when
        UserMenuOptions userMenuOptions = userMenu.pickOption();

        // then
        assertThat(userMenuOptions.isInitialize()).isTrue();
    }
}
