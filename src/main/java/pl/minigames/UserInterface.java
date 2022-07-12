package pl.minigames;

public class UserInterface {
    private final IInputReciver INPUT_RECEIVER;
    private final GameInicializer gameInicializer;
    private final MessagePrinter messagePrinter;
    private final String FINISH_LOOP_CODE = "500";

    public UserInterface(IInputReciver inputReciver) {
        this.INPUT_RECEIVER = inputReciver;
        this.gameInicializer = new GameInicializer(inputReciver);
        this.messagePrinter = new MessagePrinter();
    }

    public static void main(String[] args) {
        UserInterface UI = new UserInterface(ScannerInputReciver.getInstance());
        UI.start();
    }

    public void start() {
        boolean loop = true;
        String typed = "";
        while (loop) {
            messagePrinter.welcomeMessege();
            typed = INPUT_RECEIVER.getString();
            if (pickMenuOptions(typed).equals(FINISH_LOOP_CODE)) loop = false;
        }
        messagePrinter.endingMessage();
    }

    private String pickMenuOptions(String command) {
        switch (command) {
            case "1":
                gameInicializer.InitializeGame();
                return FINISH_LOOP_CODE;
            case "2":
                messagePrinter.printGames(new GameChooser(INPUT_RECEIVER).getAvailableGames());
                return "";
            case "3":
                return FINISH_LOOP_CODE;
        }
        return "";
    }
}

