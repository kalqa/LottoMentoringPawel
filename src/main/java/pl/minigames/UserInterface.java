package pl.minigames;

public class UserInterface {
    private final IInputReciver INPUT_RECEIVER;
    private final GameChooser gameChooser;

    private final MessagePrinter messagePrinter = new MessagePrinter();
    private final String FINISH_LOOP_CODE = "500";

    public UserInterface(IInputReciver inputReciver) {
        this.INPUT_RECEIVER = inputReciver;
        this.gameChooser = new GameChooser(inputReciver);
    }

    public static void main(String[] args) {
        UserInterface UI = new UserInterface(ScannerInputReciver.getInstance());
        UI.start();
    }

    public String start() {
        boolean loop = true;
        String typed = "";
        while (loop) {
            messagePrinter.welcomeMessege();
            typed = INPUT_RECEIVER.getString();
            if (pickMenuOptions(typed).equals(FINISH_LOOP_CODE)) loop = false;
        }
        messagePrinter.endingMessage();
        return pickMenuOptions(typed);
    }

    private String pickMenuOptions(String command) {
        switch (command) {
            case "1":
                gameChooser.InitializeChoosenGame();
                return FINISH_LOOP_CODE;
            case "2":
                messagePrinter.printGames(gameChooser.getAvailableGames());
                return "";
            case "3":
                return FINISH_LOOP_CODE;
        }
        return "";
    }
}

