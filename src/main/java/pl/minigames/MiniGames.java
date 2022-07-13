package pl.minigames;

class MiniGames {

    public static void main(String[] args) {
        ScannerInputReceiver scanner = new ScannerInputReceiver();
        MessagePrinter messagePrinter = new MessagePrinter();
        UserMenu userInterface = new UserMenu(scanner, messagePrinter);
        UserMenuOptions selectedOptionFromUser = userInterface.pickOption();
        if (selectedOptionFromUser.isExit()) {
            return;
        }

        GameInicializer gameInicializer = new GameInicializer(scanner, selectedOptionFromUser);
    }
}

