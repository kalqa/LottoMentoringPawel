package pl.minigames;

public class UserInterface {
    private final static GameChooser gameChooser = new GameChooser();
    private final static InputReciver inputReciver = InputReciver.getInstance();
    private final static MessagePrinter messagePrinter = new MessagePrinter();

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            messagePrinter.welcomeMessege();
            loop = optionsPicker(loop, inputReciver.getString());
        }
        messagePrinter.endingMessage();
    }

    private static boolean optionsPicker(boolean loop, String command) {
        switch (command) {
            case "1":
                gameChooser.choose();
                loop = false;
                break;
            case "2":
                messagePrinter.printGames(gameChooser.getAvailableGames());
                break;
            case "3":
                loop = false;
                break;
        }
        return loop;
    }
}

