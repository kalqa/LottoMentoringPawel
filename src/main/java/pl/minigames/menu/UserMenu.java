package pl.minigames.menu;

import pl.minigames.InputReceivable;

import static pl.minigames.menu.UserMenuOptions.*;

public class UserMenu {

    private final InputReceivable inputReceiver;
    private final MessagePrinter messagePrinter = new MessagePrinter();

    public UserMenu(InputReceivable inputReceiver) {
        this.inputReceiver = inputReceiver;
    }

    public UserMenuOptions pickOption() {
        Integer optionFromUser;
        try {
            while (true) {
                messagePrinter.welcomeMessage();
                optionFromUser = inputReceiver.receiveNumberFromUser();
                UserMenuOptions pickedOption = pickMenuOption(optionFromUser);
                if (!pickedOption.isAvailableGames()) {
                    return pickedOption;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return EXIT;
    }


    private UserMenuOptions pickMenuOption(Integer optionFromUser) {
        UserMenuOptions selectedOption = values()[optionFromUser];
        switch (selectedOption) {
            case INITIALIZE_GAME:
                return INITIALIZE_GAME;
            case AVAILABLE_GAMES:
                return AVAILABLE_GAMES;
            default:
                return EXIT;
        }
    }

}
