package pl.minigames;

import pl.minigames.menu.UserMenu;
import pl.minigames.utils.MessagePrinter;
import pl.minigames.utils.ScannerInputReceiver;

public class Main {

    public static void main(String[] args) {
        InputReceivable inputReceivable = new ScannerInputReceiver();
        MessagePrinter messagePrinter = new MessagePrinter();
        UserMenu userMenu = new UserMenu(inputReceivable);
        MiniGames miniGames = new MiniGames(inputReceivable, messagePrinter, userMenu, false);
        miniGames.startProgramAndGetFinalGameResult();
    }
}
