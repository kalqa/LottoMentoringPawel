package pl.minigames;

import static pl.minigames.UserMenuOptions.AVAILABLE_GAMES;
import static pl.minigames.UserMenuOptions.EXIT;
import static pl.minigames.UserMenuOptions.INITIALIZE_GAME;
import static pl.minigames.UserMenuOptions.values;

public class UserMenu {

    private final InputReceivable inputReceiver;
    private final MessagePrinter messagePrinter;
//    private final String FINISH_LOOP_CODE = "500";

    public UserMenu(InputReceivable inputReceiver,
                    MessagePrinter messagePrinter) {
        this.inputReceiver = inputReceiver;
        this.messagePrinter = messagePrinter;
    }

    public UserMenuOptions pickOption() {
        Integer optionFromUser;
        while (true) {
            messagePrinter.welcomeMessage();
            optionFromUser = inputReceiver.receiveNumberFromUser();
            UserMenuOptions pickedOption = pickMenuOption(optionFromUser);
            if (!pickedOption.isAvailableGames()) {
                return pickedOption;
            }
        }
//        messagePrinter.endingMessage();
    }


    private UserMenuOptions pickMenuOption(Integer optionFromUser) {
        UserMenuOptions selectedOption = values()[optionFromUser];
        switch (selectedOption) {
            case INITIALIZE_GAME:
                return INITIALIZE_GAME;
            case AVAILABLE_GAMES:
//                messagePrinter.printGames(new GameChooser(inputReceiver).getAvailableGames());
                return AVAILABLE_GAMES;
            default:
//                System.out.println("sorry not available option");
                return EXIT;
        }
    }
}
