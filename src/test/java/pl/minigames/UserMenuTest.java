package pl.minigames;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UserMenuTest {

    @Test
    public void should_return_exit_option_when_user_want_to_exit() {
        // given
        ScannerInputReceiver scanner = new ScannerInputReceiver();
        MessagePrinter messagePrinter = new MessagePrinter();
        UserMenu userMenu = new UserMenu(scanner, messagePrinter);

        // when
        UserMenuOptions userMenuOptions = userMenu.pickOption();

        // then
        assertThat(userMenuOptions.isExit()).isTrue();
    }

}
