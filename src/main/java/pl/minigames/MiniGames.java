package pl.minigames;

import pl.minigames.chooser.GameChooser;
import pl.minigames.gamestarter.GameStarter;
import pl.minigames.menu.UserMenu;
import pl.minigames.menu.UserMenuOptions;
import pl.minigames.utils.MessagePrinter;

class MiniGames {

    InputReceivable scanner;
    MessagePrinter messagePrinter;
    UserMenu userMenu;
    GameChooser gameChooser;
    GameStarter gameStarter;
    Boolean testMode;

    public MiniGames(InputReceivable scanner, MessagePrinter messagePrinter, UserMenu userMenu, boolean testMode) {
        this.scanner = scanner;
        this.messagePrinter = messagePrinter;
        this.userMenu = userMenu;
        this.testMode = testMode;
        this.gameChooser = new GameChooser(scanner, testMode);
    }

    public String startProgramAndGetFinalGameResult() {

        UserMenuOptions selectedOptionFromUser = userMenu.pickOption();
        if (selectedOptionFromUser.isExit()) {
            return "End Program";
        }
        if (selectedOptionFromUser.isAvailableGames()) {
            messagePrinter.printGames(gameChooser.getAvailableGames());
            return "continue";
        }
        if (selectedOptionFromUser.isInitialize()) {
            Playable game = gameChooser.selectingGame();
            gameStarter = new GameStarter(scanner, game);
            String gameResult = gameStarter.startGame();
            return gameResult;
        }
        return "Error";
    }
}

